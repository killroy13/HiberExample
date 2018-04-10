import com.lesson.pet.clinic.entity.Owner;
import com.lesson.pet.clinic.service.OwnersService;
import com.lesson.pet.clinic.utils.HibernateUtil;

import java.util.List;

/**
 * Created by User on 10.04.2018.
 */
public class Main {

    public static void main(final String[] args) throws Exception {

        OwnersService ownersService = new OwnersService();

        Owner owner1 = new Owner();
        owner1.setFirstName("Test");
        owner1.setSecondName("Test2");

        ownersService.addOwner(owner1);

        List<Owner> result = ownersService.getAllOwners();
        System.out.println(result);

        System.out.println(ownersService.getOwnerById(15));


        HibernateUtil.shutdown();

    }
}
