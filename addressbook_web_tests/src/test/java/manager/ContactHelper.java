package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openCreateContactsPage() {
        if (!manager.isElementPresent(By.name("submit"))) {
            click(By.linkText("add new"));
        }
    }


    public boolean isContactsPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        openCreateContactsPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void removeContact() {
        selectContact();
        removeSelectedContact();
    }

    public void removeAllContact() {
        selectAllContact();
        removeSelectedContact();
    }

    public int getCount() {
        homePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void homePage() {
        if (!manager.isElementPresent(By.id("MassCB"))) {
            click(By.linkText("home"));
        }
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.phone());
    }

    private void removeSelectedContact() {
        click(By.xpath("//*[@value='Delete']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void selectAllContact() {
        click(By.id("MassCB"));
    }

}