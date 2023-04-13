package tests;

import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("dasha@gmail.com").withPassword("Ashtanga8!"));
        }
        //app.helperContact().provideContacts();

    }


    @Test
    public void removeFirstContact(){

    }
    @Test
    public void removeAllContacts(){

    }
}