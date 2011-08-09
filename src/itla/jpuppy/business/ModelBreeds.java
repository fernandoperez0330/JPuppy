package itla.jpuppy.business;

import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.datalayer.Species;
import java.util.List;


public class ModelBreeds implements GeneralModel {

    private QueryManager queryManager;

    public ModelBreeds() {
        queryManager = new QueryManager();
    }

    
   public Breeds searchBreeds( String breedsName ) {
        List<Breeds> listBreeds = queryManager.searchBreeds( breedsName );
        Breeds temp=null;
        for( Breeds b : listBreeds ){
            if( b.getBreedsName().equals(breedsName))
                temp =b;
        } 
        return temp;
    }

   // retorna lista de patient para autocomplete
   
    public List<Breeds> searchAllBreedsByName(String name) {
        return queryManager.searchBreeds(name);
    }
    
    public List<Breeds> searchBreedsBySpecie(Species specie) {
        return queryManager.searchBreedsBySpecies(specie);
    }   
    public Breeds searchBreedById( long id ){
        return queryManager.findBreed(id);
    }

    //Metodos comunes a todos los modelos , se llama el correspondiente de  queryManager
    
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
     public void close(){
        queryManager.finalize();
        EntityManagerCreator.close();
    }
}
