package itla.jpuppy.business;

public class ModelAppointments implements GeneralModel {

    private QueryManager queryManager;

    public ModelAppointments() {
        queryManager = new QueryManager();
    }

    @Override
    public boolean insertObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}