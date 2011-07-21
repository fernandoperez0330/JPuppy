package itla.jpuppy.business;

import itla.jpuppy.datalayer.Species;
import java.util.List;

public class ModelSpecies implements GeneralModel {

    private QueryManager queryManager;

    public ModelSpecies() {
        queryManager = new QueryManager();
    }

    private Species searchSpecies(int id) {
        //EntityManager entityManager=EntityManagerCreator.getInstanceEM();
        //EntityManager temp = entityManager.find( );
        //return temp;
        return null;
    }

    public List<Species> searchAllSpecies(String name) {
        //return queryManager.searchSpecies(name);
        return null;
    }

    @Override
    public boolean insertObject(Object object) {
        //Species g = ( Species ) object
        //queryManager.save( g )
        return true;
    }

    @Override
    public boolean updateObject(Object object) {
        //Species g = ( Species ) object
        //queryManager.update( g )
        return true;
    }

    @Override
    public boolean deleteObject(Object object) {
        //Species g = ( Species )object
        //Species temp
        //temp= this.serachSpecies(g.getId());
        //queryManager.deleteObject( temp )
        return true;
    }
}
