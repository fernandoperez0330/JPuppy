package itla.jpuppy.business;

import itla.jpuppy.datalayer.Consultations;

public class ModelConsultations implements GeneralModel {

    private QueryManager queryManager;
    private Consultations consultations;

    public ModelConsultations() {
        queryManager = new QueryManager();
        consultations = new Consultations();
    }
    
    public Consultations getSpecies() {
        return consultations;
    }  
    
    
    
    @Override
    public boolean insertObject(Object object) {
        Consultations g = (Consultations) object;
        return queryManager.saveObject(g);
    }

    @Override
    public boolean updateObject(Object object) {
        Consultations g = (Consultations) object;
        return queryManager.updateObject(g);
    }

    @Override
    public boolean deleteObject(Object object) {
        Consultations g = (Consultations) object;
        return queryManager.deleteObject(g);
    }
}
