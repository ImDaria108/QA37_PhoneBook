package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class AddNewContactTests extends TestBase {

    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("dasha@gmail.com").withPassword("Ashtanga8!"));
        }
    }

    @Test
    public void addContactSuccessAllFields() {
        int i= new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Harry")
                .lastname("Potter")
                .phone("66677788"+i)
                .email("hp"+i+"@mail.com")
                .address("Hogsmid")
                .description("School")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addContactSuccessRequiredFields() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("MaryJane" + i)
                .lastname("Wotson")
                .address("Chicago")
                .phone("2390561" + i)
                .email("MJ" + i + "@gmail.com")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactWrongName() {
        Contact contact = Contact.builder()
                .name("")
                .lastname("Wotson")
                .address("Chicago")
                .phone("2390561783")
                .email("MJ@gmail.com")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongAddress() {
        Contact contact = Contact.builder()
                .name("MaryJane")
                .lastname("Wotson")
                .address("")
                .phone("23905610909")
                .email("MJ@gmail.com")
                .description("Cool girl")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName() {
        Contact contact = Contact.builder()
                .name("MaryJane")
                .lastname("")
                .address("Chicago")
                .phone("23905610991")
                .email("MJ@gmail.com")
                .description("Cool girl")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongPhone() {
        Contact contact = Contact.builder()
                .name("MaryJane")
                .lastname("Wotson")
                .address("Chicago")
                .phone("")
                .email("MJ@gmail.com")
                .description("Cool girl")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));


    }

    @Test
    public void addNewContactWrongEmail() {
        Contact contact = Contact.builder()
                .name("MaryJane")
                .lastname("Wotson")
                .address("Chicago")
                .phone("3892018389")
                .email("MJgmail.com")
                .description("Cool girl")
                .build();
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: must be a well-formed email address"));

    }
}