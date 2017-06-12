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
@Table(name="capitulo")
public class Capitulo implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idCapitulo;
    String Nombre;
    int Numero;
    String Capitulo;
    int Libro_idLibro;
    Date Hora_fecha;

    
    public Capitulo() {
    }

    public Capitulo(String Nombre, int Numero, String Capitulo, int Libro_idLibro, Date Hora_fecha) {
        this.Nombre = Nombre;
        this.Numero = Numero;
        this.Capitulo = Capitulo;
        this.Libro_idLibro = Libro_idLibro;
        this.Hora_fecha = Hora_fecha;
    }

    public int getIdCapitulo() {
        return idCapitulo;
    }

    public void setIdCapitulo(int idCapitulo) {
        this.idCapitulo = idCapitulo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getCapitulo() {
        return Capitulo;
    }

    public void setCapitulo(String Capitulo) {
        this.Capitulo = Capitulo;
    }

    public int getLibro_idLibro() {
        return Libro_idLibro;
    }

    public void setLibro_idLibro(int Libro_idLibro) {
        this.Libro_idLibro = Libro_idLibro;
    }

    public Date getHora_fecha() {
        return Hora_fecha;
    }

    public void setHora_fecha(Date Hora_fecha) {
        this.Hora_fecha = Hora_fecha;
    }

    @Override
    public String toString() {
        return "Capitulo{" + "idCapitulo=" + idCapitulo + ", Nombre=" + Nombre + ", Numero=" + Numero + ", Capitulo=" + Capitulo + ", Libro_idLibro=" + Libro_idLibro + ", Hora_fecha=" + Hora_fecha + '}';
    }
}
