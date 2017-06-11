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
 */
@Controller
@RequestMapping("/recientes")
public class ControladorRecientes {

    LibroDAO dao = new LibroDAO();
    List<Libro> libros;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Libro> enviaRecientes(@RequestParam("pagina") int pagina, Locale locale) {
        if (locale.getLanguage() == "es") {
            libros = dao.buscaRecientes("Español", pagina, 8);
        } else {
            libros = dao.buscaRecientes("Ingles", pagina, 8);
        }
        return libros;
    }

}
