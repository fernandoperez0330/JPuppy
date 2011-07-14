package itla.jpuppy.datalayer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Breeds implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    
    @Column(length=30,nullable=false)
    private String nombre;
    
    @ManyToOne
    private Species especie;

    public Species getEspecie() {
        return especie;
    }

    public void setEspecie(Species especie) {
        this.especie = especie;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
