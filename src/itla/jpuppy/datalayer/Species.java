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
import javax.persistence.OneToMany;


@Entity
public class Species implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    
    @Column(length=30,nullable=false)
    private String nombre;
    
    @OneToMany
    private List<Breeds> razas;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Breeds> getRazas() {
        return razas;
    }

    public void setRazas(List<Breeds> razas) {
        this.razas = razas;
    }
    
}
