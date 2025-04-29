package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import io.qameta.allure.Epic;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ContactCreationsTests extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        var json = Files.readString(Paths.get("contacts.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    @Epic("Contact Management")
    @DisplayName("Create contacts from JSON data")
    public void canCreateMultipleContact(ContactData contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContact = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareById);

        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContact.get(newContact.size() - 1).id()).withPhoto(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContact, expectedList);

    }

    @Test
    @Epic("Contact Management")
    @DisplayName("Create contact with random data")
    void canCreateContact() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(5))
                .withLastName(CommonFunctions.randomString(5))
                .withAddress(CommonFunctions.randomString(5))
                .withMobilePhone(CommonFunctions.randomPhoneNumber(7))
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }

    @Test
    @Epic("Contact Management")
    @DisplayName("Create contact within group")
    void canCreateContactInGroup() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(5))
                .withLastName(CommonFunctions.randomString(5))
                .withAddress(CommonFunctions.randomString(5))
                .withMobilePhone(CommonFunctions.randomPhoneNumber(7));

        app.groups().createGroupIfNotExist();

        var group = app.hbm().getGroupList().get(0);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().createContactInGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }

    @Test
    @Epic("Contact Management")
    @DisplayName("Add contact to group")
    void canAddContactToGroup() {
        app.groups().createGroupIfNotExist();
        app.contacts().createContactIfNotExist();

        var pair = app.hbm().findContactNotInAnyGroup().orElseGet(() -> {
            app.contacts().createRandomContact();

            ContactData newContact = app.hbm().getContactList().stream()
                    .max(Comparator.comparingInt(c -> Integer.parseInt(c.id()))).get();

            return Map.entry(newContact, app.hbm().getGroupList().get(0));
        });

        ContactData contact = pair.getKey();
        GroupData group = pair.getValue();
        
        var oldContacts = app.hbm().getContactsInGroup(group).size();
        app.contacts().addContactToGroup(contact, group);
        var newContacts = app.hbm().getContactsInGroup(group).size();

        Assertions.assertEquals(oldContacts + 1, newContacts);
    }

}

