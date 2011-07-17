package itla.jpuppy.datalayer;

import itla.jpuppy.datalayer.Breeds;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-07-17T13:55:10")
@StaticMetamodel(Species.class)
public class Species_ { 

    public static volatile SingularAttribute<Species, Integer> id;
    public static volatile SingularAttribute<Species, String> nombre;
    public static volatile ListAttribute<Species, Breeds> razas;

}