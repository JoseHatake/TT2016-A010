/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CuentaDAO;
import DAO.LibroDAO;
import Modelos.Cuenta;
import Modelos.Libro;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utilidades.GuardarArchivo;
import utilidades.Validaciones;

/**
 *
 * @author Lock
 */
@Controller
public class ControladorPerfilACL {

    @RequestMapping(value = "/pAutorL", method = RequestMethod.GET)
    public ModelAndView PerfilACL(@RequestParam("id") int id, HttpSession ses) throws UnsupportedEncodingException {
        ModelAndView model;
        Validaciones val = new Validaciones();
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        byte[] img;
        String portada;

        model = new ModelAndView("pAutorL");
        CuentaDAO dao = new CuentaDAO();
        LibroDAO ldao = new LibroDAO();
        Cuenta usuario = new Cuenta();
        List<Libro> libros;
        Libro lib;
        int sigue;
        if (su.getId() == id) {
            sigue = 2;
        } else {
            sigue = val.sigueUsuario(su.getId(), id);
        }
        libros = ldao.obtenLibroAutor(id, 1, 4);
        usuario = dao.obtenCuenta(id);
        if (su != null) {
            model.addObject("log", "1");
        } else {
            model.addObject("log", "0");
        }
        model.addObject("idp", id);
        model.addObject("sigu", sigue);
        model.addObject("numseg", usuario.getNumSeguidores());
        img = GuardarArchivo.leerImagenes(usuario.getFoto());
        portada = new String(img, "UTF-8");
        model.addObject("imgl", portada);
        model.addObject("autor", usuario.getPseudonimo());
        model.addObject("mp", usuario.getMensaje());
        model.addObject("sm", usuario.getDescripcionP());
        model.addObject("nlib", libros.size());
        if (libros.size() < 4) {
            for (int i = 0; i < libros.size(); i++) {
                int num = i + 1;
                lib = libros.get(i);
                img = GuardarArchivo.leerImagenes(lib.getPortada());
                portada = new String(img, "UTF-8");
                model.addObject("plib" + num, portada);
                model.addObject("titulo" + num, lib.getNombre());
                model.addObject("idl" + num, lib.getIdLibro());
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int num = i + 1;
                lib = libros.get(i);
                img = GuardarArchivo.leerImagenes(lib.getPortada());
                portada = new String(img, "UTF-8");
                model.addObject("plib" + num, portada);
                model.addObject("titulo" + num, lib.getNombre());
                model.addObject("idl" + num, lib.getIdLibro());
            }
        }

        return model;
    }

    //Carga la pagina con el perfil de la sesion
    @RequestMapping(value = "/pAutorL", method = RequestMethod.GET, params = {"!id"})
    public ModelAndView miP(HttpSession ses) throws UnsupportedEncodingException {
        ModelAndView model;
        Validaciones val = new Validaciones();
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        byte[] img;
        String portada;

        model = new ModelAndView("pAutorL");
        CuentaDAO dao = new CuentaDAO();
        LibroDAO ldao = new LibroDAO();
        Cuenta usuario = new Cuenta();
        usuario = dao.obtenCuenta(su.getId());
        List<Libro> libros;
        Libro lib;
        if (su != null) {
            model.addObject("log", "1");
        } else {
            model.addObject("log", "0");
        }
        int sigue = 2;
        libros = ldao.obtenLibroAutor(usuario.getIdUsuario(), 1, 4);
        model.addObject("idp", usuario.getIdUsuario());
        model.addObject("sigu", sigue);
        model.addObject("numseg", usuario.getNumSeguidores());
        img = GuardarArchivo.leerImagenes(usuario.getFoto());
        portada = new String(img, "UTF-8");
        model.addObject("imgl", portada);
        model.addObject("autor", usuario.getPseudonimo());
        model.addObject("mp", usuario.getMensaje());
        model.addObject("sm", usuario.getDescripcionP());
        model.addObject("nlib", libros.size());
        if (libros.size() < 4) {
            for (int i = 0; i < libros.size(); i++) {
                int num = i + 1;
                lib = libros.get(i);
                img = GuardarArchivo.leerImagenes(lib.getPortada());
                portada = new String(img, "UTF-8");
                model.addObject("plib" + num, portada);
                model.addObject("titulo" + num, lib.getNombre());
                model.addObject("idl" + num, lib.getIdLibro());
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int num = i + 1;
                lib = libros.get(i);
                img = GuardarArchivo.leerImagenes(lib.getPortada());
                portada = new String(img, "UTF-8");
                model.addObject("plib" + num, portada);
                model.addObject("titulo" + num, lib.getNombre());
                model.addObject("idl" + num, lib.getIdLibro());
            }
        }

        return model;
    }

}
