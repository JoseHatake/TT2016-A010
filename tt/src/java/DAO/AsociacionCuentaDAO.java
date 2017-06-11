/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Asociacion_Cuenta;
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
public class AsociacionCuentaDAO {
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
    
    //Guarda una asociacion de cuenta en la base
    
    public boolean guardaAsociacion(Asociacion_Cuenta asociacion) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.save(asociacion);
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
    
    //Actualiza una asociación de cuenta en la base
    
    public boolean actualizaAsociacion(Asociacion_Cuenta asociacion) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.update(asociacion);
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
    
    //Elimina una asociacion de cuenta en la base por id
    public boolean eliminaAsociacion(Asociacion_Cuenta asociacion) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.delete(asociacion);
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
    
    //Elimina una asociacion de la base por id de usuario
    
     public boolean eliminaAsociacionUsuario(int id) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            String hql = "delete from Asociacion_Cuenta where Usuario_idUsuario= :id";
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
    
    //Elimina una asociacion de la base por id de red social
     
    public boolean eliminaAsociacionRed(String id) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            String hql = "delete from Asociacion_Cuenta where Red_Social_Clave= :id";
            sesion.createQuery(hql).setString("id", id).executeUpdate();
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
    
    //Busca una asociación por id
    
    public Asociacion_Cuenta obtenAsociacion(int id)throws HibernateException{
        Asociacion_Cuenta asociacion= null;
        
        try{
            iniciaOperacion(); 
            asociacion = (Asociacion_Cuenta) sesion.get(Asociacion_Cuenta.class, id); 
        }finally{
            sesion.close();
        }
        return asociacion;
    }

   //Busca asociaciones por usuario
    
    public List<Asociacion_Cuenta> obtenAsociacionUsuario(int id) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Asociacion_Cuenta.class);
                  c2.add(Restrictions.eq("Usuario_idUsuario", id));
                  List<Asociacion_Cuenta> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
    
}
