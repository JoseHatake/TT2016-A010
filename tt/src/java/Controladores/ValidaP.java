/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utilidades.Validaciones;

/**
 *
 * @author Lock
 */
@Controller
@RequestMapping("/validaP")
public class ValidaP {

    private Validaciones val = new Validaciones();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String validaPseudo(@RequestParam("name") String name, Locale locale) {
        String respuesta;
        if (val.existePseudo(name)) {
            if (locale.getLanguage() == "en") {
                respuesta = "User already in use";
            } else {
                respuesta = "Usuario no disponible";

            }
        } else {
            if (locale.getLanguage() == "en") {
                respuesta = "User available";
            } else {
                respuesta = "Usuario disponible";
            }
        }

        return respuesta;
    }

}
