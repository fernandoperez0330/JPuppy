package itla.jpuppy.controllers;

import itla.jpuppy.forms.ManageCustomersMenu;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControllerCutomers  implements KeyListener {

    private ManageCustomersMenu customersMenu = null;

    public ControllerCutomers(ManageCustomersMenu customersMenu) {
        this.customersMenu = customersMenu;
        this.customersMenu.getModelSearching().setElements(customersMenu.getMdlCustomers().searchAllCustomerByName("%%"));
    }


    @Override
    public void keyReleased(KeyEvent e) {
        javax.swing.JTextField txtSearch =customersMenu.getSearching().getTxtSearch();
        if (e.getSource().equals(txtSearch)) {
                customersMenu.getModelSearching().setElements(customersMenu.getMdlCustomers().searchAllCustomerByName("%" + txtSearch.getText().toLowerCase() + "%"));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }
}
