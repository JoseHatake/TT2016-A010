/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author Lock
 */
@Entity
@Table(name="denuncia")
public class Denuncia implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idDenuncia;
    
    String Denuncia;
    String Tipo_Denuncia;
    int Usuario_idUsuario;
    int Libro_idLibro;

    public Denuncia() {
    }

    public Denuncia(String Denuncia, String Tipo_Denuncia, int Usuario_idUsuario, int Libro_idLibro) {
        this.Denuncia = Denuncia;
        this.Tipo_Denuncia = Tipo_Denuncia;
        this.Usuario_idUsuario = Usuario_idUsuario;
        this.Libro_idLibro = Libro_idLibro;
    }

    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getDenuncia() {
        return Denuncia;
    }

    public void setDenuncia(String Denuncia) {
        this.Denuncia = Denuncia;
    }

    public String getTipo_Denuncia() {
        return Tipo_Denuncia;
    }

    public void setTipo_Denuncia(String Tipo_Denuncia) {
        this.Tipo_Denuncia = Tipo_Denuncia;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }

    public int getLibro_idLibro() {
        return Libro_idLibro;
    }

    public void setLibro_idLibro(int Libro_idLibro) {
        this.Libro_idLibro = Libro_idLibro;
    }
    
    
    
}
