package com.lesson.pet.clinic.main;

import com.lesson.pet.clinic.config.AppConfig;
import com.lesson.pet.clinic.entity.Owner;
import com.lesson.pet.clinic.entity.Pet;
import com.lesson.pet.clinic.service.OwnerService;
import com.lesson.pet.clinic.service.PetService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by User on 10.04.2018.
 */
public class AppMain {


//    public void init(){
//        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//
//    }

    public static void main(final String[] args) throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        OwnerService ownerService = context.getBean(OwnerService.class);
        PetService petService = context.getBean(PetService.class);


//        AppMain appMain = new AppMain();
//        appMain.init();


        Owner owner1 = new Owner();
        owner1.setFirstName("Test");
        owner1.setSecondName("Test2");

        Owner owner2 = new Owner();
        owner2.setId(16);
        owner2.setFirstName("Sally");
        owner2.setSecondName("Hunny");

        Pet pet4 = new Pet();
        pet4.setPetsId(6);
        pet4.setKindOfPet("mouse");
        pet4.setPetsName("Genry");




        Pet pet1 = new Pet("dog", "Dorsy"/*, owner1*/);
        Pet pet2 = new Pet("cat", "Billy"/*, owner2*/);

//        pet1.setOwner(owner1);
//        pet2.setOwner(owner2);


        try {
            //owner

//            ownersDao.insert(owner1);
            ownerService.update(owner2);
//            ownersDao.delete(2);


            List<Owner> result = ownerService.getAll();
            System.out.println(result);

            System.out.println(ownerService.getById(15));


            //pet

//            petService.insert(pet2);
            petService.update(pet4);
//            petService.delete(2);


            List<Pet> resultPet = petService.getAll();
            System.out.println(resultPet);

            System.out.println(petService.getById(2));


            //all pets of 1 owner
            System.out.println(ownerService.getAllPetByOwnerId(15));


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            context.close();
        }
    }
}
