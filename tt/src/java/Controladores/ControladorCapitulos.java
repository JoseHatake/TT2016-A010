/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CapituloDAO;
import DAO.LibroDAO;
import Modelos.Capitulo;
import Modelos.Libro;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import utilidades.GuardarArchivo;

/**
 *
 * @author yosgs
 */
@Controller
public class ControladorCapitulos {

    private ServletFileUpload servletFileUpload;

    @RequestMapping("controladorAgregarCapitulos")
    public ModelAndView uploadMultipleFileHandler(@RequestParam("files[]") MultipartFile[] files, @RequestParam("tituloCapitulo[]") String[] tituloCap, @RequestParam("numero[]") String[] numeroCap, Model model, HttpServletRequest request, HttpSession ses) throws UnsupportedEncodingException {
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        ModelAndView modelo = new ModelAndView("redirect:/pAutorL.htm");;
        System.out.println("TAMANIO DEL ARCH " + files.length);
        System.out.println("User. " + request.getSession().getAttribute("user"));
        request.setCharacterEncoding("UTF-8");
        String idUser = String.valueOf(su.getId());
        Libro libro = (Libro) request.getSession().getAttribute("libro");
        String rutaLibro = idUser + "/" + libro.getNombre() + "/";
        String resultado = "";
        if (GuardarArchivo.guardarCapitulos(files, tituloCap, numeroCap, rutaLibro)) {
            for (int i = 0; i < files.length; i++) {
                Capitulo capitulo = new Capitulo(tituloCap[i], Integer.valueOf(numeroCap[i]), rutaLibro + "Cap" + numeroCap[i] + "_" + tituloCap[i] + ".pdf", libro.getIdLibro(), Date.from(new Date().toInstant()));
                CapituloDAO dao = new CapituloDAO();
                if (dao.guardaCapitulo(capitulo)) {
                    System.out.println("TITULO CAPITULO" + capitulo.getNombre());
                    System.out.println("Guardado");
                    modelo = new ModelAndView("redirect:/pAutorL.htm");
                } else {
                    System.out.println("FAIL BD");
                    modelo=new ModelAndView("fail");
                    resultado = "fail";
                }
            }
        } else {
            System.out.println("FAIL ERROR ARCHIVOS");
            modelo=new ModelAndView("fail");
        }
        return modelo;
    }
}
