package com.lesson.pet.clinic.main;

import com.lesson.pet.clinic.dao.impl.OwnersDaoImpl;
import com.lesson.pet.clinic.dao.impl.PetsDaoImpl;
import com.lesson.pet.clinic.entity.Owner;
import com.lesson.pet.clinic.entity.Pet;
import com.lesson.pet.clinic.utils.HibernateUtil;

/**
 * Created by User on 10.04.2018.
 */
public class AppMain {

    public static void main(final String[] args) throws Exception {

        OwnersDaoImpl ownersDao = new OwnersDaoImpl();

        PetsDaoImpl petsDao = new PetsDaoImpl();

        Owner owner1 = new Owner();
        owner1.setFirstName("Test");
        owner1.setSecondName("Test2");

        Owner owner2 = new Owner();
        owner2.setId(1);
        owner2.setFirstName("Killy");
        owner2.setSecondName("CAtty");

        Pet pet1 = new Pet("dog", "Dorsy", owner1);
        Pet pet2 = new Pet("cat", "Billy", owner2);

//        pet1.setOwner(owner1);
        pet2.setOwner(owner2);

        try {

//            petsDao.insert(pet2);

//            List<Pet> resultPet = petsDao.getAll();
//            System.out.println(resultPet);

//            ownersDao.insert(owner1);
//            ownersDao.delete(2);
//            List<Owner> result = ownersDao.getAll();
//            System.out.println(result);
//            ownersDao.update(owner2);
//            System.out.println(ownersDao.getById(15));


            System.out.println(ownersDao.getAllPetByOwnerId(15));


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
