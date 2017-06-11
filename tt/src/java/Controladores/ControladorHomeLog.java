/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Cuenta;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lock
 */
@Controller
@RequestMapping("/logged")
public class ControladorHomeLog {
    
    //Devuelve la pagina con usuario loggeado
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginver (Locale locale, HttpSession coso){
       ModelAndView model = new ModelAndView("logged");
       SesionUsuario su = (SesionUsuario)coso.getAttribute("use");
       model.addObject("pseudonimo", su.getPseudonimo());
       model.addObject("mensaje",su.getMensaje() );
       return model;
    }
    
}
