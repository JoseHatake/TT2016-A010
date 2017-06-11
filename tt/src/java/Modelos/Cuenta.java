/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Lock
 */
@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idUsuario;
    
    @OneToOne(mappedBy="cuenta")
    Usuario usuario;
    
    String Pseudonimo;
    int Password;
    String email;
    String foto;
    String mensaje;
    String DescripcionP;
    int NumSeguidores;
    int Activada;
    Boolean IsAdmin = false;



    public Cuenta() {
    }

    public Cuenta(String Pseudonimo, int Password, String email, String foto, String mensaje, String DescripcionP, int NumSeguidores, int Activada) {
       
        this.Pseudonimo = Pseudonimo;
        this.Password = Password;
        this.email = email;
        this.foto = foto;
        this.mensaje = mensaje;
        this.DescripcionP = DescripcionP;
        this.NumSeguidores = NumSeguidores;
        this.Activada = Activada;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPseudonimo() {
        return Pseudonimo;
    }

    public void setPseudonimo(String Pseudonimo) {
        this.Pseudonimo = Pseudonimo;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDescripcionP() {
        return DescripcionP;
    }

    public void setDescripcionP(String DescripcionP) {
        this.DescripcionP = DescripcionP;
    }

    public int getNumSeguidores() {
        return NumSeguidores;
    }

    public void setNumSeguidores(int NumSeguidores) {
        this.NumSeguidores = NumSeguidores;
    }

    public int getActivada() {
        return Activada;
    }

    public void setActivada(int Activada) {
        this.Activada = Activada;
    }
        public Boolean getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(Boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }

       
    
}
