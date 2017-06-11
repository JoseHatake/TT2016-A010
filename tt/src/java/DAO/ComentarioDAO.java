/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Comentario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lock
 */
public class ComentarioDAO {
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
    
    //Guarda un comentario en la base.
    
    public boolean guardaComentario(Comentario comentario) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.save(comentario);
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
    
    //Actualiza un comentario en la base
    
    public boolean actualizaComentario(Comentario comentario) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.update(comentario);
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
    
    //Elimina un comentario por id de comentario
    
    public boolean eliminaComentario(Comentario comentario) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.delete(comentario);
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
    
    //Elimina comentarios por id de autor
    
    public boolean eliminaComentarioAutor(int id) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            String hql = "delete from Comentario where Usuario_idUsuario= :id";
            sesion.createQuery(hql).setLong("id", new Integer(id)).executeUpdate();
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
    
    //Elimina comentarios por id de libro
    
    public boolean eliminaComentarioLibro(int id) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            String hql = "delete from Comentario where Libro_idLibro= :id";
            sesion.createQuery(hql).setLong("id", new Integer(id)).executeUpdate();
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
    
    //Busca un comentario por id
    
    public Comentario obtenComentario(int id)throws HibernateException{
        Comentario comentario= null;
        
        try{
            iniciaOperacion(); 
            comentario = (Comentario) sesion.get(Comentario.class, id); 
        }finally{
            sesion.close();
        }
        return comentario;
    }
    
    //Busca comentarios por id del libro
    
    public List<Comentario> obtenComentarioLibro(int id) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Comentario.class);
                  c2.add(Restrictions.eq("Libro_idLibro", id));
                  List<Comentario> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
    
    //Busca comentarios por id del autor
    
    public List<Comentario> obtenComentarioAutor(int id) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Comentario.class);
                  c2.add(Restrictions.eq("Usuario_idUsuario", id));
                  List<Comentario> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }

}
