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

    public static boolean validateUser(String name, String password) {
       
        return true;
        // boolean status = false;
        //Busca el usuario por nombre
        //try{
            //Users user = queryManager.searchUser(name);
            //queryManager.searchUser();
        //}catch(Exception exct){
           // exct.printStackTrace();
        //}
        
        //System.out.println(name);
        //Compara el pass dado con el pass del usuario retornado
        /*
        if (user.getPassword().equals(password)) {
            status = true;
        } else {
            status = false;
        }
         *
         */
        //return false;
    }

    //retorna un objeto especifico tipo Users cuando se llame debe cargarse el Id desde generalVariableID del paquete util
    //los datos se le asignan cuando el usuario selecciona un cliente  del table
    public Users searchUser(int id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Users temp = entityManager.find(Users.class, id);
        return temp;
    }

    // retorna lista de patient para autocomplete
    public List<Users> searchAllUserByName(String name) {
        return queryManager.searchUsers(name);
    }
//Metodos comunes a todos los modelos , se llama el correspondiente de  queryManager

    @Override
    public boolean deleteObject(Object object) {
        Users g = (Users) object;
        return queryManager.deleteObject(g);

    }

    @Override
    public boolean updateObject(Object object) {
        Users g = (Users) object;
        return queryManager.updateObject(g);
    }

    @Override
    public boolean insertObject(Object object) {
        return queryManager.saveObject(g);
    }
}
