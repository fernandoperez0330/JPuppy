package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;
import java.util.List;


public class ModelUsers implements GeneralModel {

    private QueryManager queryManager;

    public ModelUsers() {

        queryManager = new QueryManager();

    }

    public static boolean validateUser(String name, String password) {
        return true;
        //queryManager.searchUser( name )
        //rrecorer lista comparando el passwd ,con getId()
    }

    private Users searchUser(int id) {
        //EntityManager entityManager=EntityManagerCreator.getInstanceEM();
        //EntityManager temp = entityManager.find( );
         //return temp;
        return null;
    }
    public List<Users> searchAllUser( String name ){
        //return queryManager.searchUser(name);
        return null;
    }

    @Override
    public boolean deleteObject(Object object) {
        return true;
        //User g = ( Users ) object
        //Users temp;
        //temp= this.serachUser(g.getId);
        //queryManager.deleteObject( temp )

    }

    @Override
    public boolean updateObject(Object object) {
        //User g = ( Users ) object
        //queryManager.update( user )
        return true;
    }

    @Override
    public boolean insertObject(Object object) {
        //User g = ( Users ) object
        //queryManager.save( g )
        return true;
    }
}
