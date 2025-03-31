package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        //Если нет контакта, то создаем новый
        if (!app.contacts().isContactsPresent()) {
            app.contacts().createContact(new ContactData("", "first name", "last name", "address", "89055553322"));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        //Удаляем контакт
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }

    @Test
    public void canRemoveAllContact() {
        //Если нет контакта, то создаем новый
        if (!app.contacts().isContactsPresent()) {
            app.contacts().createContact(new ContactData("", "Vasya", "Pupkin", "Pushkina street", "89055553322"));
        }
        //Удаляем контакт
        app.contacts().removeAllContact();
    }
}
