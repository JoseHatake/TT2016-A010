/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CuentaDAO;
import DAO.SeguirDAO;
import Modelos.Cuenta;
import Modelos.Seguir;
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
@RequestMapping("/dejarDeSeguir")
public class ControladorDejarDeSeguirA {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String agregaSeguir(@RequestParam("ids") int ids, HttpSession ses) {

        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        SeguirDAO dao = new SeguirDAO();
        CuentaDAO cdao = new CuentaDAO();
        Cuenta cuenta = new Cuenta();
        if (dao.dejarDeSeguirAutor(su.getId(), ids)) {
            cdao.actualizaMenosSeguidores(ids);
            cuenta = cdao.obtenCuenta(ids);
            return String.valueOf(cuenta.getNumSeguidores());
        } else {
            return "no";
        }
    }

}
