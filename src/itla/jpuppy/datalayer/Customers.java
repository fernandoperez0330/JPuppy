package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Customers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customersId;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String lastname;
    @Column(length = 12)
    private String telephone;
    @Column(length = 12)
    private String cellphone;
    @Column(length = 50)
    private String address;
    @Column(length = 20)
    private String city;
    @Column(length = 40)
    private String mail;
    @Column(length = 255)
    private String notes;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;
    @OneToMany
    private List<Patients> patients;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sysDate;
    @Column(nullable = false)
    private boolean custormersState;

    public Customers() {
    }

    public Customers(String name, String lastname, String telephone, String cellphone, String address, String city, String mail, String notes, byte[] image, List<Patients> patients, Date sysDate, boolean custormersState) {
        this.name = name;
        this.lastname = lastname;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.address = address;
        this.city = city;
        this.mail = mail;
        this.notes = notes;
        this.image = image;
        this.patients = patients;
        this.sysDate = sysDate;
        this.custormersState = custormersState;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    public boolean isCustormersState() {
        return custormersState;
    }

    public void setCustormersState(boolean custormersState) {
        this.custormersState = custormersState;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }

    public Date getSysDate() {
        return sysDate;
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
