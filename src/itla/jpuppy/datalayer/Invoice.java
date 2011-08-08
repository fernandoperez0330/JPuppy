/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Invoice implements Serializable {
    @Id
    private long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateBorn;
    private double total;
    @ManyToOne
    private Customers customer;
    @ManyToMany(mappedBy = "invoices")
    private List<Articles> articles;

    public Invoice() {
    }

    public Invoice(Date dateBorn, double total, Customers customer, List<Articles> articles) {
        this.dateBorn = dateBorn;
        this.total = total;
        this.customer = customer;
        this.articles = articles;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
   
    
}
