package itla.jpuppy.datalayer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Breeds implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long breedsId;
    @Column(length = 30, nullable = false, unique = true)
    private String breedsName;
    @ManyToOne
    private Species specie;
    private double height;
    private double width;

    public Breeds() {
    }

    public Breeds(String breedsName, double height, double width) {
        this.breedsName = breedsName;
        this.height = height;
        this.width = width;
    }
    
    

    public Breeds(String breedsName, Species specie, double height, double width) {
        this.breedsName = breedsName;
        this.specie = specie;
        this.height = height;
        this.width = width;
    }

    public long getBreedsId() {
        return breedsId;
    }

    public void setBreedsId(long breedsId) {
        this.breedsId = breedsId;
    }

    public String getBreedsName() {
        return breedsName;
    }

    public void setBreedsName(String breedsName) {
        this.breedsName = breedsName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Species getSpecie() {
        return specie;
    }

    public void setSpecie(Species specie) {
        this.specie = specie;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    
}
