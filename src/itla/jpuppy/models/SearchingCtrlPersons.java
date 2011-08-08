/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.models;

import itla.jpuppy.datalayer.Persons;

/**
 *
 * @author Jordhano
 */
public class SearchingCtrlPersons implements SearchingControl{

    @Override
    public Object getValueAt(Object x, int y) {
        Persons temp = (Persons) x;
        switch (y) {
            case 0:
                return temp.getPersonId();
            case 1:
                return temp.getName();
            case 2:
                return temp.getLastName();
            case 3:
                return temp.getCedula();
        }

        return null;
    }
}
