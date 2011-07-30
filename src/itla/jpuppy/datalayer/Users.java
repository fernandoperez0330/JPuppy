package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Users extends Persons implements Serializable {

    @Column(length = 30)
    private String username;
    private String password;
    @Column(length = 30)
    private String typeUser;

    public Users() {
    }

    public Users(String name, String lastName, String cedula, String username, String password, String typeUser) {
        super(name, lastName, cedula);
        this.username = username;
        this.password = password;
        this.typeUser = typeUser;
    }

    public Users(String name, String lastName, String cedula, Date dateRegistered, String telephone, String cellphone, String note, String city, String email, String address, Boolean status, String username, String password, String typeUser) {
        super(name, lastName, cedula, dateRegistered, telephone, cellphone, note, city, email, address, status);
        this.username = username;
        this.password = password;
        this.typeUser = typeUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
