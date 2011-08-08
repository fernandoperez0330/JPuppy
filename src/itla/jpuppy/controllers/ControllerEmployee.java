package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelEmployees;
import itla.jpuppy.datalayer.Doctor;
import itla.jpuppy.datalayer.Employees;
import itla.jpuppy.datalayer.Persons;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.ManageEmployeesEdit;
import itla.jpuppy.forms.ManageEmployeesMenu;
import itla.jpuppy.forms.SearchPersons;
import itla.jpuppy.models.SearchingCtrlEmployees;
import itla.jpuppy.models.SearchingModel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerEmployee extends Controller {

    private ManageEmployeesMenu manageMenu;
    private ManageEmployeesEdit manageEdit;
    private SearchingModel<Employees> modelSearching;
    private ModelEmployees mdlEmployees;
    private long edicion;
    private Employees tempEmployee;
    private Doctor tempDoctor;
    private boolean isDoctor;

    public ControllerEmployee(ManageEmployeesMenu manageMenu) {
        this.manageMenu = manageMenu;
        modelSearching = new SearchingModel<Employees>(new String[]{"Id", "Name", "Cedula", "Cargo"}, new SearchingCtrlEmployees());
        this.manageMenu.setSearching(new JSearching(modelSearching));
        mdlEmployees = new ModelEmployees();
        searchByField("");
        edicion = 0;
        isDoctor = false;
    }

    public void searchByField(String string) {
        modelSearching.setElements(mdlEmployees.searchAllEmployeeByName("%" + string + "%"));
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        searchByField(manageMenu.getSearching().getTxtSearch().getText().toLowerCase());
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(manageMenu.getSearching().getTblResult())) {
            int fila = manageMenu.getSearching().getTblResult().rowAtPoint(e.getPoint());
            if (fila > -1) {
                edicion = (Long) manageMenu.getSearching().getTblResult().getValueAt(fila, 0);
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(manageMenu.getSearching().getTxtSearch())) {
            searchByField(manageMenu.getSearching().getTxtSearch().getText().toLowerCase());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(manageMenu.getBtnAdd())) {
            btnAdd();
            return;
        }

        if (e.getSource().equals(manageMenu.getBtnUpdate())) {
            btnUpdate();
            return;
        }

        if (e.getSource().equals(manageMenu.getBtnRemove())) {
            btnRemove();
            return;
        }

        if (e.getSource().equals(manageMenu.getBtnExit())) {
            manageMenu.closeFrame();
            return;
        }

        try {
            if (e.getSource().equals(manageEdit.getBtnSave())) {
                btnSave();
                return;
            }

            if (e.getSource().equals(manageEdit.getBtnCancel())) {
                btncancelar();
                return;
            }

            if (e.getSource().equals(manageEdit.getjRadioButtonDoctor())) {
                manageEdit.getLblSpeciality().setVisible(true);
                manageEdit.getTxtFieldSpeciality().setVisible(true);
                return;
            }

            if (e.getSource().equals(manageEdit.getjRadioButtonNormal())) {
                manageEdit.getLblSpeciality().setVisible(false);
                manageEdit.getTxtFieldSpeciality().setVisible(false);
                return;
            }
            
            if (e.getSource().equals(manageEdit.getBtnPerson())){
                btnPersonData();
                return;
            }
        } catch (java.lang.NullPointerException err) {
        }
    }

    private void isDoctor() {
        tempDoctor.setName(manageEdit.getTxtFieldName().getText());
        tempDoctor.setLastName(manageEdit.getTxtFieldLastName().getText());
        tempDoctor.setCedula(manageEdit.getTxtFieldCedula().getText());
        tempDoctor.setTelephone(manageEdit.getTxtFieldPhone().getText());
        tempDoctor.setCellphone(manageEdit.getTxtFieldCellPhone().getText());
        tempDoctor.setPosition(manageEdit.getTxtFieldJobPosition().getText());
        tempDoctor.setSpeciality(manageEdit.getTxtFieldSpeciality().getText());
    }

    private void isEmployee() {
        tempEmployee.setName(manageEdit.getTxtFieldName().getText());
        tempEmployee.setLastName(manageEdit.getTxtFieldLastName().getText());
        tempEmployee.setCedula(manageEdit.getTxtFieldCedula().getText());
        tempEmployee.setTelephone(manageEdit.getTxtFieldPhone().getText());
        tempEmployee.setCellphone(manageEdit.getTxtFieldCellPhone().getText());
        tempEmployee.setPosition(manageEdit.getTxtFieldJobPosition().getText());
    }

    private boolean isEmptyFields() {
        boolean state = false;
        javax.swing.text.JTextComponent textField;
        String date;


        for (int i = 0; i <= manageEdit.getPnFields().getComponentCount(); i++) {
            try {
                textField = (javax.swing.text.JTextComponent) manageEdit.getPnFields().getComponent(i);
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
    public void insert() {
        try {
            String i;
            if (manageEdit.getjRadioButtonDoctor().isSelected()) {
                i = "Doctor";
                tempDoctor = new Doctor(manageEdit.getTxtFieldName().getText(), manageEdit.getTxtFieldLastName().getText(), manageEdit.getTxtFieldCedula().getText(), manageEdit.getTxtFieldJobPosition().getText(), manageEdit.getTxtFieldSpeciality().getText(), manageEdit.getTxtFieldPhone().getText(), manageEdit.getTxtFieldCellPhone().getText());
                mdlEmployees.insertObject(tempDoctor);
            } else {
                i = "Normal";
                tempEmployee = new Employees(manageEdit.getTxtFieldName().getText(), manageEdit.getTxtFieldLastName().getText(), manageEdit.getTxtFieldCedula().getText(), manageEdit.getTxtFieldJobPosition().getText(), manageEdit.getTxtFieldPhone().getText(), manageEdit.getTxtFieldCellPhone().getText());
                mdlEmployees.insertObject(tempEmployee);
            }

            JOptionPane.showMessageDialog(manageEdit, "Registro Insertado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            manageEdit.dispose();
        } catch (Exception ex) {
            Logger.getLogger(ControllerEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(boolean isDoctor) {
        int i = JOptionPane.showConfirmDialog(manageEdit, "Realmente desea Sobreescribir Los Datos de Este Cliente?", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i == 0) {
            if (isDoctor == true) {
                mdlEmployees.updateObject(tempDoctor);
            } else {
                mdlEmployees.updateObject(tempEmployee);
            }
            JOptionPane.showMessageDialog(manageEdit, "Registro Actualizado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            manageEdit.dispose();
        }
    }

    @Override
    public void btnAdd() {
        edicion = 0;
        manageEdit = new ManageEmployeesEdit(null, true, this);
        manageEdit.showFrame();
    }

    @Override
    public void btnUpdate() {
        if (edicion != 0) {
            manageEdit = new ManageEmployeesEdit(null, true, this);
            if (mdlEmployees.checkIsDoctor(edicion)) {
                tempDoctor = mdlEmployees.searchDoctorEmployee(edicion);
                manageEdit.setFieldsValueDoctor(tempDoctor.getCedula(), tempDoctor.getCellphone(), tempDoctor.getPosition(), tempDoctor.getLastName(), tempDoctor.getName(), tempDoctor.getTelephone(), tempDoctor.getSpeciality());
                isDoctor = true;
            } else {
                tempEmployee = mdlEmployees.searchEmployee(edicion);
                manageEdit.setFieldsValue(tempEmployee.getCedula(), tempEmployee.getCellphone(), tempEmployee.getPosition(), tempEmployee.getLastName(), tempEmployee.getName(), tempEmployee.getTelephone(), "");
                isDoctor = false;
            }
            manageEdit.showFrame();
            edicion = 0;
            return;
        } else {
            javax.swing.JOptionPane.showMessageDialog(manageMenu, "No Ha Sido Seleccionado Un Registro");
        }
    }

    @Override
    public void btnSave() {
        if (manageEdit.getjRadioButtonNormal().isSelected()) {
            manageEdit.getTxtFieldSpeciality().setText("Sorry 4 Wait");
        }
        if (isEmptyFields()) {
            JOptionPane.showMessageDialog(manageEdit, "Existen Campos En Blancos Por Favor Completar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (edicion != 0) {
            if (mdlEmployees.checkIsDoctor(edicion)) {
                if (manageEdit.getjRadioButtonDoctor().isSelected()) {
                    isDoctor();
                    if (mdlEmployees.checkDuplicateCedula(manageEdit.getTxtFieldCedula().getText())) {
                        if (tempDoctor.getCedula().equalsIgnoreCase(manageEdit.getTxtFieldCedula().getText())) {
                            update(true);
                        } else {
                            JOptionPane.showMessageDialog(manageEdit, "Existe Otro Usuario Con El Mismo Numero de Cedula", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        tempDoctor.setCedula(manageEdit.getTxtFieldCedula().getText());
                        update(true);
                    }

                } else {
                    mdlEmployees.deleteObject(tempDoctor);
                    tempEmployee = new Employees();
                    tempEmployee.setPersonId(edicion);
                    isEmployee();
                    if (mdlEmployees.checkDuplicateCedula(manageEdit.getTxtFieldCedula().getText())) {
                        if (tempEmployee.getCedula().equalsIgnoreCase(manageEdit.getTxtFieldCedula().getText())) {
                            update(false);
                        } else {
                            JOptionPane.showMessageDialog(manageEdit, "Existe Otro Usuario Con El Mismo Numero de Cedula", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        tempEmployee.setCedula(manageEdit.getTxtFieldCedula().getText());
                        update(false);
                    }
                }

            } else {
                if (manageEdit.getjRadioButtonNormal().isSelected()) {
                    isEmployee();
                    if (mdlEmployees.checkDuplicateCedula(manageEdit.getTxtFieldCedula().getText())) {
                        if (tempEmployee.getCedula().equalsIgnoreCase(manageEdit.getTxtFieldCedula().getText())) {
                            update(true);
                        } else {
                            JOptionPane.showMessageDialog(manageEdit, "Existe Otro Usuario Con El Mismo Numero de Cedula", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        tempEmployee.setCedula(manageEdit.getTxtFieldCedula().getText());
                        update(true);
                    }
                } else {
                    mdlEmployees.deleteObject(tempEmployee);
                    tempDoctor = new Doctor();
                    tempDoctor.setPersonId(edicion);
                    isDoctor();
                    if (mdlEmployees.checkDuplicateCedula(manageEdit.getTxtFieldCedula().getText())) {
                        if (tempDoctor.getCedula().equalsIgnoreCase(manageEdit.getTxtFieldCedula().getText())) {
                            update(true);
                        } else {
                            JOptionPane.showMessageDialog(manageEdit, "Existe Otro Usuario Con El Mismo Numero de Cedula", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        tempDoctor.setCedula(manageEdit.getTxtFieldCedula().getText());
                        update(true);
                    }
                }

            }
        } else {
            if (mdlEmployees.checkDuplicateCedula(manageEdit.getTxtFieldCedula().getText())) {
                JOptionPane.showMessageDialog(manageEdit, "Existe Otro Cliente Con El Mismo Numero de Cedula", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                return;
            }
            insert();
        }
    }

    @Override
    public void btnRemove() {
        if (edicion != 0) {
            int i = JOptionPane.showConfirmDialog(manageMenu, "Realmente desea Eliminar Este Usuario?", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (i == 0) {
                mdlEmployees.deleteObject(mdlEmployees.searchEmployee(edicion));
                javax.swing.JOptionPane.showMessageDialog(manageMenu, "Registro Eliminado");
            }
            searchByField(manageMenu.getSearching().getTxtSearch().getText().toLowerCase());
            edicion = 0;
        } else {
            javax.swing.JOptionPane.showMessageDialog(manageMenu, "No Ha Sido Seleccionado Un Registro");
        }
    }

    @Override
    public void btncancelar() {
        int i = JOptionPane.showConfirmDialog(manageEdit, "Realmente desea Cancelar la Insercion de Datos", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i == 0) {
            manageEdit.dispose();
        }
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void btnPersonData() {
        Persons temp = new SearchPersons(manageEdit, true, mdlEmployees.getQueryManager(),2).personShowSearch();
        edicion = temp.getPersonId();
        manageEdit.setFieldsValue(temp.getCedula(), temp.getCellphone(), temp.getLastName(), temp.getName(), temp.getTelephone());
        return;
    }
}
