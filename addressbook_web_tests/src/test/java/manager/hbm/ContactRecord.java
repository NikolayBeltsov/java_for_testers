package manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    public int id;


    public String firstname;
    public String lastname;
    public String address;
    public String home;
    public String work;
    public String mobile;
    public String phone2;
    public String email;
    public String email2;
    public String email3;
    public String address2;


    public ContactRecord() {
    }

    public ContactRecord(
            int id, String firstname, String lastname, String address, String home, String work, String mobile,
            String phone2, String email, String email2, String email3, String address2) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.work = work;
        this.mobile = mobile;
        this.phone2 = phone2;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.address2 = address2;
    }

}