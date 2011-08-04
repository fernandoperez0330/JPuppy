/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.business;

import itla.jpuppy.datalayer.Appointments;
import java.util.List;

/**
 *
 * @author jansel
 */
public class ModelAppointments implements GeneralModel{

    private QueryManager queryManager=null;
    
    
    public ModelAppointments() {
        queryManager = new QueryManager();
    }
    
    
    public List<Appointments> serachAllAppointmentsByPattients(){
        return null;
    }
    
    @Override
    public boolean insertObject(Object object) {
        
        Appointments appointments = ( Appointments )object;
        return queryManager.saveObject( appointments  );
    }

    @Override
    public boolean updateObject(Object object) {
     
         Appointments appointments = ( Appointments )object;
        return queryManager.updateObject( appointments );
    }

    @Override
    public boolean deleteObject(Object object) {
        Appointments appointments = ( Appointments )object;
        return queryManager.deleteObject( appointments );
    }
    
}
