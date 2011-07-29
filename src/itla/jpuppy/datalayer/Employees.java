/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package itla.jpuppy.datalayer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Administrator
 */
@Entity
public class Employees extends Persons implements Serializable{
    
    @Column
    private String position;
    
    public Employees(){}

    public Employees(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
    
    
    
    

}
