/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.models;

import itla.jpuppy.datalayer.Patients;

/**
 *
 * @author Jordhano
 */
public class SearchingCrtlPatients implements SearchingControl {

    @Override
    public Object getValueAt(Object x, int y) {
        Patients temp = (Patients) x;
        switch (y) {
            case 0:
                return temp.getPatientsId();
            case 1:
                return temp.getName();
            case 2:
                return (temp.getOwner().getName()+ " "+ temp.getOwner().getLastName());
            case 3:
                return temp.getBirthDate();
        }
        return null;
    }
}
