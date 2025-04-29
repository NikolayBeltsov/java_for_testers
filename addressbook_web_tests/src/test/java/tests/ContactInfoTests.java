package tests;

import io.qameta.allure.Epic;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    @Epic("Проверка контактов")
    @DisplayName("Проверка телефонных номеров контакта")
    void testPhones() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData(
                    "",
                    "first name",
                    "last name",
                    "address",
                    "",
                    "",
                    "89055553322",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""));
        }

        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
            Stream.of(contact.home(), contact.mobile(), contact.work(), contact.phone2())
                    .filter(s -> s != null && ! "".equals(s))
                    .collect(Collectors.joining("\n"))
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);
    }

    @Test
    @Epic("Проверка контактов")
    @DisplayName("Проверка адресов контакта")
    void testAddress() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData(
                    "",
                    "first name",
                    "last name",
                    "address",
                    "",
                    "",
                    "89055553322",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""));
        }


        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.address(), contact.address2())
                        .filter(s -> s != null && ! "".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var addresses = app.contacts().getAddresses();
        Assertions.assertEquals(expected, addresses);
    }

    @Test
    @Epic("Проверка контактов")
    @DisplayName("Проверка корректности email-адресов контакта")
    void testEmail() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData(
                    "",
                    "first name",
                    "last name",
                    "address",
                    "",
                    "",
                    "89055553322",
                    "",
                    "",
                    "email1",
                    "",
                    "email3",
                    ""));
        }

        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.email(), contact.email2(), contact.email3())
                        .filter(s -> s != null && ! "".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var emails = app.contacts().getEmails();
        Assertions.assertEquals(expected, emails);

    }
}
