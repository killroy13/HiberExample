package com.lesson.pet.clinic.service;

import com.lesson.pet.clinic.dao.GenericDao;
import com.lesson.pet.clinic.dao.exception.DaoException;
import com.lesson.pet.clinic.entity.Pet;

/**
 * Created by User on 13.04.2018.
 */
public interface PetService extends GenericDao<Pet> {

    Pet getById(int id) throws DaoException;

}
