/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.models;

import itla.jpuppy.datalayer.Appointments;

/**
 *
 * @author jansel
 */
public class SearchingCrtlAppointments implements SearchingControl{

    @Override
    public Object getValueAt(Object x, int y) {
       
        Appointments ap = ( Appointments )x;
        switch ( y ){
            default:
            case 0:
                return ap.getId();
            case 1:
                return ap.getPatientName();
            case 2:
                return ap.getDateRegistered();
            case 3:
                return ap.getAcordedDate();
            case 4:
                return ap.getDoctorName();
            case 5:
                return ap.getStatus();
        }
    }
    
}
