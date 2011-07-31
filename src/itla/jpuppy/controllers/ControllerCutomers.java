package itla.jpuppy.controllers;

import itla.jpuppy.forms.ManageCustomersEdit;
import itla.jpuppy.forms.ManageCustomersMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerCutomers implements MouseListener, KeyListener, ActionListener {

    private ManageCustomersMenu customersMenu = null;
    private long edicion;

    public ControllerCutomers(ManageCustomersMenu customersMenu) {
        this.customersMenu = customersMenu;
        cleanSearch();
    }
    
    public void cleanSearch(){
     this.customersMenu.getModelSearching().setElements(customersMenu.getMdlCustomers().searchAllCustomerByName("%%"));   
    }
    
    public void searchByField(){
        customersMenu.getModelSearching().setElements(customersMenu.getMdlCustomers().searchAllCustomerByName("%" + customersMenu.getSearching().getTxtSearch().getText().toLowerCase() + "%"));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(customersMenu.getSearching().getTxtSearch())) {
            searchByField();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(customersMenu.getBtnAdd())) {
            new ManageCustomersEdit(null, true).showFrame();
        }

        if (e.getSource().equals(customersMenu.getBtnUpdate())) {
            if (edicion != 0) {
                
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, edicion);
            }
        }

        if (e.getSource().equals(customersMenu.getBtnRemove())) {
            if (edicion != 0) {
                javax.swing.JOptionPane.showMessageDialog(null,customersMenu.getMdlCustomers().deleteObject(customersMenu.getMdlCustomers().searchCustomer(edicion)));
                searchByField();
                edicion = 0;
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, edicion);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = customersMenu.getSearching().getTblResult().rowAtPoint(e.getPoint());
        if (fila > -1) {
            edicion = (Long) customersMenu.getSearching().getTblResult().getValueAt(fila, 0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
