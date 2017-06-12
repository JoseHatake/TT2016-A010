package Controladores;

import DAO.LibroDAO;
import DAO.SeguirDAO;
import Modelos.Libro;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import utilidades.Correo;
import utilidades.GuardarArchivo;
import utilidades.MensajeNotificacion;
import utilidades.Rutas;

@Controller
public class ControladorNuevoLibro {

    private ServletFileUpload servletFileUpload;

    @RequestMapping("controladorNuevoLibro")
    public String uploadMultipleFileHandler(@RequestParam("files[]") MultipartFile[] files, @RequestParam("tituloLibro") String titulo, @RequestParam("sinopsis") String sinopsis, @RequestParam("genero[]") String[] genero, @RequestParam("idioma") String idioma, Model model, HttpServletRequest request, HttpSession ses) throws IOException {
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        Correo cor = new Correo();
        MensajeNotificacion noti = new MensajeNotificacion();
        SeguirDAO dao = new SeguirDAO();
        List<String> correos;
        String asunto;
        String msj;
        String encabezado;
        String url;
        String idUser = String.valueOf(su.getId());

        
//"/Portadas/ULC.jpg"
        String rutaArchivos = idUser + "/" + titulo;
        if (GuardarArchivo.crearCarpeta(rutaArchivos)) {
            if (GuardarArchivo.guardarPortada(files[0], rutaArchivos)) {
                String tipo = ((files[0].getContentType().toString()).split("/"))[1];
                String generos = "";
                for (int i = 0; i < genero.length; i++) {
                    if (i == genero.length - 1) {
                        generos += genero[i];
                    } else {
                        generos += genero[i] + ",";
                    }

                }
                Libro libro = new Libro(titulo, generos, sinopsis, idioma, rutaArchivos + "/Portada." + tipo, 0, 1, su.getId(), Date.from(new Date().toInstant()));
                LibroDAO lib = new LibroDAO();
                boolean resultadoBD = lib.guardaLibro(libro);

                if (resultadoBD == true) {
                    /* if (GuardarArchivo.guardar(files, titulo)) {
                        return "registrarCapitulo";
                    } else {
                        return "fail";
                    }*/
                    request.getSession().setAttribute("libro", libro);
                    System.out.println("*****&&& NOMBRE LIBRO " + titulo);
                    System.out.println("REGISTRADO CORRECTAMENTE");
                    correos = dao.obtenCorreoAutores(su.getId());
                    url = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/perfildelibro.htm?id="+libro.getIdLibro();
                    if (!correos.isEmpty()) {
                        if (idioma.equals("es")) {
                            asunto = "Una nueva obra ha sido publicada";
                            encabezado = su.getPseudonimo() + " ha publicado su obra " + titulo;
                            msj = noti.creaEspañol(encabezado, titulo, sinopsis, url);
                        } else {
                            asunto = "A new work has been published";
                            encabezado = su.getPseudonimo() + " has published a new work " + titulo;
                            msj = noti.creaIngles(encabezado, titulo, sinopsis, url);
                        }
                        
                        for(int i=0; i<correos.size();i++){
                            String actual = correos.get(i);
                            cor.enviarCorreo(actual, asunto, msj);
                        }
                    }
                    
                    return "registrarCapitulo";
                } else {
                    return "fail";
                }
            } else {
                return "controladorNuevoLibro";
            }
        } else {
            return "controladorNuevoLibro";
        }
        // return "registrarCapitulo";
    }

    // @RequestMapping("subirarchivos")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            System.out.println("**** MULTI PART CONTENT *****" + servletFileUpload.isMultipartContent(request));
            if (servletFileUpload.isMultipartContent(request)) {

                // List fileItemsList = servletFileUpload.parseRequest(request);
                List<FileItem> fileItemsList = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                System.out.println("***** fileItemsList " + fileItemsList.size());
                Iterator it = fileItemsList.iterator();
                while (it.hasNext()) {
                    FileItem archivoActual = (FileItem) it.next();
                    // File archivoActual = (File) it.next();
                    String nombre = archivoActual.getName();
                    System.out.println("COPIANDO");

                    File archivoADisco = new File(nombre);
                    archivoADisco = new File("/Users/yosgs/Documents/testArchivos/" + archivoADisco.getName());
                    archivoActual.write(archivoADisco);
                    System.out.println("ARCHIVO GUARDADO");

                    /* try (OutputStream os = new FileOutputStream(new File("/Users/yosgs/Documents/testArchivos/"+nombre))) {
                        Path path = archivoActual.toPath();
                        Files.copy(path,os);
                        
                    } catch (IOException ex) {
                        System.err.println("ERROR AL COPIAR");
                        ex.printStackTrace();
                    }*/
                }
            }

        } catch (FileUploadException ex) {
            System.err.println("No se ha podido guardar los archivos 1.");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("No se ha podido guardar los archivos 2.");
            ex.printStackTrace();
        }

        return new ModelAndView(
                "exito");
    }

    public void setServletFileUpload(ServletFileUpload servletFileUpload) {
        this.servletFileUpload = servletFileUpload;
    }
}
