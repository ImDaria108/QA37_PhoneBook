package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("dasha@gmail.com").withPassword("Ashtanga8!"));
        }
        app.helperContact().provideContacts();


    }


    @Test(groups = {"smoke"})
    public void removeFirstContact(){
        Assert.assertEquals(app.helperContact().removeOneContact(),1);

    }
    @Test
    public void removeAllContacts(){
        app.helperContact().removeAllContacts();
        Assert.assertEquals(app.getHelperUser().getMessage(),"No Contacts here!");

    }
}