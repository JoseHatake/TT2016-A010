/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Capitulo;
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
public class CapituloDAO {
    
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
    
    //Guarda un capitulo en la base de datos
    
    public boolean guardaCapitulo(Capitulo capitulo) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.save(capitulo);
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
    
    //Actualiza un capitulo en la base de datos
    public boolean actualizaCapitulo(Capitulo capitulo) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.update(capitulo);
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
    
    //Elimina un capitulo por id
    
   /* public boolean eliminaCapitulo(Capitulo capitulo) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.delete(capitulo);
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
        
    }*/
    
    //Elimina capitulos por libro
    
    public boolean eliminaCapitulo(int id) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            String hql = "delete from Capitulo where idCapitulo= :id";
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
    
    //Busca capitulo por id
    
     public Capitulo obtenCapitulo(int id)throws HibernateException{
        Capitulo capitulo= null;
        
        try{
            iniciaOperacion(); 
            capitulo = (Capitulo) sesion.get(Capitulo.class, id); 
        }finally{
            sesion.close();
        }
        return capitulo;
    }
     
    //Busca capitulos por libro
     
     public List<Capitulo> obtenCapitulosLibro(int id) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Capitulo.class);
                  c2.add(Restrictions.eq("Libro_idLibro", id));
                  List<Capitulo> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
     
    
    
}
