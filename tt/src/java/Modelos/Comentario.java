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
@Table(name="comentario")
public class Comentario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idComentario;
    
    Date Fecha;
    String Comentario;
    int Usuario_idUsuario;
    int Libro_idLibro;

    public Comentario() {
    }

    public Comentario(Date Fecha, String Comentario, int Usuario_idUsuario, int Libro_idLibro) {
        this.Fecha = Fecha;
        this.Comentario = Comentario;
        this.Usuario_idUsuario = Usuario_idUsuario;
        this.Libro_idLibro = Libro_idLibro;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
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
