/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CapituloDAO;
import DAO.CuentaDAO;
import DAO.LibroDAO;
import Modelos.Capitulo;
import Modelos.Cuenta;
import Modelos.Libro;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utilidades.GuardarArchivo;

/**
 *
 * @author hatake
 */
@Controller
@RequestMapping("/perfildelibro")
public class ControladorPerfilLibro {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargaPerfilLibro(@RequestParam("idLibro") int idLibro, HttpSession ses) throws UnsupportedEncodingException{
        ModelAndView model;
        Libro perfil = new Libro();
        Cuenta cuenta = new Cuenta();
        List<Capitulo> capitulos = new ArrayList<>();
        LibroDAO consultorLibro = new LibroDAO();
        CuentaDAO cuentaDao = new CuentaDAO();
        CapituloDAO capituloDao = new CapituloDAO();
        byte[] img = null;
        String imagenPortada, imagenAutor;
        
        model = new ModelAndView("perfildelibro");
        perfil = consultorLibro.obtenLibro(idLibro);
        cuenta = cuentaDao.obtenCuenta(perfil.getUsuario_idUsuario());
        
        img = GuardarArchivo.leerImagenes(perfil.getPortada());
        imagenPortada = new String(img, "UTF-8");
        
        img = GuardarArchivo.leerImagenes(cuenta.getFoto());
        imagenAutor = new String(img, "UTF-8");
        
        capitulos = capituloDao.obtenCapitulosLibro(idLibro);
        
        for (Capitulo cap: capitulos){
            System.out.println("capitulos : " + cap);
        }
        
        model.addObject("libro",perfil);
        model.addObject("autor",cuenta);
        model.addObject("portada",imagenPortada);
        model.addObject("foto",imagenAutor);
        model.addObject("capitulos", capitulos);
        return model;
    }
}
