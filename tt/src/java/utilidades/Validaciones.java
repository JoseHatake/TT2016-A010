/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import DAO.CuentaDAO;
import DAO.SeguirDAO;
import Modelos.Cuenta;
import Modelos.Seguir;
import Controladores.SesionUsuario;
import java.util.List;

/**
 *
 * @author Lock
 */
public class Validaciones {
    
     CuentaDAO dao= new CuentaDAO();
     SeguirDAO seg = new SeguirDAO();

    public Validaciones() {
    }    
    
    //funcion que valida la existencia de un pseudonimo en la base
    
    public boolean existePseudo(String pseudo){
        List<Cuenta>cuenta;
        cuenta=dao.buscaPseudonimo(pseudo);
        if(cuenta.isEmpty())
            return false;
        else
            return true;
    }
    
    //funcion que valida si ya esta registrado un correo
    
     public boolean existeCorreo(String correo){
        List<Cuenta>cuenta;
        CuentaDAO dao= new CuentaDAO();
        cuenta=dao.obtenCuentaCorreo(correo);
        if(cuenta.isEmpty())
            return false;
        else
            return true;
    }
     
    //Funcion que verifica si se sigue a un usuario
     public int sigueUsuario(int idlog, int idus){
         List<Seguir> lista = seg.obtenSeguirAutor(idlog, idus);
         if(lista.isEmpty())
             return 0;
         else
         return 1;
     }
    
    //funcion que verifica si se sigue un libro o no
     public int sigueLibro(int idlog, int idlib){
         List<Seguir> lista = seg.obtenSeguirLibro(idlog, idlib);
         if(lista.isEmpty())
             return 0;
         else
             return 1;
     }
    //funcion que verifica el log in
     
     public SesionUsuario logIn(String usuario, int pass){
         List<Cuenta> cuenta;
         cuenta = dao.buscaPseudonimo(usuario);
         SesionUsuario su = new SesionUsuario();
         if(cuenta.isEmpty())
             return null;
         else{
             Cuenta comp = new Cuenta();
             comp=cuenta.get(0);
             int i = comp.getActivada();
             if(pass == comp.getPassword() && i == 1){
                 su.setId(comp.getIdUsuario());
                 su.setPseudonimo(comp.getPseudonimo());
                 su.setMensaje(comp.getMensaje());
                 su.setFoto(comp.getFoto());
                 su.setNumSeguidores(comp.getNumSeguidores());
                 su.setIsAdmin(comp.getIsAdmin());
                 return su;
             }else
                 return null;
         }
     }
}
