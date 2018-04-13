package com.lesson.pet.clinic.service.impl;

import com.lesson.pet.clinic.dao.OwnerDao;
import com.lesson.pet.clinic.dao.exception.DaoException;
import com.lesson.pet.clinic.entity.Owner;
import com.lesson.pet.clinic.entity.Pet;
import com.lesson.pet.clinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 13.04.2018.
 */
@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerDao ownerDao;

    @Transactional(/*readOnly = true*/)
    @Override
    public Owner getById(int id) throws DaoException {
        return ownerDao.getById(id);
    }

    @Override
    public List<Pet> getAllPetByOwnerId(int id) throws DaoException {
        return ownerDao.getAllPetByOwnerId(id);
    }

    @Transactional(/*readOnly = true*/)
    @Override
    public List<Owner> getAll() throws DaoException {
        return ownerDao.getAll();
    }

    @Transactional
    @Override
    public void insert(Owner owner) throws DaoException {
        ownerDao.insert(owner);
    }

    @Transactional
    @Override
    public void update(Owner owner) throws DaoException {
        ownerDao.update(owner);
    }

    @Transactional
    @Override
    public void delete(int id) throws DaoException {
        ownerDao.delete(id);
    }
}
