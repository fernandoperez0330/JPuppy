package itla.jpuppy.business;

import itla.jpuppy.datalayer.Species;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelSpecies implements GeneralModel {

    private QueryManager queryManager;
    private Species species;

    public ModelSpecies() {
        queryManager = new QueryManager();
        species = new Species();
    }
    
    public Species getSpecies() {
        return species;
    }     

    //retorna un objeto especifico tipo Species cuando se llame debe cargarse el Id desde generalVariableID del paquete util
    //los datos se le asignan cuando el usuario selecciona un cliente  del table
    public Species searchSpecies(int id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Species temp = entityManager.find(Species.class, id);
        return temp;
    }

    // retorna lista de patient para autocomplete
    public List<Species> searchAllSpeciesByName(String name) {
        return queryManager.searchSpecie(name);
    }

    //Metodos comunes a todos los modelos , se llama el correspondiente de  queryManager
    @Override
    public boolean insertObject(Object object) {
        Species g = (Species) object;
        return queryManager.saveObject(g);
    }

    @Override
    public boolean updateObject(Object object) {
        Species g = (Species) object;
        return queryManager.updateObject(g);
    }

    @Override
    public boolean deleteObject(Object object) {
        Species g = (Species) object;
        return queryManager.deleteObject(g);
    }
}
