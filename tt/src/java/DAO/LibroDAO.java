/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Libro;
import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lock
 */
public class LibroDAO {

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

    //Inserta un libro en la base de datos.
    public boolean guardaLibro(Libro libro) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.save(libro);
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

    //Actualiza un libro en la base.   
    public boolean actualizaLibro(Libro libro) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.update(libro);
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

//Actualiza la ruta de la portada del libro
    public boolean actualizaPortada(int id, String ruta) throws HibernateException {
        try {
            iniciaOperacion();
            String hql = "update Libro set Portada=:ruta where idLibro=:id";
            sesion.createQuery(hql).setString("ruta", ruta).setLong("id", id).executeUpdate();
            tx.commit();
            return true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }
    }

//Actualiza la descripcion de un libro
    public boolean actualizaDescripcion(int id, String desc) throws HibernateException {
        try {
            iniciaOperacion();
            String hql = "update Libro set Descripcion=:desc where idLibro=:id";
            sesion.createQuery(hql).setString("desc", desc).setLong("id", id).executeUpdate();
            tx.commit();
            return true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }
    }
//Actualiza el status de un libro

    public boolean actualizaEstado(int id, int estado) throws HibernateException {
        try {
            iniciaOperacion();
            String hql = "update Libro set Status=:stat where idLibro=:id";
            sesion.createQuery(hql).setLong("stat", estado).setLong("id", id).executeUpdate();
            tx.commit();
            return true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }
    }

// Aumenta el contador de likes
    public boolean masLikes(int id) throws HibernateException {
        try {
            iniciaOperacion();
            String hql = "update Libro set Likes=Likes+1 where idLibro=:id";
            sesion.createQuery(hql).setLong("id", id).executeUpdate();
            tx.commit();
            return true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }
    }

//Disminuye el contador de likes
    public boolean menosLikes(int id) throws HibernateException {
        try {
            iniciaOperacion();
            String hql = "update Libro set Likes=Likes-1 where idLibro=:id";
            sesion.createQuery(hql).setLong("id", id).executeUpdate();
            tx.commit();
            return true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }
    }

//Elimina un libro  por id de libro
    public boolean eliminaLibro(Libro libro) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(libro);
            tx.commit();
            return true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            return false;
        } finally {
            sesion.close();
        }

    }

//Elimina un libro por id de autor
    public boolean eliminaLibroAutor(int id) throws HibernateException {

        try {
            iniciaOperacion();
            String hql = "delete from Libro where Usuario_idUsuario= :id";
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

//Busca un libro por id
    public Libro obtenLibro(int id) throws HibernateException {
        Libro libro = null;

        try {
            iniciaOperacion();
            libro = (Libro) sesion.get(Libro.class, id);
        } finally {
            sesion.close();
        }
        return libro;
    }

//Busca un libros por id del autor
    public List<Libro> obtenLibroAutor(int id, int index, int tama) throws HibernateException {

        int pagina = (index - 1) * tama;

        try {
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Libro.class);
            c2.add(Restrictions.eq("Usuario_idUsuario", id));
            c2.setFirstResult(pagina);
            c2.setMaxResults(tama);
            List<Libro> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

//Busca libros por titulo   
    public List<Libro> obtenLibroTitulo(String titulo) throws HibernateException {

        try {
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Libro.class);
            c2.add(Restrictions.ilike("Nombre", titulo, MatchMode.ANYWHERE));
            List<Libro> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

//Busca libros por género
    public List<Libro> obtenLibroGenero(String categoria) throws HibernateException {

        try {
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Libro.class);
            c2.add(Restrictions.ilike("Clasificacion", categoria, MatchMode.ANYWHERE));
            List<Libro> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }
//Busca libros por idioma

    public List<Libro> obtenLibroIdioma(String idioma) throws HibernateException {

        try {
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Libro.class);
            c2.add(Restrictions.ilike("idioma", idioma, MatchMode.ANYWHERE));
            List<Libro> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

    //Busca una seleccion de los libros  recientes.
    public List<Libro> buscaRecientes(String idioma, int index, int tama) throws HibernateException {
        int pagina = (index - 1) * tama;

        try {
            iniciaOperacion();
            List<Libro> libros;
            String hql = "select libro from Libro libro where idioma= :idioma order by Hora_fecha desc";
            libros = sesion.createQuery(hql).setString("idioma", idioma).setFirstResult(pagina).setMaxResults(tama).list();
            tx.commit();
            return libros;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

    }

    //Busca una seleccion de los libros más gustados
    public List<Libro> buscaGustados(String idioma, int index, int tama) throws HibernateException {
        int pagina = (index - 1) * tama;

        try {
            iniciaOperacion();
            List<Libro> libros;
            String hql = "select libro from Libro libro where idioma= :idioma order by likes desc";
            libros = sesion.createQuery(hql).setString("idioma", idioma).setFirstResult(pagina).setMaxResults(tama).list();
            tx.commit();
            return libros;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

    }

    //busca una selección de libros al azar
    public List<Libro> buscaRandom(String idioma, int tama) throws HibernateException {

        try {
            iniciaOperacion();
            List<Libro> libros;
            String hql = "select libro from Libro libro where idioma= :idioma order by rand() desc";
            libros = sesion.createQuery(hql).setString("idioma", idioma).setMaxResults(tama).list();
            tx.commit();
            return libros;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

    }

    //Realiza la busqueda ciega de libros
    public List<Libro> obtenLibroBusqueda(String busqueda, int index, int tama) throws HibernateException {
        int pagina = (index - 1) * tama;

        try {
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Libro.class);
            c2.add(Restrictions.disjunction()
                    .add(Restrictions.ilike("Nombre", busqueda, MatchMode.ANYWHERE))
                    .add(Restrictions.ilike("Clasificacion", busqueda, MatchMode.ANYWHERE))
                    .add(Restrictions.ilike("Descripcion", busqueda, MatchMode.ANYWHERE)));
            c2.setFirstResult(pagina);
            c2.setMaxResults(tama);
            List<Libro> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

    //Busqueda paginada de libros
    public List<Libro> obtenLibrosPaginados(int pagina, int tama) throws HibernateException {

        try {
            int col = (pagina - 1) * tama;
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Libro.class);
            c2.setFirstResult(col);
            c2.setMaxResults(tama);
            List<Libro> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

    //Busca todos los libros de la base
    public List<Libro> obtenLibroTodos() throws HibernateException {

        try {
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Libro.class);
            List<Libro> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

}
