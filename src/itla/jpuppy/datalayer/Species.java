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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
public class Species implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long speciesId;
    @Column(length = 30, nullable = false, unique = true)
    private String speciesName;
    @OneToMany(mappedBy = "specie")
    private List<Breeds> breeds;

    public Species() {
    }

    public Species(String speciesName) {
        this.speciesName = speciesName;
    }

    public Species(String speciesName, List<Breeds> breeds) {
        this.speciesName = speciesName;
        this.breeds = breeds;
    }

    public long getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(long speciesId) {
        this.speciesId = speciesId;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public List<Breeds> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Breeds> breeds) {
        this.breeds = breeds;
    }
}
