package manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.PseudoColumnUsage;


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


    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname, String address, String mobile) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.work = work;
        this.mobile = mobile;
        this.phone2 = phone2;
    }

}