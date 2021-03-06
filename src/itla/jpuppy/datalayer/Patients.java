/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Patients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patientsId;
    @Column(length = 30, nullable = false)
    private String name;
    @ManyToOne
    private Customers owner;
    @Column(length = 255)
    private String notes;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.DATE)
    private Date lastVisit;
    @Transient
    private String doctorLastVisit;

    public Patients() {
    }

    public Patients(String name, Customers owner, String notes, Date birthDate, Date lastVisit, String doctorLastVisit) {
        this.name = name;
        this.owner = owner;
        this.notes = notes;
        this.birthDate = birthDate;
        this.lastVisit = lastVisit;
        this.doctorLastVisit = doctorLastVisit;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getDoctorLastVisit() {
        return doctorLastVisit;
    }

    public void setDoctorLastVisit(String doctorLastVisit) {
        this.doctorLastVisit = doctorLastVisit;
    }
    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Customers getOwner() {
        return owner;
    }

    public void setOwner(Customers owner) {
        this.owner = owner;
    }

    public long getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(long patientsId) {
        this.patientsId = patientsId;
    }
    
    
}
