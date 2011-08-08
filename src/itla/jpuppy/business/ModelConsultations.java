package itla.jpuppy.business;

import itla.jpuppy.datalayer.Consultations;
import java.util.List;

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
    
    public Consultations getConsultationsByID(long id) {
        return queryManager.searchConsultationsByID(id);
    }
    
    public List<Consultations> getConsultations() {
        return queryManager.searchConsultations();
    }
    
    public List<Consultations> getConsultationsByName(String name){
        return queryManager.searchConsultations(name);
    }
    
    //METODO EN PRUEBA
    public long getConsultationID() {
        //System.out.println(queryManager.searchConsultations().size());
        return queryManager.searchConsultations().get(queryManager.searchConsultations().size() - 1).getId();
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
