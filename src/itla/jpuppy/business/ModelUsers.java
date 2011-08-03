package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelUsers implements GeneralModel {

    private static QueryManager queryManager;
    private Object g;

    public ModelUsers() {
        queryManager = new QueryManager();
    }

    public boolean validateUser(String name, String password) {
        boolean status = false;
        Users user = null;
        //Busca el usuario por nombre
        try {
            user = queryManager.searchUserValidated(name, password);
        } catch (Exception exct) {
        }

        //System.out.println(name + "  " + password);

        if (user.getPassword().hashCode() == password.hashCode()) {
            status = true;
        }

        return status;
    }

    //retorna un objeto especifico tipo Users cuando se llame debe cargarse el Id desde generalVariableID del paquete util
    //los datos se le asignan cuando el usuario selecciona un cliente  del table
    public Users searchUser(Long id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Users temp = entityManager.find(Users.class, id);
        return temp;
    }

    public boolean checkDuplicateUserName(String userName) {
        if (queryManager.searchCustomerByUserName(userName).size() > 0) {
            return true;
        } else {
            return false;
        }

    }
    // retorna lista de patient para autocomplete

    public List<Users> searchAllUserByName(String name) {
        return queryManager.searchUsers(name);
    }
    
    public List<Users> searchAllUserByUserName(String userName){
         return queryManager.searchCustomerByUserName(userName);
    }
    //Metodos comunes a todos los modelos , se llama el correspondiente de  queryManager

    @Override
    public boolean deleteObject(Object object) {
        return queryManager.deleteObject(object);

    }

    @Override
    public boolean updateObject(Object object) {
        Users g = (Users) object;
        return queryManager.updateObject(g);
    }

    @Override
    public boolean insertObject(Object object) {
        Users g = (Users) object;
        return queryManager.saveObject(g);
    }
}
