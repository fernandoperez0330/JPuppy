/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Fernando
 */
public class QueryManager {

    private EntityManager entityManager;

    public QueryManager() {
        entityManager = EntityManagerCreator.getInstanceEM();
    }

    public boolean saveObject(Object object) {

        return true;
    }

    public boolean deleteObject(Object object) {
        return true;
    }

    public boolean updateObject(Object object) {
        return true;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public List<Users> searchUser(String name) {
        return null;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public List<Customers> searchCustomer(String name) {
        return null;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Patients> searchPatient(String name) {
        return null;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Species> searchSpecie(String name) {
        return null;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Breeds> searchBreeds(String name) {
        return null;
    }
}
