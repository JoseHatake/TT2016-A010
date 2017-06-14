/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CapituloDAO;
import DAO.CuentaDAO;
import DAO.LibroDAO;
import Modelos.Capitulo;
import Modelos.Cuenta;
import Modelos.Libro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utilidades.GuardarArchivo;
import utilidades.Rutas;

/**
 *
 * @author hatake
 */
@Controller
@RequestMapping("/perfildelibro")
public class ControladorPerfilLibro {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargaPerfilLibro(@RequestParam("idLibro") int idLibro, HttpSession ses, HttpServletRequest request) throws UnsupportedEncodingException, IOException {
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        Integer perfilUsuario;
        ModelAndView model;
        Libro perfil = new Libro();
        Cuenta cuenta = new Cuenta();
        List<Capitulo> capitulos = new ArrayList<>();
        LibroDAO consultorLibro = new LibroDAO();
        CuentaDAO cuentaDao = new CuentaDAO();
        CapituloDAO capituloDao = new CapituloDAO();
        byte[] img = null;
        String imagenPortada, imagenAutor;
        ArrayList<String> cap = new ArrayList<>();

        model = new ModelAndView("perfildelibro");
        perfil = consultorLibro.obtenLibro(idLibro);
        cuenta = cuentaDao.obtenCuenta(perfil.getUsuario_idUsuario());

        img = GuardarArchivo.leerImagenes(perfil.getPortada());
        imagenPortada = new String(img, "UTF-8");

        img = GuardarArchivo.leerImagenes(cuenta.getFoto());
        imagenAutor = new String(img, "UTF-8");

        String url = request.getServletContext().getRealPath("/");
        capitulos = capituloDao.obtenCapitulosLibro(idLibro);
        copiarArchivoGeneraRuta(capitulos, url);

        if (su.IsAdmin) {
            perfilUsuario = 1;
        } else if (su.getId() != 0) {
            perfilUsuario = 2;
        } else {
            perfilUsuario = 0;
        }

        model.addObject("libro", perfil);
        model.addObject("autor", cuenta);
        model.addObject("portada", imagenPortada);
        model.addObject("foto", imagenAutor);
        model.addObject("capitulos", capitulos);
        model.addObject("perfil", String.valueOf(perfilUsuario));
        ses.setAttribute("libro", perfil);
        return model;
    }

    public void copiarArchivoGeneraRuta(List<Capitulo> capitulos, String url) throws FileNotFoundException, IOException {
        File fileIn = null;
        File fileOut = null;
        InputStream in = null;
        OutputStream out = null;
        String nombrePDF = null;
        byte[] buf = new byte[1024];
        int len;
        String[] carpetas = null;
        String archivoOrigen = null;
        String archvioDestino = null;
        String urlTMP = "";
        carpetas = capitulos.get(0).getCapitulo().split("/");
        
        urlTMP = url;
        urlTMP += carpetas[0] + "/" + carpetas[1] + "/";
        
        fileIn = new File(urlTMP);//Crea el direcotrio temporal
        fileIn.mkdirs();//Crea el directorio temporal

        Rutas ruta = null;
        for (Capitulo capitulo : capitulos) {
            nombrePDF = capitulo.getCapitulo();
            archivoOrigen = ruta.rutaArchivos + nombrePDF;
            archvioDestino = url + nombrePDF;
            
            fileIn = new File(archivoOrigen);
            fileOut = new File(archvioDestino);
            
            in = new FileInputStream(fileIn);
            out = new FileOutputStream(fileOut);
            
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
        in.close();
        out.close();
    }
}
