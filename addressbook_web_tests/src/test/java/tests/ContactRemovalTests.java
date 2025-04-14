package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        //Если нет контакта, то создаем новый
        if (app.hbm().getContactCount() == 0) {
            app.contacts().createContact(new ContactData("", "first name", "last name", "address", "89055553322", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        //Удаляем контакт
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }

    @Test
    void canRemoveContactFromGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        if (app.hbm().getContactsInGroup(group).size() == 0) {
            var contact = new ContactData()
                    .withFirstName(CommonFunctions.randomString(5))
                    .withLastName(CommonFunctions.randomString(5))
                    .withAddress(CommonFunctions.randomString(5))
                    .withPhone(CommonFunctions.randomPhoneNumber(7));
            app.contacts().createContactInGroup(contact, group);
        }

        var oldRelated = app.hbm().getContactsInGroup(group);
        var contact = oldRelated.get(new Random().nextInt(oldRelated.size()));
        app.contacts().removeContactFromGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);

        Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
    }

    @Test
    public void canRemoveAllContact() {
        //Если нет контакта, то создаем новый
        if (app.hbm().getContactCount() == 0) {
            app.contacts().createContact(new ContactData("", "Vasya", "Pupkin", "Pushkina street", "89055553322", ""));
        }
        //Удаляем контакт
        app.contacts().removeAllContact();
        Assertions.assertEquals(0, app.hbm().getContactCount());
    }
}
