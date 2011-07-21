package itla.jpuppy.business;

import itla.jpuppy.datalayer.Patients;
import java.util.List;

public class ModelPatients implements GeneralModel {

    private QueryManager queryManager;

    public ModelPatients() {
        queryManager = new QueryManager();
    }

    private Patients searchPatient( String id ) {
        //EntityManager entityManager=EntityManagerCreator.getInstanceEM();
        //EntityManager temp = entityManager.find( );
        //return temp;
        return null;
    }

    public List<Patients> searchAllPatientByName(String name) {
        //return queryManager.searchPatients(name);
        return null;
    }

    @Override
    public boolean insertObject(Object object) {
        //Patients g = ( Patients ) object
        //queryManager.save( g )
        return true;
    }

    @Override
    public boolean updateObject(Object object) {
        //Patients g = ( Patients ) object
        //queryManager.update( g )
        return true;
    }

    @Override
    public boolean deleteObject(Object object) {
        //Patients g = ( Patients )object
        //Patients temp
        //temp= this.serachPatients(g.getId());
        //queryManager.deleteObject( temp )
        return true;
    }
}
