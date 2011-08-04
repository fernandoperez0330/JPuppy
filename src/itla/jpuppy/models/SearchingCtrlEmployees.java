/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.models;

import itla.jpuppy.datalayer.Employees;
import itla.jpuppy.datalayer.Users;

/**
 *
 * @author Jordhano
 */
public class SearchingCtrlEmployees implements SearchingControl{

    @Override
    public Object getValueAt(Object x, int y) {
        Employees temp = (Employees) x;
        switch (y) {
            case 0:
                return temp.getPersonId();
            case 1:
                return temp.getName()+ " " + temp.getLastName();
            case 2:
                return temp.getCedula();
            case 3:
                return temp.getPosition();
        }

        return null;
    }
}
