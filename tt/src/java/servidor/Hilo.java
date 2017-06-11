/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import Modelos.*;
import DAO.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Lock
 */
public class Hilo implements Runnable{
    
    private Socket socketCliente = null;
    private ObjectOutputStream respuesta = null;
    private ObjectInputStream peticion = null;

//Inicializamos el flujo de objetos con el socket asignado
    public Hilo(Socket socket) {
        this.socketCliente = socket;
        try{
            respuesta = new ObjectOutputStream(socketCliente.getOutputStream());
            peticion = new ObjectInputStream(new BufferedInputStream(socketCliente.getInputStream()));
        }catch(IOException e){
            System.out.println("Ahorita no joven");
        }
    }
//Metodo para terminar la conexion cerrando el socket y los flujos de entrada y salida.
    public void desconectar(){
        try {
            respuesta.close();
            peticion.close();
            socketCliente.close();
        } catch (IOException ex) {
            System.out.println("no se quiere cerrar");
        }
    }

//Menú que provee la funcionalidad al sitio
    @Override
    public void run() {
        String entidad=""; //variable utilizada para elegir la entidad que se va a manipular
        String accion="";  //variable utilizada para elegir la accion a realizar con la entidad
        
        try{
            
            while((entidad = (String) peticion.readObject()) != null){ //Ciclo que ejecuta el menú mientras reciva peticiones del cliente.
                
                if(entidad.equals("cuenta")){    //Verifica si desea realizar una operacion relativa a una cuenta
                    
                    accion = (String)peticion.readObject();
                    switch(accion){
                        case "verificar":          //verifica que un pseudonimo este disponible
                            break;
                        case "registrar":          //Guarda la cuenta
                            break;
                        case "actualizar usuario": //Actualiza datos de usuario
                            break;
                        case "actualizar cuenta":  //Actualiza datos de cuenta
                            break;
                        case "actualizar foto":    //Actualiza la foto del perfil
                            break;
                        case "buscar mi usuario":  //Busca la informacion del usuario activo
                            break;
                        case "buscar mi cuenta":   //Busca la informacion de la cuenta del usuario activo
                            break;
                        case "buscar cuenta":      //Busca la informacion de la cuenta de un usuario
                            break;
                        case "seguidos":           //busca autores seguidos por el usuario
                            break;
                        case "envia imagen":       //envia la imagen de perfil del usuario solicitado
                            break;
                        case "eliminar":           //Elimina la cuenta
                            break;
                        case "log":                //verifica el log in
                            break;
                   }
                    
               }else if(entidad.equals("libro")){   //verifica si la operacion es respecto a los libros
                   
                    accion = (String)peticion.readObject();
                     switch(accion){
                        case "guardar":  //guarda el libro nuevo
                            break;
                        case "actualizar": //actualiza informacion del libro
                            break;
                        case "actualizar portada": //actualiza la portada del libro
                            break;
                        case "busca libro": //busca la informacion del libro activo
                            break;
                        case "random":    //envia la selección de libros al azar
                            break;
                        case "recientes":  //envia la seleccion de libros recientes
                            break;
                        case "gustados":   //envia la seleccion de libros mas gustados
                            break;
                        case "seguidos":  // envia la seleccion de libros seguidos por el autor 
                            break;
                        case "portada":   //envia la portada de un libro
                            break;
                        case "eliminar libro"://elimina el libro seleccionado
                            break;
                   }
                     
               }else if(entidad.equals("capitulo")){ //verifica si la operacion es respecto a los capitulos
                   
                   accion = (String)peticion.readObject();
                   switch(accion){
                       case "guardar":  //guarda el capitulo de un libro
                           break;
                       case "actualizar capitulo": //actualiza el capitulo de un libro
                           break;
                       case "buscar capitulos":   //envia los capitulos pertenecientes a un libro
                           break;
                       case "buscar":            //busca la información de un capitulo
                           break;
                       case "enviar":           //envia el capitulo solicitado
                           break;
                       case "eliminar":         //elimina el capitulo solicitado
                   }
                   
               }else if(entidad.equals("comentario")){ //verifica si la operacion es respecto a l
                   
                  accion = (String)peticion.readObject(); 
                  switch(accion){
                      case "guardar": //guarda un comentario
                          break;
                      case "actualizar": //actualiza un comentario
                          break;
                      case "buscar":   //busca un comentario
                          break;
                      case "buscar comentarios": //busca los comentarios de un libro
                          break;
                      case"eliminar": //elimina un comentario
                          break;
                  }
               
               }else if(entidad.equals("seguir")){ //verifica si la operacion tiene que ver con seguir a un libro o usuario
                   
                   accion = (String)peticion.readObject();
                   switch(accion){
                       case "seguir": //inserta el seguimiento en la tabla
                           break;
                       case "dejarA": //elimina el seguimiento de un autor
                           break;
                       case "dejarL": //elimina el seguimiento de un libro
                           break;
                       case "verificarA": //verifica si se sigue a un autor
                           break;
                       case "verificarL": //verifica si se sigue a un libro
                    
                       
                   }
               
               }else if(entidad.equals("asociar")){  //verifica si la operacion tiene que ver con asociar una red social
                   
                   accion = (String)peticion.readObject();
                   switch(accion){
                       case "guardar":   //guarda la asociacion
                           break;
                       case "actualizar": //actualiza la asociacion
                           break;
                       case "busca": //envia una asociacion especifica
                           break;
                       case "buscaU": //envia las redes asociadas de un usuario
                           break;
                       case "elimina": //elimina una asociacion
                   }
               }else if(entidad.equals("denuncia")){ //verifica si la operacion es un envio de denuncia
                   //las denuncias en la base de datos se almacenan a forma de historial, por lo que solo se dan de alta
                   
                   
               }else if(entidad.equals("busqueda")){ //verifica si la operacion tiene que ver con la busqueda del sitio
                   
                   
               }else if(entidad.equals("red")){ //verifica si la operacion tiene que ver con las redes sociales
                   
                   accion = (String)peticion.readObject();
                   switch(accion){
                       case "guardar": //guarda el registro de la red social
                           break;
                       case "actualizar": //actualiza el registro de la red
                           break;
                       case "buscar":  //busca una red social registrada
                           break;
                       case "eliminar": //elimina la red social
                           break;
                   }
                   
               } 
               
                 
            }
            
        desconectar();
            
        }catch(Exception e){
            e.printStackTrace();
            desconectar();
        }
    }
    
}
