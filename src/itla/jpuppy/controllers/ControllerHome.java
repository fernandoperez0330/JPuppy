/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.forms.AboutUsFrame;
import itla.jpuppy.forms.HomeFrame;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.ManageBreeds;
import itla.jpuppy.forms.ManageCustomersMenu;
import itla.jpuppy.forms.ManagePatients;
import itla.jpuppy.forms.ManageSpecies;
import itla.jpuppy.forms.ManageUsersEdit;
import itla.jpuppy.models.SearchingCtrlCustomers;
import itla.jpuppy.models.SearchingModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jordhano
 */
public class ControllerHome implements ActionListener, KeyListener, WindowFocusListener {

    private HomeFrame home = null;
    private SearchingModel<Customers> modelSearching;
    private ModelCustomers mdlCustomers;

    public ControllerHome(HomeFrame home) {
        this.home = home;
        modelSearching = new SearchingModel<Customers>(new String[]{"Id", "Name", "Lastname", "City"}, new SearchingCtrlCustomers());
        mdlCustomers = new ModelCustomers();
        modelSearching.setElements(mdlCustomers.searchAllCustomerByName("%%"));
        home.setSearching(new JSearching(modelSearching));
        
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        javax.swing.JTextField txtSearch = home.getSearching().getTxtSearch();
        if (e.getSource().equals(txtSearch)) {
            modelSearching.setElements(mdlCustomers.searchAllCustomerByName("%" + txtSearch.getText().toLowerCase() + "%"));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Menu administrator
        if (e.getSource().equals(home.getMnuiCustomers())) {
            //new ManageCustomersEdit(home, true).showFrame();
            itla.jpuppy.business.EntityManagerCreator.close();
            new ManageCustomersMenu(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiPatients())) {
            new ManagePatients(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiSpecies())) {
            new ManageSpecies(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiBreeds())) {
            new ManageBreeds(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiEmployees())) {
            JOptionPane.showMessageDialog(home, "Nuestros amigos de Vista Trabajaran En Esto");
            return;
        }

        if (e.getSource().equals(home.getMnuiUsers())) {
            new ManageUsersEdit(home, true).showFrame();
            return;
        }

        //Menu User

        if (e.getSource().equals(home.getMnuiExit())) {
            home.dispose();
            return;
        }

        // Menu about Us
        if (e.getSource().equals(home.getMnuiAcerca())) {
            new AboutUsFrame(home, true).showFrame();
            return;
        }

        //e.getSource().equals()


    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        modelSearching.setElements(mdlCustomers.searchAllCustomerByName("%" + home.getSearching().getTxtSearch().getText().toLowerCase() + "%"));
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        ;
    }
}
