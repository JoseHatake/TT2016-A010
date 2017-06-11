/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Cuenta;
import Modelos.Libro;
import Modelos.Seguir;
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
public class SeguirDAO {

    private Session sesion;
    private Transaction tx;

    //Obtiene el session factory para conectar con la base de datos e inicia la transacción
    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    //deshace la transacción si surge un error
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    //Inserta un seguimiento en la base.
    public boolean guardaSeguir(Seguir seguir) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.save(seguir);
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

    //Actualiza el seguimiento en la base
    public boolean actualizaSeguir(Seguir seguir) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.update(seguir);
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

    //Eliminar seguir por id
    public boolean eliminaSeguir(Seguir seguir) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(seguir);
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

    //Eliminar los seguimientos de un usuario.
    public boolean eliminaSeguirUsuario(int id) throws HibernateException {

        try {
            iniciaOperacion();
            String hql = "delete from Seguir where Usuario_idUsuario= :id";
            sesion.createQuery(hql).setLong("id", new Integer(id)).executeUpdate();
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

    //Eliminar los seguimientos a un autor
    public boolean eliminaSeguirAutor(int id) throws HibernateException {

        try {
            iniciaOperacion();
            String hql = "delete from Seguir where IDSeguido= :id and EsAutor= 1";
            sesion.createQuery(hql).setLong("id", new Integer(id)).executeUpdate();
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

    //Eliminar seguimientos a un libro
    public boolean eliminaSeguirLibro(int id) throws HibernateException {

        try {
            iniciaOperacion();
            String hql = "delete from Seguir where IDSeguido= :id and EsAutor= 0";
            sesion.createQuery(hql).setLong("id", new Integer(id)).executeUpdate();
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

    //eliminar seguimiento especifico autor
    public boolean dejarDeSeguirAutor(int id, int ids) throws HibernateException {

        try {
            iniciaOperacion();
            String hql = "delete from Seguir where Usuario_idUsuario= :id and IDSeguido= :ids and EsAutor= 1";
            sesion.createQuery(hql).setLong("id", new Integer(id)).setLong("ids", new Integer(ids)).executeUpdate();
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

    //eliminar seguimiento especifico a libro
    public boolean dejarDeSeguirLibro(int id, int ids) throws HibernateException {

        try {
            iniciaOperacion();
            String hql = "delete from Seguir where Usuario_idUsuario= :id and IDSeguido= :ids and EsAutor= 0";
            sesion.createQuery(hql).setLong("id", new Integer(id)).setLong("ids", new Integer(ids)).executeUpdate();
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }
    //Busca seguimiento por id del seguimiento

    public Seguir obtenSeguir(int id) throws HibernateException {
        Seguir seguir = null;

        try {
            iniciaOperacion();
            seguir = (Seguir) sesion.get(Seguir.class, id);
        } finally {
            sesion.close();
        }
        return seguir;
    }

    //Busca un seguimiento especifico de autor
    public List<Seguir> obtenSeguirAutor(int id, int idSeguido) throws HibernateException {

        try {
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Seguir.class);
            c2.add(Restrictions.eq("Usuario_idUsuario", id));
            c2.add(Restrictions.eq("IDSeguido", idSeguido));
            c2.add(Restrictions.eq("EsAutor", 1));
            List<Seguir> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

    //Busca un seguimiento especifico de libro
    public List<Seguir> obtenSeguirLibro(int id, int idSeguido) throws HibernateException {

        try {
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Seguir.class);
            c2.add(Restrictions.eq("Usuario_idUsuario", id));
            c2.add(Restrictions.eq("IDSeguido", idSeguido));
            c2.add(Restrictions.eq("EsAutor", 0));
            List<Seguir> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

    //Busca autores seguidos por el usuario.
    public List<Cuenta> obtenAutoresSeguidos(int id, int index, int tama) {
        int pagina = (index - 1) * tama;
        try {
            iniciaOperacion();
            List<Cuenta> lista;
            String hql = "select cuenta from Cuenta cuenta, Seguir seguir where cuenta.idUsuario=seguir.IDSeguido and seguir.Usuario_idUsuario= :id and seguir.EsAutor=1";
            lista = sesion.createQuery(hql).setLong("id", new Integer(id)).setFirstResult(pagina).setMaxResults(tama).list();
            tx.commit();
            return lista;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }
    }

    //Busca libros seguidos por el usuario
    public List<Libro> obtenLibrosSeguidos(int id, int index, int tama) {
        int pagina = (index - 1) * tama;
        try {
            iniciaOperacion();
            List<Libro> lista;
            String hql = "select libro from Libro libro, Seguir seguir where libro.idLibro=seguir.IDSeguido and seguir.Usuario_idUsuario= :id and seguir.EsAutor=0";
            lista = sesion.createQuery(hql).setLong("id", new Integer(id)).setFirstResult(pagina).setMaxResults(tama).list();
            tx.commit();
            return lista;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }
    }

    //Busca los correos de usuarios que siguen a un autor.
    public List<String> obtenCorreoAutores(int id) {

        try {
            iniciaOperacion();
            List<String> lista;
            String hql = "select cuenta.email from Cuenta cuenta, Seguir seguir where cuenta.idUsuario=seguir.Usuario_idUsuario and seguir.IDSeguido= :id and seguir.EsAutor=1";
            lista = sesion.createQuery(hql).setLong("id", new Integer(id)).list();
            tx.commit();
            return lista;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }
    }

    //Busca los correos de usuarios que siguen una obra.
    public List<String> obtenCorreoLibros(int id) {

        try {
            iniciaOperacion();
            List<String> lista;
            String hql = "select cuenta.email from Cuenta cuenta, Seguir seguir where cuenta.idUsuario=seguir.Usuario_idUsuario and seguir.IDSeguido= :id and seguir.EsAutor=0";
            lista = sesion.createQuery(hql).setLong("id", new Integer(id)).list();
            tx.commit();
            return lista;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }
    }
    /* //Busca Autores seguidos por el usuario
      public List<Seguir> obtenSeguirAutores(int id) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Seguir.class);
                  c2.add(Restrictions.eq("Usuario_idUsuario", id));
                  c2.add(Restrictions.eq("EsAutor", 1));
                  List<Seguir> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }
      
    //Busca libros seguidos por el usuario      
      
      public List<Seguir> obtenSeguirLibros(int id) throws HibernateException{
            
              try{
                  iniciaOperacion();
                  Criteria c2 = sesion.createCriteria(Seguir.class);
                  c2.add(Restrictions.eq("Usuario_idUsuario", id));
                  c2.add(Restrictions.eq("EsAutor", 0));
                  List<Seguir> res = c2.list();                      
                  return res;
                  
                  
              }catch (HibernateException he){
                  
                      manejaExcepcion(he); 
                      throw he; 
                     
                     
              } finally { 
                  sesion.close();
              }
              
           
        }*/

}
