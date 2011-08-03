package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

public class QueryManager {

    private EntityManager entityManager;

    public QueryManager() {
        entityManager = EntityManagerCreator.getInstanceEM();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
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
    public Breeds findBreed(long id) {
        Breeds temp = entityManager.find(Breeds.class, id);
        return temp;
    }

    public List<Users> searchUsers(String name) {
        List<Users> listUsers = null;
        try {
            listUsers = entityManager.createQuery("SELECT a FROM Users a WHERE LOWER(a.name) LIKE :nameToFind").setParameter("nameToFind", name).getResultList();
        } catch (Exception e) {
        }
        return listUsers;
    }

    public List<Users> searchCustomerByUserName(String userName) {
        List<Users> listCustomers = null;
        try {
            listCustomers = entityManager.createQuery("SELECT a FROM Users a WHERE LOWER(a.username) LIKE :cedulaToFind").setParameter("cedulaToFind", userName).getResultList();
        } catch (Exception e) {
        }
        return listCustomers;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public List<Customers> searchCustomer(String name) {
        List<Customers> listCustomers = null;
        try {
            listCustomers = entityManager.createQuery("SELECT a FROM Customers a WHERE LOWER(a.name) LIKE :nameToFind").setParameter("nameToFind", name).getResultList();
        } catch (Exception e) {
        }
        return listCustomers;
    }

    public List<Customers> searchCustomerByCedula(String cedula) {
        List<Customers> listCustomers = null;
        try {
            listCustomers = entityManager.createQuery("SELECT a FROM Customers a WHERE LOWER(a.cedula) =:cedulaToFind").setParameter("cedulaToFind", cedula).getResultList();
        } catch (Exception e) {
        }
        return listCustomers;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Patients> searchPatient(String patientsId) {
        List<Patients> listPatients = null;
        try {
            listPatients = entityManager.createQuery("SELECT a FROM Patients a WHERE LOWER(a.patientsId) LIKE :nameToFind").setParameter("nameToFind", patientsId).getResultList();
        } catch (Exception e) {
        }
        return listPatients;
    }

    public List<Patients> searchPatientByName(String name) {
        List<Patients> listPatients = null;
        try {
            listPatients = entityManager.createQuery("SELECT a FROM Patients a WHERE LOWER(a.name) LIKE :nameToFind").setParameter("nameToFind", name).getResultList();
        } catch (Exception e) {
        }

        return listPatients;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Species> searchSpecie(String name) {
        List<Species> listSpecieses = null;
        try {
            listSpecieses = entityManager.createQuery("SELECT a FROM Species a WHERE LOWER(a.speciesName) LIKE :nameToFind").setParameter("nameToFind", name).getResultList();
        } catch (Exception e) {
        }
        return listSpecieses;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

    public List<Species> searchSpecie() {
        List<Species> listSpecieses = null;
        try {
            listSpecieses = entityManager.createQuery("SELECT a FROM Species a ").getResultList();
        } catch (Exception e) {
        }
        return listSpecieses;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

    public List<Breeds> searchBreeds(String name) {
        List<Breeds> listBreeds = null;;
        try {
            listBreeds = entityManager.createQuery("SELECT a FROM Breeds a WHERE LOWER(a.breedsName) LIKE :nameToFind").setParameter("nameToFind", name).getResultList();
        } catch (Exception e) {
        }
        return listBreeds;

    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Consultations> searchConsultations() {
        List<Consultations> listConsultations = null;
        try {
            listConsultations = entityManager.createQuery("SELECT a FROM Consultations a ").getResultList();
        } catch (Exception e) {
        }
        return listConsultations;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Consultations> searchConsultations(String name) {
        List<Consultations> listConsultations = null;
        try {
            listConsultations = entityManager.createQuery("SELECT a FROM Consultations a WHERE a.customer = :nameToFind").setParameter("nameToFind", name).getResultList();
        } catch (Exception e) {
        }
        return listConsultations;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
    public List<Consultations> searchConsultations(Date dateBegin, Date dateEnd) {
        List<Consultations> listConsultations = null;
        try {
            listConsultations = entityManager.createQuery("SELECT a FROM Consultations a WHERE a.dateStart BETWEEN :dateBegin AND :dateEnd").setParameter("dateBegin", dateBegin).setParameter("dateEnd", dateEnd).getResultList();
        } catch (Exception e) {
        }
        return listConsultations;

    }

    /*
    -----------------------------
     * OverWitters
    -----------------------------
     */
    public List<Breeds> searchBreeds() {
        List<Breeds> listBreeds = entityManager.createQuery("SELECT a FROM Breeds a").getResultList();
        return listBreeds;

    }

    public Breeds searchBreeds(String name, String height) {
        Breeds listBreeds = (Breeds) entityManager.createQuery("SELECT a FROM Breeds a WHERE a.breedsName = :nameToFind").setParameter("nameToFind", name).getSingleResult();
        return listBreeds;

    }

    @Override
    protected void finalize() {
        entityManager.close();
        EntityManagerCreator.close();
    }
}
