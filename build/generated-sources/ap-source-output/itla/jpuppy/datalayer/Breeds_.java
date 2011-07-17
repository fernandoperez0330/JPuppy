package itla.jpuppy.datalayer;

import itla.jpuppy.datalayer.Species;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-07-17T13:55:10")
@StaticMetamodel(Breeds.class)
public class Breeds_ { 

    public static volatile SingularAttribute<Breeds, Integer> id;
    public static volatile SingularAttribute<Breeds, String> nombre;
    public static volatile SingularAttribute<Breeds, Species> especie;

}