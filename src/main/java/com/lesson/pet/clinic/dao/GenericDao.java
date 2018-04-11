package com.lesson.pet.clinic.dao;

import com.lesson.pet.clinic.dao.exception.DaoException;

import java.util.List;

/**
 * Created by User on 11.04.2018.
 */
public interface GenericDao<T> {

    List<T> getAll() throws DaoException;

    void insert(T t) throws DaoException;

    void update(T t) throws DaoException;

    void delete(/*T t, */int id) throws DaoException;
}
