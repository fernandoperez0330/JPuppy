package itla.jpuppy.business;

import itla.jpuppy.datalayer.Species;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelSpecies implements GeneralModel {

    private QueryManager queryManager;

    public ModelSpecies() {
        queryManager = new QueryManager();
    }

    private Species searchSpecies(int id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Species temp = entityManager.find( Species.class, id );
        return temp;
    }

    public List<Species> searchAllSpeciesByName(String name) { 
        return queryManager.searchSpecie(name);
    }

    @Override
    public boolean insertObject(Object object) {
        Species g = ( Species ) object;
        return queryManager.saveObject( g );
    }

    @Override
    public boolean updateObject(Object object) {
        Species g = ( Species ) object;
        return queryManager.updateObject( g );
    }

    @Override
    public boolean deleteObject(Object object) {
        Species g = ( Species )object;      
        return queryManager.deleteObject( g );
    }
}
