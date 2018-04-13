package com.lesson.pet.clinic.service.impl;

import com.lesson.pet.clinic.dao.PetDao;
import com.lesson.pet.clinic.dao.exception.DaoException;
import com.lesson.pet.clinic.entity.Pet;
import com.lesson.pet.clinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 13.04.2018.
 */
@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetDao petDao;

    @Transactional(/*readOnly = true*/)
    @Override
    public Pet getById(int id) throws DaoException {
        return petDao.getById(id);
    }

    @Transactional(/*readOnly = true*/)
    @Override
    public List<Pet> getAll() throws DaoException {
        return petDao.getAll();
    }

    @Transactional
    @Override
    public void insert(Pet pet) throws DaoException {
        petDao.insert(pet);
    }

    @Transactional
    @Override
    public void update(Pet pet) throws DaoException {
        petDao.update(pet);
    }

    @Transactional
    @Override
    public void delete(int id) throws DaoException {
        petDao.delete(id);
    }
}
