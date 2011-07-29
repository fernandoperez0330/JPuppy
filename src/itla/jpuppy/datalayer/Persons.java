/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package itla.jpuppy.datalayer;

import itla.jpuppy.utils.enumPersonPhone;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

/**
 *
 * @author Administrator
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Persons implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    @Column(length = 30,nullable= true, unique=false)
    private String name;
    private String lastName;
    private String cedula;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRegistered;
    @Enumerated(EnumType.STRING)
    private enumPersonPhone phone;
    @Column(length = 100)
    private String note;
    private String city;
    private String email;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public enumPersonPhone getPhone() {
        return phone;
    }

    public void setPhone(enumPersonPhone phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    private Boolean status;

    
}
