package model;

public record ContactData(String id,
                          String firstName,
                          String lastName,
                          String address,
                          String home,
                          String work,
                          String mobile,
                          String phone2,
                          String photo,
                          String email,
                          String email2,
                          String email3,
                          String address2) {

    public ContactData() {
        this("", "", "", "", "", "", "",
                "", "", "", "", "","");
    }
    public ContactData withId(String id) {
        return new ContactData(
                id, this.firstName, this.lastName, this.address , this.home, this.work, this.mobile,
                this.phone2, this.photo, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(
                this.id, firstName, this.lastName, this.address , this.home, this.work, this.mobile,
                this.phone2, this.photo, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(
                this.id, this.firstName, lastName, this.address, this.home, this.work, this.mobile,
                this.phone2, this.photo, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withAddress(String address) {
        return new ContactData(
                this.id, this.firstName, this.lastName, address, this.home, this.work, this.mobile,
                this.phone2, this.photo, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withHomePhone(String home) {
        return new ContactData(
                this.id, this.firstName, this.lastName, this.address, home, this.work, this.mobile,
                this.phone2, this.photo, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withWorkPhone(String work) {
        return new ContactData(
                this.id, this.firstName, this.lastName, this.address, this.home, work, this.mobile,
                this.phone2, this.photo, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withMobilePhone(String mobile) {
        return new ContactData(
                this.id, this.firstName, this.lastName, this.address, this.home, this.work, mobile,
                this.phone2, this.photo, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withPhone2(String phone2) {
        return new ContactData(
                this.id, this.firstName, this.lastName, this.address, this.home, this.work,
                this.mobile, phone2, this.photo, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(
                this.id, this.firstName, this.lastName, this.address, this.home, this.work, this.mobile,
                this.phone2, photo, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withEmail(String email) {
        return new ContactData(
                this.id, this.firstName, this.lastName, this.address, this.home, this.work, this.mobile,
                this.phone2, this.photo, email, this.email2, this.email3, this.address2);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(
                this.id, this.firstName, this.lastName, this.address, this.home, this.work, this.mobile,
                this.phone2, this.photo, this.email, email2, this.email3, this.address2);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(
                this.id, this.firstName, this.lastName, this.address, this.home, this.work, this.mobile,
                this.phone2, photo, this.email, this.email2, email3, this.address2);
    }

    public ContactData withAddress2(String address2) {
        return new ContactData(
                this.id, this.firstName, this.lastName, this.address, this.home, this.work, this.mobile,
                this.phone2, this.photo, this.email, this.email2, this.email3, address2);
    }
}
