/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelos.Cuenta;
import Modelos.Usuario;
import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Lock
 */
public class CuentaDAO {
    private Session sesion; 
    private Transaction tx;  
    
    //Obtiene el session factory para conectar con la base de datos e inicia la transacción
    private void iniciaOperacion() throws HibernateException 
    { 
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    }  

    //deshace la transacción si surge un error
    private void manejaExcepcion(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    } 
    
    
    //Inserta un una cuenta 
    
     public boolean guardaCuenta(Cuenta cuenta, Usuario usuario) throws HibernateException 
    { 
        

        try 
        { 
            iniciaOperacion(); 
            cuenta.setNumSeguidores(0);
            cuenta.setActivada(0);
            cuenta.setIsAdmin(Boolean.FALSE);
            cuenta.setFoto("adefault/Portada.jpeg");
            sesion.save(usuario);
            sesion.save(cuenta);
            tx.commit(); 
            return true;
            
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        }  

         
    }  
     
 //Actualiza cuenta
       public boolean actualizaCuenta(Cuenta cuenta) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(cuenta); 
            tx.commit(); 
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    }  
       
//Actualiza usuario
       
        public boolean actualizaUsuario(Usuario usuario) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(usuario); 
            tx.commit(); 
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    }  
        
//Actualiza unicamente el mensaje de usuario
         public boolean actualizaMensaje(int id, String mensaje) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            String hql = "update Cuenta set mensaje=:mensaje where idUsuario=:id";
            sesion.createQuery(hql).setString("mensaje",mensaje).setLong("id", id).executeUpdate();
            tx.commit(); 
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    }
//Actualiza la descripción del usuario
         public boolean actualizaDescripcion(int id, String descripcion) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            String hql = "update Cuenta set DescripcionP=:descripcion where idUsuario=:id";
            sesion.createQuery(hql).setString("descripcion",descripcion).setLong("id", id).executeUpdate();
            tx.commit(); 
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    }
         
//Actualiza el password del usuario
         public boolean actualizaPassword(int id, int pass) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            String hql = "update Cuenta set Password=:pass where idUsuario=:id";
            sesion.createQuery(hql).setLong("pass",pass).setLong("id", id).executeUpdate();
            tx.commit(); 
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    }
        
//Actualiza la ruta de la imagen de perfil del usuario
         public boolean actualizaImagen(int id, String ruta) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            String hql = "update Cuenta set foto=:ruta where idUsuario=:id";
            sesion.createQuery(hql).setString("ruta",ruta).setLong("id", id).executeUpdate();
            tx.commit(); 
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    }
         
//Actualiza el campo de activación de la cuenta
         public boolean actualizaActivacion(int id, int valor) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            String hql = "update Cuenta set Activada=:valor where idUsuario=:id";
            sesion.createQuery(hql).setLong("valor",valor).setLong("id", id).executeUpdate();
            tx.commit(); 
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    }

//Incrementa en uno el contador de seguidores
         public boolean actualizaMasSeguidores(int id) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            String hql = "update Cuenta set NumSeguidores=NumSeguidores+1 where idUsuario=:id";
            sesion.createQuery(hql).setLong("id", id).executeUpdate();
            tx.commit(); 
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    }
//Decrementa en uno el contador de seguidores
         public boolean actualizaMenosSeguidores(int id) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            String hql = "update Cuenta set NumSeguidores=NumSeguidores-1 where idUsuario=:id";
            sesion.createQuery(hql).setLong("id", id).executeUpdate();
            tx.commit(); 
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    }
        
//Elimina cuenta
       public boolean eliminaCuenta(Usuario usuario, Cuenta cuenta) throws HibernateException 
    { 
        try 
        {             
            iniciaOperacion();            
            sesion.delete(cuenta);
            sesion.delete(usuario);
            tx.commit();
            return true;
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            return false;
        } finally 
        { 
            sesion.close(); 
        } 
    } 
       
//Busca una cuenta
        public Cuenta obtenCuenta(int idUsuario) throws HibernateException 
    { 
       Cuenta cuenta = null;  
        try 
        { 
            iniciaOperacion(); 
            cuenta = (Cuenta) sesion.get(Cuenta.class, idUsuario); 
        } finally 
        { 
            sesion.close(); 
        }  

        return cuenta; 
    }  
        
//Busca un usuario por id
        public Usuario obtenusuario(int idUsuario) throws HibernateException 
    { 
       Usuario usuario = null;  
        try 
        { 
            iniciaOperacion(); 
            usuario = (Usuario) sesion.get(Usuario.class, idUsuario); 
        } finally 
        { 
            sesion.close(); 
        }  

        return usuario; 
    }  
        
//Busca una cuenta por Pseudonimo
        public List<Cuenta> buscaPseudonimo(String pseudo) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Cuenta.class);
                  c2.add(Restrictions.eq("Pseudonimo", pseudo));
                  List<Cuenta> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
        
//Busca un autor por pseudonimo.
        public List<Cuenta> obtenCuentaPseudo(String pseudo) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Cuenta.class);
                  c2.add(Restrictions.ilike("Pseudonimo", pseudo, MatchMode.ANYWHERE));
                  List<Cuenta> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
   //Busca una cuenta por correo
         public List<Cuenta> obtenCuentaCorreo(String mail) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Cuenta.class);
                  c2.add(Restrictions.eq("email", mail));
                  List<Cuenta> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
        
    //Busca todos los usuarios
        
        
        public List<Cuenta> obtenCuentaTodos() throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Cuenta.class);
                  List<Cuenta> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
           
          

}
