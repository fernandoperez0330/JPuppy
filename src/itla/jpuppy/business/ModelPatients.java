package itla.jpuppy.business;

import itla.jpuppy.datalayer.Patients;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelPatients implements GeneralModel {

    private QueryManager queryManager;

    public ModelPatients() {
        queryManager = new QueryManager();
    }

    private Patients searchPatient( String id ) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Patients temp = entityManager.find(Patients.class, id);
        return temp;
    }

    public List<Patients> searchAllPatientByName(String name) {
        return queryManager.searchPatient(name);
    }

    @Override
    public boolean insertObject(Object object) {
        Patients g = ( Patients ) object;      
        return queryManager.saveObject( g );
    }

    @Override
    public boolean updateObject(Object object) {
        Patients g = ( Patients ) object;
        return queryManager.updateObject( g );
    }

    @Override
    public boolean deleteObject(Object object) {
        Patients g = ( Patients )object;
        return queryManager.deleteObject( g );
    }
}
