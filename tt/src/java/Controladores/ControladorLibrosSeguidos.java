/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.LibroDAO;
import DAO.SeguirDAO;
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
 * Controlador encargado de enviar las obras seguidas por el usuario de manera paginada (8 por pagina)
 */
@Controller
@RequestMapping("/Lseguidos")
public class ControladorLibrosSeguidos {

    SeguirDAO dao = new SeguirDAO();
    List<Libro> libros;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Libro> enviaLibrosSeguidos(@RequestParam("pagina") int pagina, @RequestParam("idSeguidor") int id) {

        libros = dao.obtenLibrosSeguidos(id, pagina, 8);

        return libros;
    }

}
