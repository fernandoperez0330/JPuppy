/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.utils;

import itla.jpuppy.controllers.ControllerArticles;
import itla.jpuppy.controllers.ControllerUser;
import itla.jpuppy.forms.ManageMenu;

/**
 *
 * @author jansel
 */
public class GeneralVaribleID {
    
    private static ControllerUser ctrlUser;
    private static ControllerArticles ctrlArticles;

    public static ControllerArticles getCtrlArticles(ManageMenu manageMenu) {
        if (ctrlArticles != null){
            //ctrlArticles = new ControllerUser(manageMenu);
        }
        return ctrlArticles;
    }

    public static ControllerUser getCtrlUser() {
        return ctrlUser;
    }
    
    
}
