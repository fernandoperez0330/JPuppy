package itla.jpuppy.business;

import itla.jpuppy.datalayer.Breeds;
import java.util.List;

//Incompleta
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
        return queryManager.searchBreeds(name);
    }

    @Override
    public boolean insertObject(Object object) {
        Breeds g = (Breeds) object;
        return queryManager.saveObject(g);
    }

    @Override
    public boolean updateObject(Object object) {
        Breeds g = (Breeds) object;
        return queryManager.updateObject(g);
    }

    @Override
    public boolean deleteObject(Object object) {
        Breeds g = (Breeds) object;
        return queryManager.deleteObject(g);
    }
}
