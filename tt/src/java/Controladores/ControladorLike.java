/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.LibroDAO;
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
@RequestMapping("/like")
public class ControladorLike {
    LibroDAO dao = new LibroDAO();
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public void darLike(@RequestParam("idLibro") int id){
        dao.masLikes(id);
    }

}
