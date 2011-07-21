/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Patients extends Breeds implements Serializable {
    
    @Column(length = 15, nullable=false, unique=true)
    private String patientsId;
    @Column(length = 30, nullable=false)
    private String name;
    @ManyToOne
    private Customers owner;
    @Column(length = 255)
    private String notes;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Lob @Basic(fetch= FetchType.LAZY)
    private byte[] image;
    @Temporal(TemporalType.DATE)
    private Date lastVisit;
    @Transient
    private String doctorLastVisit;

    public String getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(String patientsId) {
        this.patientsId = patientsId;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    /*
     * 
     */
}
