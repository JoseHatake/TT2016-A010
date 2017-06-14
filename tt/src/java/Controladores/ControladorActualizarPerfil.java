/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CuentaDAO;
import DAO.LibroDAO;
import Modelos.Libro;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import utilidades.GuardarArchivo;
import utilidades.Rutas;

/**
 *
 * @author Lock
 */
@Controller
@RequestMapping("/ActualizarFotoPerfil")
public class ControladorActualizarPerfil {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String enviaLibrosA(@RequestParam("file") MultipartFile file, HttpSession ses) {
        SesionUsuario su = (SesionUsuario) ses.getAttribute("use");
        String idUser = String.valueOf(su.getId());    
        String resultado="";
        System.out.println("ARCHIVO LLEGO "+file.getOriginalFilename());
        
        if (GuardarArchivo.crearCarpeta(idUser)) {
            String rutaPerfil = GuardarArchivo.guardarPerfil(file, idUser);
          if (rutaPerfil!=null) {
               CuentaDAO dao = new CuentaDAO();
               
               if (dao.actualizaImagen(Integer.valueOf(idUser),rutaPerfil) == true) {         
                    System.out.println("ACTUALIZADO CORRECTAMENTE");
                    resultado= "Foto actualizada con éxito";
                } else {
                    resultado= "Error al actualizar la foto";
                }
          }
        }
        
        
        return resultado;
    }
}