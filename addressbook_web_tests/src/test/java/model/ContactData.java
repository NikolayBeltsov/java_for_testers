package model;

public record ContactData(String id, String firstName, String lastName, String address, String home, String work,
                          String mobile, String phone2,
                          String photo
) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.lastName, this.address , this.home, this.work, this.mobile, this.phone2, this.photo);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.lastName, this.address , this.home, this.work, this.mobile, this.phone2, this.photo);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstName, lastName, this.address, this.home, this.work, this.mobile, this.phone2, this.photo);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.lastName, address, this.home, this.work, this.mobile, this.phone2, this.photo);
    }

    public ContactData withHomePhone(String home) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, home, this.work, this.mobile, this.phone2, this.photo);
    }

    public ContactData withWorkPhone(String work) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.home, work, this.mobile, this.phone2, this.photo);
    }

    public ContactData withMobilePhone(String mobile) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.home, this.work, mobile, this.phone2, this.photo);
    }

    public ContactData withPhone2(String phone2) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.home, this.work, this.mobile, phone2, this.photo);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.home, this.work, mobile, this.phone2, photo);
    }
}
