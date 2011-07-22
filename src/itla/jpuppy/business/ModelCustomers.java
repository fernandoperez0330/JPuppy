package itla.jpuppy.business;

import itla.jpuppy.datalayer.Customers;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelCustomers implements GeneralModel {

    private QueryManager queryManager;

    public ModelCustomers() {
        queryManager = new QueryManager();
    }

    private Customers searchCustomer(int id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Customers temp = entityManager.find(Customers.class, id);
        return temp;
    }

    public List<Customers> searchAllCustomerByName(String name) {
        return queryManager.searchCustomer(name);
    }

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
