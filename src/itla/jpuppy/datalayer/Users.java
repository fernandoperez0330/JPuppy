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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(length = 30)
    private String username;
    private String password;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String lastname;
    @Column(length = 12)
    private String telephone;
    @Column(length = 12)
    private String cellphone;
    @Column(length = 30)
    private String typeUser;

    public Users() {
    }

    public Users(String username,String name, String lastname, String password, String telephone, String cellphone, String typeUser) {
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.typeUser = typeUser;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
