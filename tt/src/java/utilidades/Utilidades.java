/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import DAO.CuentaDAO;
import java.io.File;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Lock
 */
public class Utilidades {

    public Utilidades() {
    }
    //funcion que se utiliza para generar un password al azar si solicitan restauracion del password 

    public String generaPassword() {
        String pass = "";
        char[] caracteres;
        int longitud = new Random().nextInt(5) + 8;
        caracteres = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < longitud; i++) {
            pass += caracteres[new Random().nextInt(caracteres.length)];
        }
        return pass;
    }

    //funcion para crear un directorio
    public boolean creaDir(String ruta) {
        File dir = new File(ruta);
        if (dir.mkdir()) {
            return true;
        } else {
            return false;
        }
    }

    //Funcion para calcular un valor hash
    public int hash(String pass) {
        int hash = 0;
        int chr;
        if (pass.length() == 0) {
            return hash;
        } else {
            for (int i = 0; i < pass.length(); i++) {
                chr = pass.charAt(i);
                hash = ((hash << 5) - hash) + chr;
                hash = hash & hash;
            }
            return hash;
        }

    }

    //Funcion para enviar notificaciones
    public void mandaNotificaciones(String lang, String encabezado, String libro, String desc, String url, List<String> correos) {
        String cuerpo = "";
        int i = 0;
        Correo cor = new Correo();
        MensajeNotificacion men = new MensajeNotificacion();
        if (lang.equals("es")) {
            cuerpo = men.creaEspañol(encabezado, libro, desc, url);
            for (i = 0; i < correos.size(); i++) {
                cor.enviarCorreo(correos.get(i), cuerpo, url);
            }

        } else {
            cuerpo = men.creaIngles(encabezado, libro, desc, url);
            for (i = 0; i < correos.size(); i++) {
                cor.enviarCorreo(correos.get(i), cuerpo, url);
            }
        }

    }

    //Funcion para reestablecer contraseña
    public void restablecerContraseña(int id, String mail, String lang) {
        CuentaDAO dao = new CuentaDAO();
        Correo cor = new Correo();
        MensajeRestaurarContraseña mes = new MensajeRestaurarContraseña();
        String cuerpo;
        String pass = generaPassword();
        int phash = hash(pass);
        dao.actualizaPassword(id, phash);
        if (lang.equals("es")) {
            cuerpo=mes.creaEspañol(pass);
            cor.enviarCorreo(mail, "Restauracion de contraseña", pass);   
            

        } else {
            cuerpo=mes.creaIngles(pass);
            cor.enviarCorreo(mail, "Password change", pass);
            
        }
        

    }

}
