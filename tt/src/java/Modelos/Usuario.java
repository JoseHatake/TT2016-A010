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
@Table(name="usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idUsuario;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="idUsuario")
    Cuenta cuenta;
    
    String Nombre;
    String aPaterno;
    String aMaterno;  
    String Pais;
    String Fecha_Nacimiento;
    String Sexo;

    public Usuario() {
    }

    public Usuario(String Nombre, String aPaterno, String aMaterno, String Pais, String Fecha_Nacimiento, String Sexo) {
       
        this.Nombre = Nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;        
        this.Pais = Pais;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Sexo = Sexo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }
   
    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    
    
    
    
    
    
}
