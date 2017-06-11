/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CuentaDAO;
import Modelos.Cuenta;
import Modelos.Usuario;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import utilidades.Correo;
import utilidades.MensajeVerificarCuenta;
import utilidades.Utilidades;
import utilidades.Validaciones;

/**
 *
 * @author Lock
 */
@Controller
@RequestMapping("/registrarse")
public class ControladorRegistro {

    private ModelAndView model = null;
    private CuentaDAO dao = new CuentaDAO();
    private Correo cor = new Correo();
    private MensajeVerificarCuenta ver = new MensajeVerificarCuenta();
    private Validaciones val = new Validaciones();
    private Utilidades ut = new Utilidades();
    private String error;

    //metodo que envia el formulario de registro
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView verRegistrarse(Locale locale, ModelMap map) {
        Usuario us = new Usuario();
        Cuenta cu = new Cuenta();
        map.addAttribute("us", us);
        map.addAttribute("cu", cu);
        ModelAndView model = new ModelAndView("registrarse");
        return model;
    }

    //metodo que procesa la opcion de cancelar y regresa a la pagina home
    @RequestMapping(params = "cancelar", method = RequestMethod.POST)
    public ModelAndView cancelar() {

        model = new ModelAndView("redirect:/main.htm");
        return model;

    }

    //metodo que registra al usuario
    @RequestMapping(params = "registrarse", method = RequestMethod.POST)
    public ModelAndView registrar(@ModelAttribute("us") Usuario us, BindingResult resultUsuario, @ModelAttribute("cu") Cuenta cu, Locale locale, HttpServletRequest request) {
       
        if (!val.existePseudo(cu.getPseudonimo())) {
            if (!val.existeCorreo(cu.getEmail())) {
                //vemos si se logra insertar al usuario en la base
                if (dao.guardaCuenta(cu, us)) {                                   
                       
                    //Creamos la url para verificarlo                    
                    //String url ="http://localhost:8080/tt/verificar.htm?id="+cu.getIdUsuario();
                    String url = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/verificar.htm?id="+cu.getIdUsuario();
                    String cuerpo;
                    String asunto;
                    //Creamos el cuerpo del correo de verificacion verificando el idioma 
                    if (locale.getLanguage() == "es") {
                        cuerpo = ver.creaEspañol(cu.getPseudonimo(), url);
                        asunto = "Verificacion de correo";
                    } else {
                        cuerpo = ver.creaIngles(cu.getPseudonimo(), url);
                        asunto = "e-mail verification";
                    }
                    //enviamos el correo    
                    try {
                        cor.enviarCorreo(cu.getEmail(), asunto, cuerpo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    model = new ModelAndView("redirect:/main.htm");
                } else {
                    model = new ModelAndView("redirect:/registrarse.htm");
                    if (locale.getLanguage() == "es") {
                        error = "El usuario no pudo registrarse";
                    } else {
                        error = "The user could not be registered";
                    }
                    model.addObject("error", error);
                }

            } else {
                model = new ModelAndView("redirect:/registrarse.htm");
                if (locale.getLanguage() == "es") {
                    error = "La direccion de correo electronico ya se encuentra registrada";
                } else {
                    error = "The e-mail address is already in use";
                }
                model.addObject("error", error);
            }

        } else {
            model = new ModelAndView("redirect:/registrarse.htm");
            if (locale.getISO3Language() == "es") {
                error = "El pseudonimo ya se encuentra en uso";
            } else {
                error = "Nickname already in use";
            }
            model.addObject("error", error);
        }

        return model;

    }

}
