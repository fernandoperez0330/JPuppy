/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.business;

import itla.jpuppy.datalayer.Appointments;
import java.util.List;
import java.util.ListIterator;

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
    public Appointments getSpecificAppointments( String PatientName ){
        boolean state = false;
        Appointments temp = null;
        List<Appointments>  list = queryManager.searchAllAppointments();
        ListIterator<Appointments> iter =  list.listIterator();
        while( iter.hasNext() && !state ){
            temp = iter.next();
            if( temp.getPatientName().equals(PatientName))
                state = true;
            
        }
        if( state )
        return temp;
        else 
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
