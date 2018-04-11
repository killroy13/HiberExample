package com.lesson.pet.clinic.dao.impl;

import com.lesson.pet.clinic.dao.OwnersDao;
import com.lesson.pet.clinic.dao.exception.DaoException;
import com.lesson.pet.clinic.entity.Owner;
import com.lesson.pet.clinic.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by User on 10.04.2018.
 */
//@Component("ownersDao")
public class OwnersDaoImpl implements OwnersDao {


    public Owner getById(int id) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Owner owner;
        try {
            session.beginTransaction();
            owner = session.load(Owner.class, id);
            //LazyInitializationException
//            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new DaoException("Error in getById method: " + ex);
        }
        return owner;
    }

    public List<Owner> getAll() throws DaoException {
        List<Owner> result;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            result = session.createQuery("from Owner order by firstName").list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new DaoException("Error in getAll method: " + ex);
        }
        return result;
    }

    public void insert(Owner owner) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(owner);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new DaoException("Error in insert method: " + ex);
        }
    }

    public void update(Owner owner) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(owner);
            session.flush();
            session.getTransaction().commit();
        }catch (Exception ex){
            session.getTransaction().rollback();
            throw new DaoException("Error in update method", ex);
        }
    }

    public void delete(int id) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Owner owner = session.get(Owner.class, id);
            session.delete(owner);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new DaoException("Error in delete method", ex);
        }
    }

}
