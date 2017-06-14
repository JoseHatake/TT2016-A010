/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CuentaDAO;
import Modelos.Cuenta;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utilidades.Utilidades;

/**
 *
 * @author Lock
 */
@Controller
@RequestMapping("/CambiaPass.htm")
public class ControladorCambiarContraseña {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargaCambiaPass(HttpSession ses) {
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        ModelAndView model = new ModelAndView("CambiaPass");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView cambiaPass(@RequestParam("newpass") String newpass, @RequestParam("pass") String pass, HttpSession ses, Locale locale) {
        ModelAndView model = new ModelAndView("CambiaPass");
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        Utilidades util = new Utilidades();
        CuentaDAO dao = new CuentaDAO();
        Cuenta cuenta = new Cuenta();
        cuenta = dao.obtenCuenta(su.getId());
        int phash = util.hash(pass);
        if (phash == cuenta.getPassword()) {
            phash = util.hash(newpass);
            if (dao.actualizaPassword(su.getId(), phash)) {
                model.addObject("color", "green");
                if (locale.getLanguage() == "es") {
                    model.addObject("mensaje", "Contraseña cambiada con exito");
                } else {
                    model.addObject("mensaje", "Password successfully updated");
                }
            } else {
                model.addObject("color", "red");
                if (locale.getLanguage() == "es") {
                    model.addObject("mensaje", "La contraseña no pudo actualizarse, por favor intente de nuevo más tarde");
                } else {
                    model.addObject("mensaje", "Password coul not be updated, please try again later");
                }
            }
        } else {
            model.addObject("color", "red");
            if (locale.getLanguage() == "es") {
                model.addObject("mensaje", "La contraseña actual es incorrecta");
            } else {
                model.addObject("mensaje", "Current Password is incorrect");
            }

        }
        return model;
    }

}
