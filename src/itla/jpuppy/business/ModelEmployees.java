package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelEmployees implements GeneralModel {

    private static QueryManager queryManager;
    private Object g;

    public ModelEmployees() {
        queryManager = new QueryManager();
    }

    public QueryManager getQueryManager() {
        return queryManager;
    }

    //retorna un objeto especifico tipo Users cuando se llame debe cargarse el Id desde generalVariableID del paquete util
    //los datos se le asignan cuando el usuario selecciona un cliente  del table
    public Employees searchEmployee(Long id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Employees temp = entityManager.find(Employees.class, id);
        return temp;
    }

    public Doctor searchDoctorEmployee(Long id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Doctor temp = entityManager.find(Doctor.class, id);
        return temp;
    }

    private Employees searchDoctor(Long id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Employees temp = entityManager.find(Doctor.class, id);
        return temp;
    }

    // retorna lista de patient para autocomplete
    public List<Employees> searchAllEmployeeByName(String name) {
        return queryManager.searchEmployees(name);
    }

    public boolean checkDuplicateCedula(String cedula) {
        if (queryManager.searchPersonByCedula(cedula).size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkIsDoctor(Long id) {
        if (searchDoctor(id) != null) {
            return true;
        } else {
            return false;
        }

    }
    //Metodos comunes a todos los modelos , se llama el correspondiente de  queryManager

    @Override
    public boolean deleteObject(Object object) {
        return queryManager.deleteObject(object);

    }

    @Override
    public boolean updateObject(Object object) {
        //Users g = (Users) object;
        
        return queryManager.updateObject(object);
    }

    @Override
    public boolean insertObject(Object object) {
        //Users g = (Users) object;
        if (object instanceof itla.jpuppy.datalayer.Doctor){
            System.out.println("Anja");
        }
        return queryManager.saveObject(object);
    }
}
