/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.SeguirDAO;
import Modelos.Cuenta;
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
 * Controlador que se encarga de enviar los autores seguidos de manera paginada
 */
@Controller
@RequestMapping("/Aseguidos")
public class ControladorAutoresSeguidos {

    SeguirDAO dao = new SeguirDAO();
    List<Cuenta> cuentas;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Cuenta> enviaAutoresSeguidos(@RequestParam("pagina") int pagina, @RequestParam("idSeguidor") int id) {

        cuentas = dao.obtenAutoresSeguidos(id, pagina, 8);

        return cuentas;
    }

}
