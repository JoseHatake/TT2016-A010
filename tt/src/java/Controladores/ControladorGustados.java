/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.LibroDAO;
import Modelos.Libro;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lock
 * Controlador que se encarga de enviar los libros mas gustados de manera paginada
 */
@Controller
@RequestMapping("/gustados")
public class ControladorGustados {

    LibroDAO dao = new LibroDAO();
    List<Libro> libros;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Libro> enviaGustados(@RequestParam("pagina") int pagina, Locale locale) {
        if (locale.getLanguage() == "es") {
            libros = dao.buscaGustados("Español", pagina,8);
        } else {
            libros = dao.buscaGustados("Ingles", pagina,8);
        }
        return libros;
    }

}
