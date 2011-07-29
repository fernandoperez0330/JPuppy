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
public class Clients extends Persons implements Serializable{

    @Column
    @OneToMany
    private List<Patients> patients;

    public Clients(){}

    public Clients(List<Patients> patients)
    {
        this.patients = patients;
    }

    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }

    



}
