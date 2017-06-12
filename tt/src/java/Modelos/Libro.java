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
@Table(name="libro")
public class Libro implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idLibro;
    
    String Nombre;
    String Clasificacion;
    String Descripcion;
    String idioma;
    String Portada;
    int Likes;
    int Status;
    int Usuario_idUsuario;
    Date Hora_fecha;

    public Libro() {
    }

    public Libro(String Nombre, String Clasificacion, String Descripcion, String idioma, String Portada, int Likes, int Status, int Usuario_idUsuario, Date Hora_fecha) {
        this.Nombre = Nombre;
        this.Clasificacion = Clasificacion;
        this.Descripcion = Descripcion;
        this.idioma = idioma;
        this.Portada = Portada;
        this.Likes = Likes;
        this.Status = Status;
        this.Usuario_idUsuario = Usuario_idUsuario;
        this.Hora_fecha = Hora_fecha;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPortada() {
        return Portada;
    }

    public void setPortada(String Portada) {
        this.Portada = Portada;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int Likes) {
        this.Likes = Likes;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }

    public Date getHora_fecha() {
        return Hora_fecha;
    }

    public void setHora_fecha(Date Hora_fecha) {
        this.Hora_fecha = Hora_fecha;
    }
    
    
    
      
}
