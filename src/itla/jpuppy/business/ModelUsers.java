package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelUsers implements GeneralModel {

    private QueryManager queryManager;
    private Object g;

    public ModelUsers() {

        queryManager = new QueryManager();

    }

    
    //Metodo incompleto por falta de el atributo password de la entidad User
    
    public static boolean validateUser(String name, String password) {
        return true;
        //queryManager.searchUser( name )
        //rrecorer lista comparando el passwd ,con getId()
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
        return queryManager.searchUser(name);
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
