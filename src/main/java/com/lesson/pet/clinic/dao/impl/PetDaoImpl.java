package com.lesson.pet.clinic.dao.impl;

import com.lesson.pet.clinic.dao.PetDao;
import com.lesson.pet.clinic.dao.exception.DaoException;
import com.lesson.pet.clinic.entity.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 11.04.2018.
 */
@Repository
public class PetDaoImpl implements PetDao {

    @Autowired
    SessionFactory sessionFactory;

    public Pet getById(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        Pet pet;
        try {
            pet = session.get(Pet.class, id);
        } catch (Exception ex) {
            throw new DaoException("Error in getById method: " + ex);
        }
        return pet;
    }

    public List<Pet> getAll() throws DaoException {
        List<Pet> result;
        Session session = sessionFactory.getCurrentSession();
        try {
            result = session.createQuery("from Pet order by petsId").list();
        } catch (Exception ex) {
            throw new DaoException("Error in getAll method: " + ex);
        }
        return result;
    }

    @Override
    public void update(Pet pet) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(pet);
        } catch (Exception ex) {
            throw new DaoException("Error in update method", ex);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            Pet pet = session.get(Pet.class, id);
            session.delete(pet);
        } catch (Exception ex) {
            throw new DaoException("Error in delete method", ex);
        }
    }

    public void insert(Pet pet) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(pet);
        } catch (Exception ex) {
            throw new DaoException("Error in insert method: " + ex);
        }
    }
}