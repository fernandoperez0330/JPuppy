package itla.jpuppy.business;

import itla.jpuppy.datalayer.Breeds;
import java.util.List;

public class ModelBreeds implements GeneralModel {

    private QueryManager queryManager;

    public ModelBreeds() {
        queryManager = new QueryManager();
    }

    private Breeds searchBreeds(int id) {
        //EntityManager entityManager=EntityManagerCreator.getInstanceEM();
        //EntityManager temp = entityManager.find( );
        //return temp;
        return null;
    }

    public List<Breeds> searchAllBreedsByName(String name) {
        //return queryManager.searchBreeds(name);
        return null;
    }

    @Override
    public boolean insertObject(Object object) {
        //Breeds g = ( Breeds ) object
        //queryManager.save( g )
        return true;
    }

    @Override
    public boolean updateObject(Object object) {
        //Breeds g = ( Breeds ) object
        //queryManager.update( g )
        return true;
    }

    @Override
    public boolean deleteObject(Object object) {
        //Breeds g = ( Breeds )object
        //Breeds temp
        //temp= this.serachBreeds(g.getId());
        //queryManager.deleteObject( temp )
        return true;
    }
}
