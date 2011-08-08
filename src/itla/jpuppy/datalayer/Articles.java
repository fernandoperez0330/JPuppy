/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.datalayer;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Jordhano
 */
@Entity
public class Articles implements Serializable{
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long articleId;
    @Column(length=30)
    private String name;
    private double price;
    private int amount;
    @Column(length=150)
    private String description;
    @ManyToMany
    private List<Invoice> invoices;
    
    public Articles() {
    }

    public Articles(String name, double price, int amount, String description) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }
    
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
