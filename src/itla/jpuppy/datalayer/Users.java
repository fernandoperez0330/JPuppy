/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.datalayer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users implements Serializable {
    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userId;
    
    @Column(length=30,nullable=false)
    private String name;
    
    @Column(length=30,nullable=false)
    private String lastname;
    
    @Column(length=12)
    private String telephone;
    
    @Column(length=12)
    private String cellphone;
    
    @Column(length=30,nullable=false)
    private String typeUser;

    public int getUserId() {
        return userId;
    }
    
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    
}
