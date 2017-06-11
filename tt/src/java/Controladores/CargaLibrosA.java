/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.LibroDAO;
import Modelos.Libro;
import java.util.List;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/masLA")
public class CargaLibrosA {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String enviaLibrosA(@RequestParam("ida") int ida, @RequestParam("pag") int pag) {
        LibroDAO dao = new LibroDAO();
        List<Libro> libros;
        Libro libro = new Libro();
        libros = dao.obtenLibroAutor(ida, pag, 4);
        int tam = libros.size();
        String res = String.valueOf(tam);       
        if (tam>0) {
            for (int i = 0; i < tam; i++) {
                libro = libros.get(i);
                res += "|" + libro.getIdLibro() + "|" + libro.getNombre() + "|" + libro.getPortada();                 
            }
        }else{
            return "0";
        }
        return res;
    }
}
