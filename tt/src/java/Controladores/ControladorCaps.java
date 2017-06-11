/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CapituloDAO;
import Modelos.Capitulo;
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
@RequestMapping("/capitulos")
public class ControladorCaps {

    CapituloDAO dao = new CapituloDAO();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Capitulo> validaPseudo(@RequestParam("idLibro") int id) {
        List<Capitulo> caps;
        caps = dao.obtenCapitulosLibro(id);
        return caps;
    }

}
