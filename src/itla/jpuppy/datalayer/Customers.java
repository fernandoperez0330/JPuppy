package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customers extends Persons implements Serializable {

    @OneToMany
    private List<Patients> patients;

    public Customers() {
       
    }

    public Customers(String name, String lastName, String cedula) {
        super(name, lastName, cedula);
    }

    public Customers(String name, String lastName, String cedula, String city) {
        super(name, lastName, cedula);
        super.setCity(city);
    }

    public Customers(String name, String lastName, String cedula, List<Patients> patients) {
        super(name, lastName, cedula);
        this.patients = patients;
    }

    public Customers(String name, String lastName, String cedula, Date dateRegistered, String telephone, String cellphone, String note, String city, String email, String address, Boolean status) {
        super(name, lastName, cedula, dateRegistered, telephone, cellphone, note, city, email, address, status);
    }

    public Customers(String name, String lastName, String cedula, Date dateRegistered, String telephone, String cellphone, String note, String city, String email, String address, Boolean status, List<Patients> patients) {
        super(name, lastName, cedula, dateRegistered, telephone, cellphone, note, city, email, address, status);
        this.patients = patients;
    }

    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }
}
