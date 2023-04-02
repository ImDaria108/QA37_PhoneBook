package manager;

import models.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HelperContact extends HelperBase {

    public HelperContact (WebDriver wd){
        super(wd);
    }

    public void openAddContactform(){
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillContactForm (Contact contact){
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastname());
        type(By.cssSelector("[placeholder='Phone']"), String.valueOf(contact.getPhone()));
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void returntoHome() {
        click(By.cssSelector("a[href='/home']"));
    }

}
