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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lock Controlador encargado de enviar los libros que se encuentren con
 * una busqueda de forma paginada
 */
@Controller
@RequestMapping("/busqueda")
public class ControladorBusqueda {

    LibroDAO dao = new LibroDAO();
    List<Libro> libros;

    public List<Libro> enviaRecientes(@RequestParam("pagina") int pagina, @RequestParam("busqueda") String busqueda) {
        libros = dao.obtenLibroBusqueda(busqueda, pagina, 8);

        return libros;
    }

}
