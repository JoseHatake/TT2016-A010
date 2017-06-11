/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Red_social;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lock
 */
public class RedSocialDAO {
    
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
    
    //Inserta una red social 
    
    public boolean guardaRedSocial(Red_social red) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.save(red);
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
    
    //Actualiza red social
    
     public boolean actualizaRedSocial(Red_social red) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.update(red);
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
     
    //Elimina red social por id
     
    public boolean eliminaRedSocial(Red_social red) throws HibernateException {     

        try 
        { 
            iniciaOperacion(); 
            sesion.delete(red);
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
    
    //Busca red social por id
    
    public Red_social obtenRedSocial(String id)throws HibernateException{
        Red_social red= null;
        
        try{
            iniciaOperacion(); 
            red = (Red_social) sesion.get(Red_social.class, id); 
        }finally{
            sesion.close();
        }
        return red;
    }
    
}
