package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;
import java.util.List;
import javax.persistence.EntityManager;
import org.w3c.dom.events.Event;

public class QueryManager {

    private EntityManager entityManager;

    public QueryManager() {
        entityManager = EntityManagerCreator.getInstanceEM();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public boolean saveObject(Object object) {
        boolean status;

        entityManager.getTransaction().begin();
        try {
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            status = true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            status = false;
        }
        return status;
    }

    public boolean deleteObject(Object object) {
        boolean state = true;
        
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(object);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            state = false;
        }
        return state;
    }

    public boolean updateObject(Object object) {
        boolean state = true;
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(object);
            entityManager.getTransaction().commit();
        } catch (Exception f) {
            state = false;
        }
        return state;
    }

    public Users searchUserValidated(String name, String password) {
        Users user = null;
        try {
            user = (Users) entityManager.createQuery("SELECT a FROM Users a WHERE a.username = :nameToFind and a.password = :password").setParameter("nameToFind", name).setParameter("password", password).getSingleResult();
        } catch (Exception e) {
        }
        return user;
    }

    //Metodos Disponibles para autocomplete en busqueda
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public List<Users> searchUsers(String name) {
        List<Users> listUsers = entityManager.createQuery("SELECT a FROM Users a WHERE LOWER(a.name) LIKE :nameToFind").setParameter("nameToFind", name).getResultList();
        return listUsers;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public List<Customers> searchCustomer(String name) {
        List<Customers> listCustomers = entityManager.createQuery("SELECT a FROM Customers a WHERE LOWER(a.name) LIKE :nameToFind").setParameter("nameToFind", name).getResultList();
        return listCustomers;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Patients> searchPatient(String patientsId) {
        List<Patients> listPatients = entityManager.createQuery("SELECT a FROM Patients a WHERE LOWER(a.patientsId) LIKE :nameToFind").setParameter("nameToFind", patientsId).getResultList();
        return listPatients;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Species> searchSpecie(String name) {
        List<Species> listSpecieses = entityManager.createQuery("SELECT a FROM Species a WHERE LOWER(a.speciesName) LIKE :nameToFind").setParameter("nameToFind", name).getResultList();
        return listSpecieses;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Breeds> searchBreeds(String name) {
        List<Breeds> listBreeds = entityManager.createQuery("SELECT a FROM Breeds a WHERE LOWER(a.breedsName) LIKE :nameToFind").setParameter("nameToFind", name).getResultList();
        return listBreeds;

    }

    @Override
    protected void finalize() {
        entityManager.close();
    }
}
