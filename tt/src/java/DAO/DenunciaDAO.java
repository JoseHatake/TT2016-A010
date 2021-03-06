/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Denuncia;
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
public class DenunciaDAO {
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
    
    //Guarda una denuncia en la base de datos.
    
    public boolean guardaDenuncia(Denuncia denuncia) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.save(denuncia);
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
    
    //Actualiza una denuncia
    
    public boolean actualizaDenuncia(Denuncia denuncia) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.update(denuncia);
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
    
    // Elimina una denuncia por id
    
    public boolean eliminaDenuncia(Denuncia denuncia) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.delete(denuncia);
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
    
    //Elimina denuncias por el id del libro
   public boolean eliminaDenunciaLibro(int id) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            String hql = "delete from Denuncia where Libro_idLibro= :id";
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
   
   //Elimina denuncias por id del autor
   
   public boolean eliminaDenunciaUsuario(int id) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            String hql = "delete from Denuncia where Usuario_idUsuario= :id";
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
    
    //Busca una denuncia por id
    
    public Denuncia obtenDenuncia(int id)throws HibernateException{
        Denuncia denuncia= null;
        
        try{
            iniciaOperacion(); 
            denuncia = (Denuncia) sesion.get(Denuncia.class, id); 
        }finally{
            sesion.close();
        }
        return denuncia;
    }
    
   //Busca denuncias por id de libro
    
    public List<Denuncia> obtenDenunciaLibro(int id) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Denuncia.class);
                  c2.add(Restrictions.eq("Libro_idLibro", id));
                  List<Denuncia> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
    
    //Busca una denuncia por id del usuario
    
    public List<Denuncia> obtenDenunciaUsuario(int id) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Denuncia.class);
                  c2.add(Restrictions.eq("Usuario_idUsuario", id));
                  List<Denuncia> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
    
}
