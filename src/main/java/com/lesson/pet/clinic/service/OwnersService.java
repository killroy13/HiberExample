package com.lesson.pet.clinic.service;

import com.lesson.pet.clinic.entity.Owner;
import com.lesson.pet.clinic.utils.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by User on 10.04.2018.
 */
public class OwnersService {

    public void addOwner(Owner owner) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(owner);
        session.getTransaction().commit();
    }

    public List<Owner> getAllOwners() {
        List<Owner> result = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            result = session.createQuery("from Owner order by firstName").list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
        }
        return result;
    }

    public Owner getOwnerById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Owner result = null;
        try {
            session.beginTransaction();
            result = session.load(Owner.class, id);
            Hibernate.initialize(getAllOwners());
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }



}
