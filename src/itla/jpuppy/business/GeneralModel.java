package itla.jpuppy.business;

//Inteface publica a todos los modelos 

public interface GeneralModel {
 
    boolean insertObject(Object object);

    boolean updateObject(Object object);

    boolean deleteObject(Object object);
}
