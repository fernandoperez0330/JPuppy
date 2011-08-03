/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.models;

import itla.jpuppy.datalayer.Users;

/**
 *
 * @author Jordhano
 */
public class SearchingCtrlUsers implements SearchingControl{

    @Override
    public Object getValueAt(Object x, int y) {
        Users temp = (Users) x;
        switch (y) {
            case 0:
                return temp.getPersonId();
            case 1:
                return temp.getName()+ " " + temp.getLastName();
            case 2:
                return temp.getUsername();
            case 3:
                return temp.getTypeUser();
        }

        return null;
    }
}
