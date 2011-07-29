/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrator
 */
@Entity
public class Doctor extends Employees implements Serializable{
    
    @Column 
    private String speciality;

    @OneToMany
    private List<Appointments> appointments;

    public Doctor(String speciality, List<Appointments> appointments) {
        this.speciality = speciality;
        this.appointments = appointments;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public Doctor() {
    }
    
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
