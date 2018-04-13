package com.lesson.pet.clinic.dao;

import com.lesson.pet.clinic.dao.exception.DaoException;
import com.lesson.pet.clinic.entity.Pet;

/**
 * Created by User on 11.04.2018.
 */
public interface PetDao extends GenericDao<Pet>{

    Pet getById(int id) throws DaoException;

}
