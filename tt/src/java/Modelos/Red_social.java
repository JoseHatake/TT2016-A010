/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
 /*
 * @author Lock
 */
@Entity
@Table(name="red_social")
public class Red_social implements Serializable{
    
    @Id
    String Clave;
    String Token;
    String Red_Social;

    public Red_social() {
    }

    public Red_social(String Clave, String Token, String Red_Social) {
        this.Clave = Clave;
        this.Token = Token;
        this.Red_Social = Red_Social;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getRed_Social() {
        return Red_Social;
    }

    public void setRed_Social(String Red_Social) {
        this.Red_Social = Red_Social;
    }
       
    
}
