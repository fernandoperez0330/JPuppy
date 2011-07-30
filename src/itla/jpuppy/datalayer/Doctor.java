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
public class Doctor extends Employees implements Serializable {

    private String speciality;
    @OneToMany
    private List<Appointments> appointments;

    public Doctor() {
    }

    public Doctor(String name, String lastName, String cedula, String jobPosition) {
        super(name, lastName, cedula, jobPosition);
    }

    public Doctor(String name, String lastName, String cedula, String jobPosition, String speciality) {
        super(name, lastName, cedula, jobPosition);
        this.speciality = speciality;
    }

    

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
