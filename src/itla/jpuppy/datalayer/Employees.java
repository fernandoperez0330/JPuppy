/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Administrator
 */
@Entity
public class Employees extends Persons implements Serializable {

    @Column(nullable = false,length=40)
    private String jobPosition;

    public Employees() {
    }

    public Employees(String name, String lastName, String cedula, String jobPosition) {
        super(name, lastName, cedula);
        this.jobPosition = jobPosition;
    }

    public Employees(String name, String lastName, String cedula, String jobPosition, String phone, String cellPhone) {
        super(name, lastName, cedula);
        this.jobPosition = jobPosition;
        super.setTelephone(phone);
        super.setCellphone(cellPhone);
    }

    public Employees(String name, String lastName, String cedula, Date dateRegistered, String telephone, String cellphone, String note, String city, String email, String address, Boolean status, String jobPosition) {
        super(name, lastName, cedula, dateRegistered, telephone, cellphone, note, city, email, address, status);
        this.jobPosition = jobPosition;
    }

    public String getPosition() {
        return jobPosition;
    }

    public void setPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }
}
