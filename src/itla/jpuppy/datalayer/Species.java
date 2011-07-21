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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Species implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int speciesId;
    
    @Column(length=30,nullable=false,unique=true)
    private String speciesName;

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String name) {
        this.speciesName = name;
    }

    public int getSpeciesId() {
        return speciesId;
    }
    
    
}
