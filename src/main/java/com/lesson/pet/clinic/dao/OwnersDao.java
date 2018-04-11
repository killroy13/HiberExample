package com.lesson.pet.clinic.dao;

import com.lesson.pet.clinic.dao.exception.DaoException;
import com.lesson.pet.clinic.entity.Owner;

/**
 * Created by User on 11.04.2018.
 */
public interface OwnersDao extends GenericDao<Owner> {

    Owner getById(int id) throws DaoException;
}
