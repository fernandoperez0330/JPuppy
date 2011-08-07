package itla.jpuppy.business;

import itla.jpuppy.datalayer.Customers;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.EntityManager;

public class ModelCustomers implements GeneralModel {

    private QueryManager queryManager;

    public ModelCustomers() {
        queryManager = new QueryManager();
    }

    public QueryManager getQueryManager() {
        return queryManager;
    }

    //retorna un objeto especifico tipo Customer cuando se llame debe cargarse el Id desde generalVariableID del paquete util
    //los datos se le asignan cuando el usuario selecciona un cliente  del table
    public Customers searchCustomer(long id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Customers temp = entityManager.find(Customers.class, id);
        return temp;
    }

    // retorna lista de Customer para autocomplete
    public List<Customers> searchAllCustomerByName(String name) {
        return queryManager.searchCustomer(name);
    }

    //Retorna una lista completa de usuarios para seleccion
    public List<Customers> searchAllCustomer() {
        return queryManager.searchCustomer();
    }

    public boolean checkDuplicateCedula(String cedula) {
        if (queryManager.searchPersonByCedula(cedula).size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public Customers getCustomer(String name) {

        List<Customers> list = this.searchAllCustomerByName(name);
        ListIterator<Customers> iterator = list.listIterator();
        Customers temp = null;
        while (iterator.hasNext()) {
            temp = iterator.next();
        }
        return temp;
    }

    //Metodos comunes a todos los modelos , se llama el correspondiente de  queryManager
    @Override
    public boolean insertObject(Object object) {
        Customers g = (Customers) object;
        return queryManager.saveObject(g);
    }

    @Override
    public boolean updateObject(Object object) {
        Customers g = (Customers) object;
        return queryManager.updateObject(g);
    }

    @Override
    public boolean deleteObject(Object object) {
        Customers g = (Customers) object;
        return queryManager.deleteObject(g);
    }
}
