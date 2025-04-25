package manager;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        homePage();
    }

    public void createContactInGroup(ContactData contact, GroupData group) {
        openCreateContactsPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        homePage();
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        selectGroupWithContact(group);
        selectContact(contact);
        removeFrom();
        homePage();
    }

    public void addContactToGroup(ContactData contact, GroupData group) {
        selectContact(contact);
        chooseGroup(group);
        addToGroup();
        homePage();
    }

    private void addToGroup() {
        click(By.name("add"));
    }

    private void chooseGroup(GroupData group) {
        click(By.name("to_group"));
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    private void selectGroupWithContact(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    public void removeContact(ContactData contact) {
        homePage();
        selectContact(contact);
        removeSelectedContact();
    }

    public void removeAllContact() {
        selectAllContact();
        removeSelectedContact();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        homePage();
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        homePage();
    }

    public int getCount() {
        homePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void submitContactCreation() {
        click(By.name("submit"));
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
        type(By.name("mobile"), contact.mobile());
        type(By.name("email"), contact.email());
        type(By.name("email3"), contact.email3());
        if (contact.photo() != null && !contact.photo().isEmpty()) {
            attach(By.name("photo"), contact.photo());
        }

    }

    private void removeSelectedContact() {
        click(By.xpath("//*[@value='Delete']"));
    }

    private void removeFrom() {
        click(By.name("remove"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void selectAllContact() {
        click(By.id("MassCB"));
    }

    private void initContactModification(ContactData contact) {
        click(By.xpath(String.format("//input[@value='%s']/ancestor::tr//img[@title='Edit']", contact.id())));

    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var rows = manager.driver.findElements(By.name("entry"));
        for (var row : rows) {
            var lastN = row.findElement(By.xpath("./td[2]"));
            var firstN = row.findElement(By.xpath("./td[3]"));
            var lastName = lastN.getText();
            var firstName = firstN.getText();
            var checkbox = row.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));

        }
        return contacts;
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }

    public Map<String, String> getEmails() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var emails = row.findElements(By.tagName("td")).get(4).getText();
            result.put(id, emails);
        }
        return result;
    }

    public Map<String, String> getAddresses() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var addresses = row.findElements(By.tagName("td")).get(3).getText();
            result.put(id, addresses);
        }
        return result;
    }

    public void createContactIfNotExist() {
        if (manager.hbm().getContactCount() == 0) {
            createContact(new ContactData()
                    .withFirstName(CommonFunctions.randomString(5))
                    .withLastName(CommonFunctions.randomString(5))
                    .withAddress(CommonFunctions.randomString(5))
                    .withMobilePhone(CommonFunctions.randomPhoneNumber(7)));
        }
    }

    public ContactData createRandomContact() {
        ContactData contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(5))
                .withLastName(CommonFunctions.randomString(5))
                .withMobilePhone(CommonFunctions.randomPhoneNumber(7));
        createContact(contact);
        return contact;
    }


}