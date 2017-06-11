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
@Table(name="asociacion_cuenta")
public class Asociacion_Cuenta implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idAsociacion;
    
    int Usuario_idUsuario;
    String Red_Social_Clave;
    String Contraseña;
    String Correo;

    public Asociacion_Cuenta() {
    }

    public Asociacion_Cuenta(int Usuario_idUsuario, String Red_Social_Clave, String Contraseña, String Correo) {
        this.Usuario_idUsuario = Usuario_idUsuario;
        this.Red_Social_Clave = Red_Social_Clave;
        this.Contraseña = Contraseña;
        this.Correo = Correo;
    }

    public int getIdAsociacion() {
        return idAsociacion;
    }

    public void setIdAsociacion(int idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }

    public String getRed_Social_Clave() {
        return Red_Social_Clave;
    }

    public void setRed_Social_Clave(String Red_Social_Clave) {
        this.Red_Social_Clave = Red_Social_Clave;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
        
}
