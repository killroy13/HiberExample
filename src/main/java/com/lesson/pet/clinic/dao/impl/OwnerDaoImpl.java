package com.lesson.pet.clinic.dao.impl;

import com.lesson.pet.clinic.dao.OwnerDao;
import com.lesson.pet.clinic.dao.exception.DaoException;
import com.lesson.pet.clinic.entity.Owner;
import com.lesson.pet.clinic.entity.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 10.04.2018.
 */
@Repository
public class OwnerDaoImpl implements OwnerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Owner getById(int id) throws DaoException {
        Session session = sessionFactory.openSession();
        Owner owner;
        try {
//            session.beginTransaction();

            // if not exist return null
            owner = session.get(Owner.class, id);

            // if not exist - ObjectNotFoundException
//            owner = session.load(Owner.class, id);
            //LazyInitializationException

//            session.getTransaction().commit();
        } catch (Exception ex) {
//            session.getTransaction().rollback();
            throw new DaoException("Error in getById method: " + ex);
        }
        return owner;
    }

    public List<Owner> getAll() throws DaoException {
//        @SuppressWarnings("unchecked")
//        TypedQuery<Owner> query = sessionFactory.getCurrentSession().createQuery("from Owner");
//        return query.getResultList();

        List<Owner> result;
        Session session = sessionFactory.openSession();
        try {
        result = session.createQuery("from Owner order by id").list();
        } catch (Exception ex) {
            throw new DaoException("Error in getAll method: " + ex);
        }
        return result;
    }

    public List<Pet> getAllPetByOwnerId(int id) throws DaoException {
        List<Pet> result;
        Session session = sessionFactory.openSession();
//        Session session = sessionFactory.getCurrentSession();
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Session session = getHibernateTemplate().getSessionFactory().openSession();
        try {
            result = session.createQuery("from Pet where " + "owner.id = " + id).list();
        } catch (Exception ex) {
            throw new DaoException("Error in getAllPetByOwnerId method: " + ex);
        }
        return result;
    }

    public void insert(Owner owner) throws DaoException {
        Session session = sessionFactory.openSession();
        try {
            session.save(owner);
        } catch (Exception ex) {
            throw new DaoException("Error in insert method: " + ex);
        }
    }

    public void update(Owner owner) throws DaoException {
        Session session = sessionFactory.openSession();
        try {
//            session.beginTransaction();
            session.saveOrUpdate(owner);
//            session.flush();
//            session.getTransaction().commit();
        } catch (Exception ex) {
//            session.getTransaction().rollback();
            throw new DaoException("Error in update method", ex);
        }
    }

    public void delete(int id) throws DaoException {
        Session session = sessionFactory.openSession();
        try {
            Owner owner = session.get(Owner.class, id);
            session.delete(owner);
        } catch (Exception ex) {
            throw new DaoException("Error in delete method", ex);
        }
    }
}
