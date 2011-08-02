package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.business.ModelPatients;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.datalayer.Patients;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.ManageCustomersEdit;
import itla.jpuppy.forms.ManageCustomersMenu;
import itla.jpuppy.forms.SearchPatients;
import itla.jpuppy.models.SearchingCrtlPatients;
import itla.jpuppy.models.SearchingCtrlCustomers;
import itla.jpuppy.models.SearchingModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerCutomers implements MouseListener, KeyListener, ActionListener, WindowFocusListener {

    private ManageCustomersMenu customersMenu = null;
    private ManageCustomersEdit customersEdit = null;
    private SearchPatients patientsSearching = null;
    private SearchingModel<Customers> modelSearching;
    private SearchingModel<Patients> modelSearchingPatients;
    private SearchingModel<Patients> myTablePatients;
    private ModelPatients mdlPatients;
    private ModelCustomers mdlCustomers;
    private long edicion;
    private int myTableEdicion;

    public ControllerCutomers(ManageCustomersMenu customersMenu) {
        this.customersMenu = customersMenu;
        modelSearching = new SearchingModel<Customers>(new String[]{"Id", "Name", "Lastname", "City"}, new SearchingCtrlCustomers());
        modelSearchingPatients = new SearchingModel<Patients>(new String[]{"Id", "Name", "Owner", "BirthDate"}, new SearchingCrtlPatients());
        myTablePatients = new SearchingModel<Patients>(new String[]{"Id", "Name", "Owner", "BirthDate"}, new SearchingCrtlPatients());
        customersMenu.setSearching(new JSearching(modelSearching));
        patientsSearching = new SearchPatients(null, true, new JSearching(modelSearchingPatients), this);
        mdlCustomers = new ModelCustomers();
        mdlPatients = new ModelPatients();
        mdlPatients.getQueryManager().setEntityManager(mdlCustomers.getQueryManager().getEntityManager());
        cleanSearch();
        cleanSearchPatients();
    }

    public void cleanSearch() {
        modelSearching.setElements(mdlCustomers.searchAllCustomerByName("%%"));
    }

    public void searchByField(String string) {
        modelSearching.setElements(mdlCustomers.searchAllCustomerByName("%" + string + "%"));
    }

    public void searchByFieldPatients(String string) {
        List<Patients> temp = mdlPatients.searchAllPatientByNameExplicit("%" + string + "%");
        for (int i = 0; i < myTablePatients.getElements().size(); i++) {
            if (temp.get(i).equals(myTablePatients.getElements().get(i))) {
                temp.remove(i);
            }
        }
        modelSearchingPatients.setElements(temp);
    }

    public void cleanSearchPatients() {
        modelSearchingPatients.setElements(mdlPatients.searchAllPatientByNameExplicit("%%"));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(customersMenu.getSearching().getTxtSearch())) {
            searchByField(customersMenu.getSearching().getTxtSearch().getText().toLowerCase());
        }

        if (e.getSource().equals(patientsSearching.getSearching().getTxtSearch())) {
            searchByFieldPatients(patientsSearching.getSearching().getTxtSearch().getText().toLowerCase());
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
            customersEdit = new ManageCustomersEdit(null, true, this);
            customersEdit.getTblMyPatients().setModel(myTablePatients);
            customersEdit.showFrame();
            return;
        }

        if (e.getSource().equals(customersMenu.getBtnUpdate())) {
            if (edicion != 0) {
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, edicion);
            }
            return;
        }

        if (e.getSource().equals(customersMenu.getBtnRemove())) {
            if (edicion != 0) {
                int i = JOptionPane.showConfirmDialog(customersEdit, "Realmente desea Cancelar la Insercion de Datos", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == 0) {
                    mdlCustomers.deleteObject(mdlCustomers.searchCustomer(edicion));
                    javax.swing.JOptionPane.showMessageDialog(customersMenu, "Registro Eliminado");
                }
                searchByField(customersMenu.getSearching().getTxtSearch().getText().toLowerCase());
                edicion = 0;
            } else {
                javax.swing.JOptionPane.showMessageDialog(customersMenu, "No Ha Sido Seleccionado Un Registro");
            }
            return;
        }

        if (e.getSource().equals(customersEdit.getBtnSave())) {

            if (isEmptyFields()) {
                JOptionPane.showMessageDialog(customersEdit, "Existen Campos En Blancos Por Favor Completar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (mdlCustomers.checkDuplicateCedula(customersEdit.getTxtFieldCedula().getText())) {
                JOptionPane.showMessageDialog(customersEdit, "Existe Otro Cliente Con El Mismo Numero de Cedula", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Calendar c1 = Calendar.getInstance();
            Customers temp = new Customers(customersEdit.getTxtFieldName().getText(), customersEdit.getTxtFieldLastName().getText(), customersEdit.getTxtFieldCedula().getText(), new Date(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DATE)), customersEdit.getTxtFieldPhone().getText(), customersEdit.getTxtFieldCellphone().getText(), customersEdit.getjTextAreaNote().getText(), customersEdit.getTxtFieldCity().getText(), customersEdit.getTxtFieldMail().getText(), customersEdit.getTxtFieldAdress().getText(), true);
            if (myTablePatients.getElements().size() < 0) {
                mdlCustomers.insertObject(temp);
            }

            if (myTablePatients.getElements().size() > 0) {
                int i = JOptionPane.showConfirmDialog(customersEdit, "Realmente desea Sobreescribir Los Dueños de Sus Mascotas?", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == 0) {
                    temp.setPatients(myTablePatients.getElements());
                    mdlCustomers.insertObject(temp);
                    for (Patients patients : myTablePatients.getElements()) {
                        patients.setOwner(temp);
                        mdlPatients.updateObject(patients);
                    }
                }



            }
            JOptionPane.showMessageDialog(customersEdit, "Registro Insertado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            customersEdit.dispose();

        }

        if (e.getSource().equals(customersEdit.getBtnCancel())) {
             int i = JOptionPane.showConfirmDialog(customersEdit, "Realmente desea Cancelar la Insercion de Datos", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (i == 0) {
             customersEdit.dispose();
            }
            return;
        }

        if (e.getSource().equals(customersEdit.getBtnAdd())) {
            patientsSearching.showFrame();
            return;
        }

        if (e.getSource().equals(customersEdit.getBtnRemove())) {
            if (myTableEdicion > -1) {
                modelSearchingPatients.getElements().add(myTablePatients.getElements().get(myTableEdicion));
                myTablePatients.getElements().remove(myTableEdicion);
                myTablePatients.fireTableDataChanged();
                myTableEdicion = 0;
            } else {
                JOptionPane.showMessageDialog(patientsSearching, "Debe Tener Seleccionado un Registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(customersMenu.getSearching().getTblResult())) {
            int fila = customersMenu.getSearching().getTblResult().rowAtPoint(e.getPoint());
            if (fila > -1) {
                edicion = (Long) customersMenu.getSearching().getTblResult().getValueAt(fila, 0);
                return;
            }
        }

        if (e.getSource().equals(patientsSearching.getSearching().getTblResult())) {
            int fila = patientsSearching.getSearching().getTblResult().rowAtPoint(e.getPoint());
            if (fila > -1) {
                myTablePatients.getElements().add(modelSearchingPatients.getElements().get(fila));
                modelSearchingPatients.getElements().remove(fila);
                myTablePatients.fireTableDataChanged();
                patientsSearching.closeFrame();

                return;
            }
        }

        if (e.getSource().equals(customersEdit.getTblMyPatients())) {
            int fila = customersEdit.getTblMyPatients().rowAtPoint(e.getPoint());
            if (fila > -1) {
                myTableEdicion = fila;
                return;
            }
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

    private boolean isEmptyFields() {
        boolean state = false;
        javax.swing.text.JTextComponent textField;
        String date;


        for (int i = 0; i <= customersEdit.getPnFields().getComponentCount(); i++) {
            try {
                textField = (javax.swing.text.JTextComponent) customersEdit.getPnFields().getComponent(i);
                if (textField.getText().equals("")) {
                    state = true;
                    textField.requestFocus();
                } else if (textField.getText().indexOf("-") != -1) {
                    String special = textField.getText().trim();
                    if ((special.length() < 12) && (special.length() != 10)) {
                        state = true;
                        textField.requestFocus();
                    }
                }
            } catch (Exception e) {
            }
        }
        return state;
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        searchByField(customersMenu.getSearching().getTxtSearch().getText().toLowerCase());
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
    }
}
