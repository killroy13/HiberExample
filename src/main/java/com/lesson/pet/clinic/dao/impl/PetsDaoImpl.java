package com.lesson.pet.clinic.dao.impl;

import com.lesson.pet.clinic.dao.PetsDao;
import com.lesson.pet.clinic.dao.exception.DaoException;
import com.lesson.pet.clinic.entity.Pet;
import com.lesson.pet.clinic.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by User on 11.04.2018.
 */
public class PetsDaoImpl implements PetsDao {
    public Pet getById(int id) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Pet pet;
        try {
            session.beginTransaction();
            pet = session.load(Pet.class, id);
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new DaoException("Error in getById method: " + ex);
        }
        return pet;
    }

    public List<Pet> getAll() throws DaoException {
        List<Pet> result;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            result = session.createQuery("from Pet order by id").list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new DaoException("Error in getAll method: " + ex);
        }
        return result;
    }

    public void insert(Pet pet) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(pet);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new DaoException("Error in insert method: " + ex);
        }
    }

    public void update(Pet pet) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(pet);
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
            Pet pet = session.get(Pet.class, id);
            session.delete(pet);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new DaoException("Error in delete method", ex);
        }
    }
}
