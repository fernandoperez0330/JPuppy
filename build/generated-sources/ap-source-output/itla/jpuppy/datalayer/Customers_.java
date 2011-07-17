package itla.jpuppy.datalayer;

import itla.jpuppy.datalayer.Patients;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-07-17T13:55:10")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, Integer> id;
    public static volatile SingularAttribute<Customers, String> nombre;
    public static volatile SingularAttribute<Customers, String> apellido;
    public static volatile SingularAttribute<Customers, String> mail;
    public static volatile SingularAttribute<Customers, String> direcion;
    public static volatile SingularAttribute<Customers, String> ciudad;
    public static volatile SingularAttribute<Customers, String> nota;
    public static volatile SingularAttribute<Customers, Boolean> estado;
    public static volatile SingularAttribute<Customers, String> telefono;
    public static volatile ListAttribute<Customers, Patients> pacientes;
    public static volatile SingularAttribute<Customers, Date> fechaRegistro;
    public static volatile SingularAttribute<Customers, String> celular;

}