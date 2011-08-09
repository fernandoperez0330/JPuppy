package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.datalayer.Persons;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.ManageCustomersEdit;
import itla.jpuppy.forms.ManageCustomersMenu;
import itla.jpuppy.forms.SearchPersons;
import itla.jpuppy.models.SearchingCtrlCustomers;
import itla.jpuppy.models.SearchingModel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControllerCutomers extends Controller {

    private ManageCustomersMenu customersMenu = null;
    private ManageCustomersEdit customersEdit = null;
    private SearchingModel<Customers> modelSearching;
    private ModelCustomers mdlCustomers;
    private long edicion;
    private Customers tempCustomer;

    public ControllerCutomers(ManageCustomersMenu customersMenu) {
        this.customersMenu = customersMenu;
        modelSearching = new SearchingModel<Customers>(new String[]{"ID", "NOMBRE", "APELLIDOS", "CIUDAD"}, new SearchingCtrlCustomers());
        customersMenu.setSearching(new JSearching(modelSearching));
        mdlCustomers = new ModelCustomers();
        searchByField("");
        edicion = 0;
    }

    public void searchByField(String string) {
        modelSearching.setElements(mdlCustomers.searchAllCustomerByName("%" + string + "%"));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(customersMenu.getSearching().getTxtSearch())) {
            searchByField(customersMenu.getSearching().getTxtSearch().getText().toLowerCase());
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
            btnAdd();
            return;
        }

        if (e.getSource().equals(customersMenu.getBtnUpdate())) {
            btnUpdate();
            return;
        }

        if (e.getSource().equals(customersMenu.getBtnRemove())) {
            btnRemove();
            return;
        }
        if (e.getSource().equals(customersMenu.getBtnExit())) {
            customersMenu.closeFrame();
            return;
        }
        try {
            if (e.getSource().equals(customersEdit.getBtnSave())) {
                btnSave();
                return;
            }

            if (e.getSource().equals(customersEdit.getBtnCancel())) {
                btncancelar();
                return;
            }

            if (e.getSource().equals(customersEdit.getBtnPerson())) {
                btnPersonData();
                return;
            }
        } catch (java.lang.NullPointerException err) {
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

    @Override
    public void insert() {
        Calendar c1 = Calendar.getInstance();
        Customers temp = new Customers(customersEdit.getTxtFieldName().getText(), customersEdit.getTxtFieldLastName().getText(), customersEdit.getTxtFieldCedula().getText(), new Date(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DATE)), customersEdit.getTxtFieldPhone().getText(), customersEdit.getTxtFieldCellphone().getText(), customersEdit.getjTextAreaNote().getText(), customersEdit.getTxtFieldCity().getText(), customersEdit.getTxtFieldMail().getText(), customersEdit.getTxtFieldAdress().getText(), true);
        mdlCustomers.insertObject(temp);
        JOptionPane.showMessageDialog(customersEdit, "Registro Insertado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        customersEdit.dispose();
    }

    @Override
    public void update() {
        int i = JOptionPane.showConfirmDialog(customersEdit, "Realmente desea Sobreescribir Los Datos de Este Cliente?", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i == 0) {
            mdlCustomers.updateObject(tempCustomer);
            JOptionPane.showMessageDialog(customersEdit, "Registro Actualizado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            customersEdit.dispose();
        }
    }

    @Override
    public void btnAdd() {
        edicion = 0;
        customersEdit = new ManageCustomersEdit(null, true, this);
        customersEdit.showFrame();
    }

    @Override
    public void btnUpdate() {
        if (edicion != 0) {
            customersEdit = new ManageCustomersEdit(null, true, this);
            tempCustomer = mdlCustomers.searchCustomer(edicion);
            customersEdit.setFieldsValue(tempCustomer.getLastName(), tempCustomer.getCellphone(), tempCustomer.getCity(), tempCustomer.getAddress(), tempCustomer.getEmail(), tempCustomer.getName(), tempCustomer.getTelephone(), tempCustomer.getNote(), tempCustomer.getCedula());
            customersEdit.showFrame();
            edicion = 0;
            return;
        } else {
            javax.swing.JOptionPane.showMessageDialog(customersMenu, "No Ha Sido Seleccionado Un Registro");
        }
    }

    @Override
    public void btnSave() {
        if (isEmptyFields()) {
            JOptionPane.showMessageDialog(customersEdit, "Existen Campos En Blancos Por Favor Completar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (edicion != 0) {
            tempCustomer.setName(customersEdit.getTxtFieldName().getText());
            tempCustomer.setLastName(customersEdit.getTxtFieldLastName().getText());
            tempCustomer.setAddress(customersEdit.getTxtFieldAdress().getText());
            tempCustomer.setCellphone(customersEdit.getTxtFieldCellphone().getText());
            tempCustomer.setTelephone(customersEdit.getTxtFieldPhone().getText());
            tempCustomer.setEmail(customersEdit.getTxtFieldMail().getText());
            tempCustomer.setCity(customersEdit.getTxtFieldCity().getText());
            tempCustomer.setNote(customersEdit.getjTextAreaNote().getText());

            if (mdlCustomers.checkDuplicateCedula(customersEdit.getTxtFieldCedula().getText())) {
                if (tempCustomer.getCedula().equalsIgnoreCase(customersEdit.getTxtFieldCedula().getText())) {
                    update();
                } else {
                    JOptionPane.showMessageDialog(customersEdit, "Existe Otro Usuario Con El Mismo Numero de Cedula", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                tempCustomer.setCedula(customersEdit.getTxtFieldCedula().getText());
                update();
            }
        } else {
            if (mdlCustomers.checkDuplicateCedula(customersEdit.getTxtFieldCedula().getText())) {
                JOptionPane.showMessageDialog(customersEdit, "Existe Otro Cliente Con El Mismo Numero de Cedula", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                return;
            }
            insert();
        }
    }

    @Override
    public void btnRemove() {
        if (edicion != 0) {
            int i = JOptionPane.showConfirmDialog(customersEdit, "Realmente desea Eliminar Este Cliente?", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (i == 0) {
                mdlCustomers.deleteObject(mdlCustomers.searchCustomer(edicion));
                javax.swing.JOptionPane.showMessageDialog(customersMenu, "Registro Eliminado");
            }
            searchByField(customersMenu.getSearching().getTxtSearch().getText().toLowerCase());
            edicion = 0;
        } else {
            javax.swing.JOptionPane.showMessageDialog(customersMenu, "No Ha Sido Seleccionado Un Registro");
        }
    }

    @Override
    public void btncancelar() {
        int i = JOptionPane.showConfirmDialog(customersEdit, "Realmente desea Cancelar la Insercion de Datos", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i == 0) {
            customersEdit.dispose();
        }
    }

    private void btnPersonData() {
        Persons temp = new SearchPersons(customersEdit, true, mdlCustomers.getQueryManager(), 3).personShowSearch();
        edicion = temp.getPersonId();
        tempCustomer = mdlCustomers.searchCustomer(edicion);
        customersEdit.setFieldsValue(temp.getLastName(), temp.getCellphone(), temp.getEmail(), temp.getName(), temp.getTelephone(),temp.getCedula());
        return;
    }
}
