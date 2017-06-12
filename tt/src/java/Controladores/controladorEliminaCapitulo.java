/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CapituloDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hatake
 */
@Controller
@RequestMapping("/eliminaCapitulo")
public class controladorEliminaCapitulo {
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String eliminaCap(@RequestParam("idCapitulo") String idCapitulo) {
        CapituloDAO dao = new CapituloDAO();
        Boolean flag = false;
        Integer capitulo = Integer.parseInt(idCapitulo);
        flag = dao.eliminaCapitulo(capitulo);
        return flag + "";
    }
}
