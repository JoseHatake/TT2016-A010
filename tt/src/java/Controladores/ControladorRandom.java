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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lock
 * Controlador que se encarga de enviar una selección de obras al azar en un determinado idioma
 */
@Controller
@RequestMapping("/random")
public class ControladorRandom {

    LibroDAO dao = new LibroDAO();
    List<Libro> libros;
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Libro> enviaRandom(Locale locale){
        if(locale.getLanguage()=="es"){
            libros=dao.buscaRandom("Español",8);
        }else{
            libros=dao.buscaRandom("Ingles",8);
        }
        return libros;
    }

}
