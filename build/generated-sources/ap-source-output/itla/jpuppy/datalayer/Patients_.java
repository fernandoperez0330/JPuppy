package itla.jpuppy.datalayer;

import itla.jpuppy.datalayer.Customers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-07-17T13:55:10")
@StaticMetamodel(Patients.class)
public class Patients_ { 

    public static volatile SingularAttribute<Patients, Integer> id;
    public static volatile SingularAttribute<Patients, String> nombre;
    public static volatile SingularAttribute<Patients, String> notas;
    public static volatile SingularAttribute<Patients, Customers> dueño;
    public static volatile SingularAttribute<Patients, Date> fechaNacimiento;
    public static volatile SingularAttribute<Patients, Date> ultimaVisita;

}