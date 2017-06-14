/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CuentaDAO;
import Modelos.Cuenta;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utilidades.Correo;
import utilidades.MensajeRestaurarContraseña;
import utilidades.Utilidades;

/**
 *
 * @author Lock
 */
@Controller
@RequestMapping("/RestaurarContra")
public class ControladorRestaurarContraseña {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView RContra() {
        ModelAndView model = new ModelAndView("RestaurarContra");
        return model;

    }

    @RequestMapping(params = "rcon", method = RequestMethod.POST)
    public ModelAndView restauraContraseña(@RequestParam("mail") String mail, Locale locale) {
        ModelAndView model;
        Utilidades util = new Utilidades();
        Correo cor = new Correo();
        MensajeRestaurarContraseña mrc = new MensajeRestaurarContraseña();
        CuentaDAO dao = new CuentaDAO();
        Cuenta cu = new Cuenta();
        List<Cuenta> cuenta;
        cuenta = dao.obtenCuentaCorreo(mail);
        if (cuenta.isEmpty()) {
            model=new ModelAndView("RestaurarContra");
            if(locale.getLanguage()=="es"){
                model.addObject("error", "Correo no registrado");
            }else{
                model.addObject("error", "email not registered");
            }
        }else{
            cu = cuenta.get(0);
            String contraseña = util.generaPassword();
            int chash = util.hash(contraseña);
            if (dao.actualizaPassword(cu.getIdUsuario(), chash)) {
                if (locale.getLanguage() == "es") {
                    String body = mrc.creaEspañol(contraseña);
                    cor.enviarCorreo(mail, "Restauracion de contraseña", body);
                    model = new ModelAndView("redirect:/main.htm");

                } else {
                    String body = mrc.creaIngles(contraseña);
                    cor.enviarCorreo(mail, "Password recovery", body);
                    model = new ModelAndView("redirect:/main.htm");

                }
            } else {
                model = new ModelAndView("RestaurarContra");
                model.addObject("error", "hubo un error, intentelo de nuevo más tarde");
            }

            

        }
        return model;
    }

}
