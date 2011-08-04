/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package itla.jpuppy.datalayer;

import itla.jpuppy.utils.enumAppointmentStatus;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Temporal;

/**
 *
 * @author Administrator
 */
@Entity
public class Appointments implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRegistered;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date acordedDate;
    @ManyToOne
    private Patients patient;
    @ManyToOne
    private Doctor doctor;
    @Enumerated
    private enumAppointmentStatus status;

    public Appointments(){}

    public Appointments(Date dateRegistered, Date acordedDate, Patients patient, Doctor doctor, enumAppointmentStatus status) {
        this.dateRegistered = dateRegistered;
        this.acordedDate = acordedDate;
        this.patient = patient;
        this.doctor = doctor;
        this.status = status;
    }



    public Date getAcordedDate() {
        return acordedDate;
    }

    public void setAcordedDate(Date acordedDate) {
        this.acordedDate = acordedDate;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public enumAppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(enumAppointmentStatus status) {
        this.status = status;
    }

 
    

}
