package com.lesson.pet.clinic.main;

import com.lesson.pet.clinic.dao.impl.OwnersDaoImpl;
import com.lesson.pet.clinic.entity.Owner;
import com.lesson.pet.clinic.utils.HibernateUtil;

import java.util.List;

/**
 * Created by User on 10.04.2018.
 */
public class AppMain {

    public static void main(final String[] args) throws Exception {

        OwnersDaoImpl ownersService = new OwnersDaoImpl();

        Owner owner1 = new Owner();
        owner1.setFirstName("Test");
        owner1.setSecondName("Test2");

        Owner owner2 = new Owner();
        owner2.setId(4);
        owner2.setFirstName("Golli");
        owner2.setSecondName("Dolly");


        try {
            ownersService.insert(owner1);

            ownersService.delete(2);

            List<Owner> result = ownersService.getAll();
            System.out.println(result);

            ownersService.update(owner2);

            System.out.println(ownersService.getById(15));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
