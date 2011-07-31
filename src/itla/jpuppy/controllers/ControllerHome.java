/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.forms.HomeFrame;
import itla.jpuppy.forms.ManageCustomers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Jordhano
 */
public class ControllerHome implements ActionListener, KeyListener {

    private HomeFrame home = null;
    

    public ControllerHome(HomeFrame home) {
        this.home = home;
        home.getModelSearching().setElements(home.getMdlCustomers().searchAllCustomerByName("%%"));
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        javax.swing.JTextField txtSearch =home.getSearching().getTxtSearch();
        if (e.getSource().equals(txtSearch)) {
                home.getModelSearching().setElements(home.getMdlCustomers().searchAllCustomerByName("%" + txtSearch.getText().toLowerCase() + "%"));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Menu Administrador
        if (e.getSource().equals(home.getMnuiCustomers())){
            new ManageCustomers(home, true).showFrame();
        }
    }
    
}
