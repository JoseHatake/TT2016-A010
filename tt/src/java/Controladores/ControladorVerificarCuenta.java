/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CuentaDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lock
 */
@Controller
public class ControladorVerificarCuenta {

    @RequestMapping(value = "/verificar", method = RequestMethod.GET)
    public ModelAndView enviaVerificar(@RequestParam("id") int id) {
        ModelAndView model;
        CuentaDAO cu = new CuentaDAO();
        if (cu.actualizaActivacion(id, 1)) {
            model = new ModelAndView("verificar");            
        } else {
            model = new ModelAndView("redirect:/main");           
        }
      return model;  
    }
}
