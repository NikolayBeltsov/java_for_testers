package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationsTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("first name", "last name", "address", "89991112233"));
    }

    @Test
    public void canCreateContactWithEmptyData() {
        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithPhoneOnly() {
        app.contacts().createContact(new ContactData().withPhone("88005553555"));
    }
}
