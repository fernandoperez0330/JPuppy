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

    public static boolean validateUser(String name, String password) {
        return true;
        //queryManager.searchUser( name )
        //rrecorer lista comparando el passwd ,con getId()
    }

    private Users searchUser(int id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Users temp = entityManager.find(Users.class, id);
        return temp;
    }

    public List<Users> searchAllUserByName(String name) {
        return queryManager.searchUser(name);
    }

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
