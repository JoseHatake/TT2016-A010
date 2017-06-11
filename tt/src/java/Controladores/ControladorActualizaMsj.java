/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CuentaDAO;
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
@RequestMapping("/actualizaMsj")
public class ControladorActualizaMsj {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String actualizaMsj(@RequestParam("msj") String msj, HttpSession ses) {
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        CuentaDAO dao = new CuentaDAO();        
        if (dao.actualizaMensaje(su.getId(), msj)) {
            return "si";
        } else {
            return "no";
        }

    }

}
