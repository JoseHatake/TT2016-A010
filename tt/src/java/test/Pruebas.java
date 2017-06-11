/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import Modelos.*;
import DAO.*;
import java.io.File;
import java.util.*;
import utilidades.Correo;
import utilidades.MensajeNotificacion;

import utilidades.MensajeRestaurarContraseña;
import utilidades.MensajeVerificarCuenta;
import utilidades.Utilidades;
import utilidades.Validaciones;

/**
 *
 * @author Lock
 */
public class Pruebas {
    
    public static void main(String args []){
       /*Usuario usuario = new Usuario("Ulises","Sanchez","Bello","CDMX","México", "1990-10-12", "M");
       Cuenta cuenta = new Cuenta("Lock","1256","silvernoble@hotmail.com","/fotos/Lock.jpg","nanai","dunno",1,0);
       usuario.setCuenta(cuenta);
       cuenta.setUsuario(usuario);
       CuentaDAO meh = new CuentaDAO();
       
    
       if(meh.guardaCuenta(cuenta, usuario)){
           System.out.println("Guardado");
       }else{
           System.out.println("Woops");
       }*/
        //meh.eliminaCuenta(usuario, cuenta);
       /*
       Libro libro = new Libro("Un libro cualquiera","Humor,Terror","no se me ocurre que poner aqui ","Español","/Portadas/ULC.jpg",0,1,1,hora);
       
       LibroDAO lib = new LibroDAO();
       lib.guardaLibro(libro);*/
       /*Libro libro = null;
       List<Libro> li;
       li = lib.obtenLibroIdioma("es");
       if(li.isEmpty())
           System.out.println("no existe");
       else{
       libro = li.get(0);
       System.out.println(libro.getNombre());
       libro = li.get(1);
       System.out.println(libro.getNombre());
       } */
       
       /*lib.eliminaLibroAutor(6);
       
       Usuario usuario= new Usuario();
       Cuenta cuenta = new Cuenta();
       usuario.setIdUsuario(7);
       cuenta.setIdUsuario(7);
       CuentaDAO us = new CuentaDAO();
       lib.eliminaLibroAutor(6);
       us.eliminaCuenta(usuario, cuenta);*/
       //Date hora = new Date();
       
       /*Capitulo capitulo = new Capitulo("Mejor asi",1,"/Mira nomas.pdf",1,hora);
       capitulo.setIdCapitulo(1);
       CapituloDAO cap = new CapituloDAO();
       
       if(cap.actualizaCapitulo(capitulo))
           System.out.println("Guardado");
       else
           System.out.println("Woops");*/
       
       /*Capitulo cap;
       CapituloDAO dao= new CapituloDAO();
       List<Capitulo> caps;
       
       caps = dao.obtenCapitulosLibro(1);
       cap = caps.get(0);
       System.out.println(cap.getNombre());*/
       
       /*Comentario comentario = new Comentario();
       ComentarioDAO com = new ComentarioDAO();
       List<Comentario> coms;
       coms= com.obtenComentarioLibro(1);
       comentario = coms.get(0);
       System.out.println(comentario.getComentario());
       com.eliminaComentarioAutor(1);*/
       
       //Denuncia den = new Denuncia("Mi gato se partió de risa","Contenido inapropiado para mascotas",1,1);
       //DenunciaDAO miracomotedenuncio = new DenunciaDAO();
       /*den.setIdDenuncia(1);
       List <Denuncia> den;
       den=miracomotedenuncio.obtenDenunciaUsuario(1);
       Denuncia coso;
       coso = den.get(0);
       System.out.println(coso.getDenuncia());
       if(miracomotedenuncio.eliminaDenunciaUsuario(1))
           System.out.println("Listo");
       else
           System.out.println("Algo falló");*/
       
       /*Red_social red = new Red_social();
       RedSocialDAO fatwit=new RedSocialDAO();
       red=fatwit.obtenRedSocial("FA");
       System.out.println(red.getRed_Social());*/
       
       /*Asociacion_Cuenta asoc = new Asociacion_Cuenta();
       AsociacionCuentaDAO dao = new AsociacionCuentaDAO();
       
       List<Asociacion_Cuenta> lista;
       lista=dao.obtenAsociacionUsuario(1);
       asoc = lista.get(0);
       System.out.println(asoc.getRed_Social_Clave());
       asoc = lista.get(1);
       System.out.println(asoc.getRed_Social_Clave());
       
       if(dao.eliminaAsociacionUsuario(1))
           System.out.println("Si se pudo");
       else
           System.out.println("Ahorita no joven");*/
       
      /*  SeguirDAO dao = new SeguirDAO();
      List<Seguir> res;
       Seguir seg = new Seguir();
       res=dao.obtenSeguirEspecifico(1, 2);
       if(res.isEmpty())
           System.out.println("nanai");
       else{
               seg=res.get(0);
               System.out.println(seg.getEsAutor());
               }*/
      
      /*Seguir seg = new Seguir(1,3,1);
      seg.setIdSeguir(5);
      if(dao.actualizaSeguir(seg))
          System.out.println("Ya estuvo");
      else
          System.out.println("Ahorita no joven");
      Seguir seg = new Seguir();
      List<Seguir> lista;
      lista = dao.obtenSeguirLibros(1);
      seg=lista.get(0);
      System.out.println(seg.getIDSeguido());
      if(dao.eliminaSeguirUsuario(1))
          System.out.println("Listo");
      else
          System.out.println("Ahorita no joven");*/
      
      /*LibroDAO dao=new LibroDAO();
      List<Libro> lista;
      Libro lib=new Libro();
      lista=dao.buscaRandom("Inglés");
      System.out.println(lista.size());      
      lib=lista.get(0);
      System.out.println(lib.getNombre());
      lib=lista.get(1);
      System.out.println(lib.getNombre());*/
      /*lib=lista.get(2);
      System.out.println(lib.getNombre());
      lib=lista.get(3);
      System.out.println(lib.getNombre());*/
      /*CuentaDAO dao = new CuentaDAO();
      Cuenta cuen=new Cuenta();
      List<Cuenta> lista;
      lista = dao.obtenCuentaTodos();
      cuen=lista.get(0);
      System.out.println(cuen.getPseudonimo());
      cuen=lista.get(1);
      System.out.println(cuen.getPseudonimo());*/
      
      /*SeguirDAO se=new SeguirDAO();
      List<Libro> lista;
      lista=se.obtenLibrosSeguidos(1);
      System.out.println(lista.size());
      Libro lib = new Libro();
      lib = lista.get(0);
      System.out.println(lib.getNombre());
            lib = lista.get(1);
      System.out.println(lib.getNombre());*/
      
      /*List<Cuenta> cuenta;
      CuentaDAO dao = new CuentaDAO();
      cuenta = dao.obtenCuentaCorreo("silvernoble@hotmail.com");
      if(cuenta.isEmpty())
          System.out.println("no ta");
      else
          System.out.println("si ta");*/
      
      /*List<String> lista;
      SeguirDAO dao=new SeguirDAO();
      lista = dao.obtenCorreoLibros(2);
      String correo;
      System.out.println(lista.size());
      correo=lista.get(0);
      System.out.println(correo);
      //correo=lista.get(1);
      //System.out.println(correo);*/
      
     /*Validaciones val = new Validaciones();
     if(val.logIn("Lock", "1257"))
         System.out.println("loggeado");
     else
         System.out.println("ahorita no joven");
         */
     /*LibroDAO dao = new LibroDAO();
     List<Libro> res;
     res=dao.obtenLibrosPaginados(3,3);
     System.out.println(res.size());
     Libro libro=new Libro();
     libro=res.get(0);
     System.out.println(libro.getNombre());
     libro=res.get(1);
     System.out.println(libro.getNombre());
     libro=res.get(2);
     System.out.println(libro.getNombre());
     libro=res.get(3);
     System.out.println(libro.getNombre());
     libro=res.get(4);
     System.out.println(libro.getNombre());*/
     
    /* Validaciones val = new Validaciones();
     if(val.sigueLibro(1, 1)){
         CuentaDAO cuen = new CuentaDAO();
         SeguirDAO seguir = new SeguirDAO();
         Cuenta cuenta = new Cuenta();
         LibroDAO biblo = new LibroDAO();
         Libro libro = new Libro();
         List <Libro> lista;
         cuenta = cuen.obtenCuenta(1);
         System.out.print("Seguidor: "+cuenta.getPseudonimo() + "   ");
         libro = biblo.obtenLibro(1);
         System.out.println("Seguido: "+libro.getNombre());
         lista = seguir.obtenLibrosSeguidos(1);
         for(int i=0;i<lista.size();i++){
             libro=lista.get(i);
             System.out.println(libro.getNombre());
         }
         
         
         
     }
     else
         System.out.println("No lo sigue");*/
    
    /*
    for(int i=0; i<10;i++){
        System.out.println(util.generaPassword());
    }
    Scanner k = new Scanner(System.in);
    String pseudo = k.nextLine();
    File nuevo = new File("../tt/usuarios/"+pseudo);
    if(nuevo.exists())
        System.out.println("No ma we, si existo");
    String ruta = "../tt/usuarios"+"/"+pseudo;
    util.creaDir(ruta);*/
    /*Utilidades util = new Utilidades();
    String pass = util.generaPassword();
    Correo cor = new Correo();
    MensajeNotificacion mes = new MensajeNotificacion();
    String cuerpo=mes.creaEspañol("Cruzito ha publicado una nueva obra", "Vamo a calmarno", "Obra basada en el popular meme", "http://localhost:8080/tt/main.htm");
    cor.enviarCorreo("edgar061093@gmail.com", "Restauracion de contraseña", cuerpo);*/

    
    /*Utilidades util = new Utilidades();
    int coso = util.hash("alola");
    System.out.println(coso);*/
    
    /*LibroDAO dao = new LibroDAO();
    List<Libro> libros;
    libros = dao.obtenLibroBusqueda("Horror", 2, 2);
    Libro libro=new Libro();
    libro = libros.get(1);
    System.out.println(libro.getNombre());
    List<String> paises;
    PaisesDAO dao = new PaisesDAO();
    paises = dao.obtenTodosPaises();
    String pais;
    pais = paises.get(145);
    System.out.println(pais);*/
    }
    
}
