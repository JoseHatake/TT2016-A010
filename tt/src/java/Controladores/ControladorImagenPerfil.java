/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CuentaDAO;
import DAO.LibroDAO;
import Modelos.Libro;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import utilidades.GuardarArchivo;
import utilidades.Rutas;

/**
 *
 * @author yosgs
 */
@Controller
@RequestMapping("/traerFotoPerfil")
public class ControladorImagenPerfil {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String traerFotoPerfil(HttpSession ses) throws UnsupportedEncodingException {
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        String idUser = String.valueOf(su.getId());  
        CuentaDAO dao = new CuentaDAO();
        String rutaPerfil = (dao.obtenCuenta(Integer.valueOf(idUser))).getFoto();
        byte[] img = GuardarArchivo.leerImagenes(rutaPerfil);
        String resultado ="";//new String(img, "UTF-8");
        if (img != null) {
            System.out.println("-------ENCONTRADO "+img.toString());
            resultado = new String(img, "UTF-8");
        }
        else{
            System.out.println("-------NOOOOOOOOOOOOOO ");
            resultado ="";
        }
        
        
        return resultado;
    }
}
