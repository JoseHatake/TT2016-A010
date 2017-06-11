/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.LibroDAO;
import Modelos.Libro;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import utilidades.GuardarArchivo;

/**
 *
 * @author yosgs
 */
@Controller

public class ControladorHome {

    @RequestMapping(value = "/listado", method = RequestMethod.GET)
    public ModelAndView listado(HttpSession ses) throws UnsupportedEncodingException {
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        
            //   Map<String, byte[]> myModel = new HashMap<String, byte[]>();
            Map<String, List<String>> myModel = new HashMap<String, List<String>>();
            Locale locale = LocaleContextHolder.getLocale();
            LibroDAO dao = new LibroDAO();
            List<String> imagenesRecientes = new ArrayList<>();
            List<String> librosRecientes = new ArrayList<>();

            List<String> imagenesRandom = new ArrayList<>();
            List<String> librosRandom = new ArrayList<>();

            List<String> imagenesMasGustados = new ArrayList<>();
            List<String> librosMasGustados = new ArrayList<>();
            
            List<String> idLibro = new ArrayList<>();

            String idioma = locale.getLanguage();
            System.out.println("**IDIOMA ** " + idioma);

            List<Libro> listaRecientes = dao.buscaRecientes(idioma, 1, 10);
            List<Libro> listaRandom = dao.buscaRandom(idioma, 10);
            List<Libro> listaGustados = dao.buscaGustados(idioma, 1, 10);

            for (Libro actual : listaRecientes) {
                byte[] img = GuardarArchivo.leerImagenes(actual.getPortada());
                if (img != null) {
                    imagenesRecientes.add(new String(img, "UTF-8"));
                    librosRecientes.add(actual.getNombre());
                }
                System.out.println("---_RUTA " + actual.getPortada());
            }

            for (Libro actual : listaRandom) {
                byte[] img = GuardarArchivo.leerImagenes(actual.getPortada());
                if (img != null) {
                    imagenesRandom.add(new String(img, "UTF-8"));
                    librosRandom.add(actual.getNombre());
                }
                System.out.println("---_RUTA " + actual.getPortada());
            }

            for (Libro actual : listaGustados) {
                byte[] img = GuardarArchivo.leerImagenes(actual.getPortada());
                if (img != null) {
                    imagenesMasGustados.add(new String(img, "UTF-8"));
                    librosMasGustados.add(actual.getNombre());
                    idLibro.add(String.valueOf(actual.getIdLibro()));
                }
                System.out.println("---_RUTA " + actual.getPortada());
            }

            myModel.put("listaImagenesRecientes", imagenesRecientes);
            myModel.put("listaTitulosRecientes", librosRecientes);

            myModel.put("listaImagenesRandom", imagenesRandom);
            myModel.put("listaTitulosRandom", librosRandom);

            myModel.put("listaImagenesMasGustados", imagenesMasGustados);
            myModel.put("listaTitulosMasGustados", librosMasGustados);
            
            myModel.put("idLibros", idLibro);

            // myModel.put("profesores", this.ProfesorManager.getProfesores());
            return new ModelAndView("home", "model", myModel);
        }
    }


