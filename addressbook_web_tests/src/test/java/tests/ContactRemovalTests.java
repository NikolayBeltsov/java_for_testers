package tests;

import common.CommonFunctions;
import io.qameta.allure.Epic;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    @Epic("Проверка контактов")
    @DisplayName("Удаление случайного контакта")
    public void canRemoveContact() {
        app.contacts().createContactIfNotExist();
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }

    @Test
    @Epic("Проверка контактов")
    @DisplayName("Удаление контакта из группы")
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
                    .withMobilePhone(CommonFunctions.randomPhoneNumber(7));
            app.contacts().createContactInGroup(contact, group);
        }

        var oldRelated = app.hbm().getContactsInGroup(group);
        var contact = oldRelated.get(new Random().nextInt(oldRelated.size()));
        app.contacts().removeContactFromGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);

        Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
    }

    @Test
    @Epic("Проверка контактов")
    @DisplayName("Удаление всех контактов")
    public void canRemoveAllContact() {
        //Если нет контакта, то создаем новый
        app.contacts().createContactIfNotExist();
        //Удаляем контакт
        app.contacts().removeAllContact();
        Assertions.assertEquals(0, app.hbm().getContactCount());
    }
}
