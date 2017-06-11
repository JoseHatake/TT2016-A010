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
@Table(name="seguir")
public class Seguir implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idSeguir;
    
    int Usuario_idUsuario;
    int IDSeguido;
    int EsAutor;

    public Seguir() {
    }

    public Seguir(int Usuario_idUsuario, int IDSeguido, int EsAutor) {
        this.Usuario_idUsuario = Usuario_idUsuario;
        this.IDSeguido = IDSeguido;
        this.EsAutor = EsAutor;
    }

    public int getIdSeguir() {
        return idSeguir;
    }

    public void setIdSeguir(int idSeguir) {
        this.idSeguir = idSeguir;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }

    public int getIDSeguido() {
        return IDSeguido;
    }

    public void setIDSeguido(int IDSeguido) {
        this.IDSeguido = IDSeguido;
    }

    public int getEsAutor() {
        return EsAutor;
    }

    public void setEsAutor(int EsAutor) {
        this.EsAutor = EsAutor;
    }
    
    
    
    
}
