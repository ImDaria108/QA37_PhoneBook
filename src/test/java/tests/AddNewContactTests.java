package tests;

import models.Contact;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class AddNewContactTests extends TestBase {


    @BeforeClass
    public void preCondition (){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("dasha@gmail.com").setPassword("Ashtanga8!"));
        }
    }

    @Test
    public void addNewContactSuccessAll(){
        Contact contact = Contact.builder()
                .name("Harry")
                .lastname("Potter")
                .phone(666777888)
                .email("hp1990@mail.com")
                .address("Hogsmid")
                .description("Shool")
                .build();
    }

@AfterMethod
    public void postCondition(){
        app.getHelperContact().returntoHome();
}

}
