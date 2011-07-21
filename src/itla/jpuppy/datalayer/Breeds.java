package itla.jpuppy.datalayer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Breeds extends Species implements Serializable{
    
    @Column(length=30,nullable=false,unique=true)
    private String breedsName;
    
    private int height;
    
    private int width;

    public String getBreedsName() {
        return breedsName;
    }

    public void setBreedsName(String name) {
        this.breedsName = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
      
}
