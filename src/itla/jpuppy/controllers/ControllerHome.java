/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.datalayer.Articles;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.datalayer.Users;
import itla.jpuppy.forms.AboutUsFrame;
import itla.jpuppy.forms.HomeFrame;
import itla.jpuppy.forms.InvoiceMenu;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.ManageAppointmentsMenu;
import itla.jpuppy.forms.ManageArticlesMenu;
import itla.jpuppy.forms.ManageBreedMenu;
import itla.jpuppy.forms.ManageConsultations;
import itla.jpuppy.forms.ManageCustomersMenu;
import itla.jpuppy.forms.ManageEmployeesMenu;
import itla.jpuppy.forms.ManagePatients;
import itla.jpuppy.forms.ManageSpecies;
import itla.jpuppy.forms.ManageUsersMenu;
import itla.jpuppy.models.SearchingCtrlCustomers;
import itla.jpuppy.models.SearchingModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

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
            itla.jpuppy.business.EntityManagerCreator.close();
            new ManageCustomersMenu(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiPatients())) {
            itla.jpuppy.business.EntityManagerCreator.close();
            new ManagePatients(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiSpecies())) {
            itla.jpuppy.business.EntityManagerCreator.close();
            new ManageSpecies(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiBreeds())) {
            new ManageBreedMenu(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiEmployees())) {
            itla.jpuppy.business.EntityManagerCreator.close();
            new ManageEmployeesMenu(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiUsers())) {
            itla.jpuppy.business.EntityManagerCreator.close();
            new ManageUsersMenu(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiProductsServices())) {
            itla.jpuppy.business.EntityManagerCreator.close();
            new ManageArticlesMenu(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiAppointments())) {
            itla.jpuppy.business.EntityManagerCreator.close();
            new ManageAppointmentsMenu(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiConsults())) {
            itla.jpuppy.business.EntityManagerCreator.close();
            new ManageConsultations(home, true).showFrame();
            return;
        }

        if (e.getSource().equals(home.getMnuiInvoice())) {
            itla.jpuppy.business.EntityManagerCreator.close();
            new InvoiceMenu().showFrame();
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
