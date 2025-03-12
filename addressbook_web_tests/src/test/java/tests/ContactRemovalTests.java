package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        //Если нет контакта, то создаем новый
        if (!app.contacts().isContactsPresent()) {
            app.contacts().createContact(new ContactData("Vasya", "Pupkin", "Pushkina street", "89055553322"));
        }
        //Удаляем контакт
        app.contacts().removeContact();

    }

    @Test
    public void canRemoveAllContact() {
        //Если нет контакта, то создаем новый
        if (!app.contacts().isContactsPresent()) {
            app.contacts().createContact(new ContactData("Vasya", "Pupkin", "Pushkina street", "89055553322"));
        }
        //Удаляем контакт
        app.contacts().removeAllContact();
    }
}
