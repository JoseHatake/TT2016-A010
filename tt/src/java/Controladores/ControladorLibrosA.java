/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.LibroDAO;
import Modelos.Libro;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lock
 * Controlador que se encarga de enviar los libros del autor
 */
@Controller
@RequestMapping("/LibrosA")
public class ControladorLibrosA {

    LibroDAO dao = new LibroDAO();
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Libro> mandaLibrosA(@RequestParam("idAutor") int id, @RequestParam("pagina") int pagina){
        List<Libro> libros;
        libros = dao.obtenLibroAutor(id,pagina,4);
        return libros;
        
    }
    
    

}
