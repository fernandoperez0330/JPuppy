package itla.jpuppy.datalayer;

import itla.jpuppy.utils.GeneratedValues;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persons implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String lastName;
    @Column(length = 30, unique = true)
    private String cedula;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRegistered;
    @Column(length = 13)
    private String telephone;
    @Column(length = 13)
    private String cellphone;
    @Column(length = 200)
    private String note;
    @Column(length = 30)
    private String city;
    @Column(length = 100)
    private String address;
    @Column(length = 100)
    private String email;
    private Boolean status;

    public Persons() {
    }

    public Persons(String name, String lastName, String cedula) {
        this.name = name;
        this.lastName = lastName;
        this.cedula = cedula;
    }

    public Persons(String name, String lastName, String cedula, Date dateRegistered, String telephone, String cellphone, String note, String city, String email, String address, Boolean status) {
        this.name = name;
        this.lastName = lastName;
        this.cedula = cedula;
        this.dateRegistered = dateRegistered;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.note = note;
        this.city = city;
        this.email = email;
        this.address = address;
        this.status = status;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
