package com.lesson.pet.clinic.dao;

        import com.lesson.pet.clinic.dao.exception.DaoException;
        import com.lesson.pet.clinic.entity.Owner;
        import com.lesson.pet.clinic.entity.Pet;

        import java.util.List;

/**
 * Created by User on 11.04.2018.
 */
public interface OwnerDao extends GenericDao<Owner> {

    Owner getById(int id) throws DaoException;

    List<Pet> getAllPetByOwnerId(int id) throws DaoException;
}
