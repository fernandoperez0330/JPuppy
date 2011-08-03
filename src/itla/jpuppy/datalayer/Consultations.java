/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import itla.jpuppy.utils.TypeConsultations;

/**
 *
 * @author HENSLEY
 */
@Entity
public class Consultations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @ManyToOne
    private Customers customer;
    @ManyToOne
    private Patients patients;
    @Column(length = 255)
    private String remark;
    @OneToOne
    private Appointments appointments;
    @Enumerated
    private TypeConsultations typeConsultations;

    public TypeConsultations getTypeConsultations() {
        return typeConsultations;
    }

    public void setTypeConsultations(TypeConsultations typeConsultations) {
        this.typeConsultations = typeConsultations;
    }

    public Consultations(Long id, Date dateStart, Date dateEnd, Customers customer, Patients patients, String remark, Appointments appointments, TypeConsultations typeConsultations) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.customer = customer;
        this.patients = patients;
        this.remark = remark;
        this.appointments = appointments;
        this.typeConsultations = typeConsultations;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointments getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointments appointments) {
        this.appointments = appointments;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
  
}
