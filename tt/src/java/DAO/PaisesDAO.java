/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Paises;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lock
 */
public class PaisesDAO {

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

    //Obtiene todos los paises de la base (solo nombre)
    public List<String> obtenTodosPaises() throws HibernateException {

        try {
            iniciaOperacion();
            List<String> lista;
            String hql = "select p.nombre from Paises p";
            lista = sesion.createQuery(hql).list();
            tx.commit();
            return lista;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }
    //obten todos
    public List<Paises> obtenTodos() throws HibernateException {

        try {
            iniciaOperacion();
            Criteria c2 = sesion.createCriteria(Paises.class);
            List<Paises> res = c2.list();
            return res;

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

}
