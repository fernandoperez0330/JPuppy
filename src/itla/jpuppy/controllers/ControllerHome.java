/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.forms.HomeFrame;
import itla.jpuppy.forms.ManageBreeds;
import itla.jpuppy.forms.ManageCustomersEdit;
import itla.jpuppy.forms.ManageCustomersMenu;
import itla.jpuppy.forms.ManagePatients;
import itla.jpuppy.forms.ManageSpecies;
import itla.jpuppy.forms.ManageUsers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

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
        //Menu administrator
        if (e.getSource().equals(home.getMnuiCustomers())){
            //new ManageCustomersEdit(home, true).showFrame();
            new ManageCustomersMenu(home, true).showFrame();
        }
        
        if (e.getSource().equals(home.getMnuiPatients())){
            new ManagePatients(home, true).showFrame();
        }
        
        if (e.getSource().equals(home.getMnuiSpecies())){
            new ManageSpecies(home,true).showFrame();
        }
        
        if (e.getSource().equals(home.getMnuiBreeds())){
            new ManageBreeds(home, true).showFrame();
        }
        
        if (e.getSource().equals(home.getMnuiEmployees())){
            JOptionPane.showMessageDialog(home, "Nuestros amigos de Vista Trabajaran En Esto");
        }
        
        if (e.getSource().equals(home.getMnuiUsers())){
            new ManageUsers(home, true).showFrame();
        }
        
        //Menu User
        
        if (e.getSource().equals(home.getMnuiExit())){
            home.dispose();
        }
        //e.getSource().equals()
        
    }
    
}
