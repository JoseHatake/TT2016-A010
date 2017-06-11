/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelos.Cuenta;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utilidades.Utilidades;
import utilidades.Validaciones;


/**
 *
 * @author Lock
 */
@Controller
@RequestMapping("/main")

public class ControladorMain {
    private Utilidades util = new Utilidades();
   
    private Validaciones val = new Validaciones();
    @Autowired
    private SesionUsuario su;
    ModelAndView model= null;
    
    //metodo que verifica si los datos de log in son correctos
    @RequestMapping(params="login", method = RequestMethod.POST)
    public ModelAndView login (@RequestParam("userName") String user, @RequestParam("password")String pass, Locale locale, final RedirectAttributes redirectAttrs,HttpSession ses){
        
        int hash;
        hash=util.hash(pass);
        su = val.logIn(user, hash);
        if(su != null){
            //redirectAttrs.addFlashAttribute("loginFlashAttribute", su);
            ses.setAttribute("use", su);            
            model= new ModelAndView("redirect:/listado.htm");     
            model.addObject("id", su.getId());
        }else
            if(locale.getLanguage()== "es"){
               model = new ModelAndView("redirect:/main.htm");
               model.addObject("error", "Usuario o Contraseña invalidos");
            }else{
               model = new ModelAndView("redirect:/main.htm");
               model.addObject("error", "Invalid User or Password");
            }
                   
        return model;
           
    }
    //metodo que envia la pagina home
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginver (){
       ModelAndView model = new ModelAndView("main");
       return model;
    }
    
    //metodo que redirige al formulario de registro
     @RequestMapping(params="registrarse",method = RequestMethod.POST)
     public ModelAndView registrarse (){
       
        model=new ModelAndView("redirect:/registrarse.htm");
        return model;
           
    }
    
    
     
    
    
}
