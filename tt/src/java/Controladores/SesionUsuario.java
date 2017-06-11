/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lock
 */

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SesionUsuario implements Serializable {
    int id;
    String Pseudonimo;
    String foto;
    String mensaje;
    int NumSeguidores;
    Boolean IsAdmin;

    public SesionUsuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudonimo() {
        return Pseudonimo;
    }

    public void setPseudonimo(String Pseudonimo) {
        this.Pseudonimo = Pseudonimo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getNumSeguidores() {
        return NumSeguidores;
    }

    public void setNumSeguidores(int NumSeguidores) {
        this.NumSeguidores = NumSeguidores;
    }

    public Boolean getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(Boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }
    
    
}
