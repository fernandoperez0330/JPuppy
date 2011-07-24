package itla.jpuppy.business;

import itla.jpuppy.datalayer.Customers;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelCustomers implements GeneralModel {

    private QueryManager queryManager;

    public ModelCustomers() {
        queryManager = new QueryManager();
    }

    //retorna un objeto especifico tipo Customer cuando se llame debe cargarse el Id desde generalVariableID del paquete util
    //los datos se le asignan cuando el usuario selecciona un cliente  del table
    
    public Customers searchCustomer(int id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Customers temp = entityManager.find(Customers.class, id);
        return temp;
    }

    // retorna lista de Customer para autocomplete
    
    public List<Customers> searchAllCustomerByName(String name) {
        return queryManager.searchCustomer(name);
    }

    //Metodos comunes a todos los modelos , se llama el correspondiente de  queryManager
    
    @Override
    public boolean insertObject(Object object) {
        Customers g = ( Customers ) object;
        return queryManager.saveObject( g );
    }

    @Override
    public boolean updateObject(Object object) {
        Customers g = ( Customers ) object;
        return queryManager.updateObject( g );
    }

    @Override
    public boolean deleteObject(Object object) {
        Customers g = ( Customers )object;
        return queryManager.deleteObject( g );
    }
}
