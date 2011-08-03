package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelUsers;
import itla.jpuppy.datalayer.Users;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.ManageUsersEdit;
import itla.jpuppy.forms.ManageUsersMenu;
import itla.jpuppy.models.SearchingCtrlUsers;
import itla.jpuppy.models.SearchingModel;
import itla.jpuppy.utils.EncryptText;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerUser implements MouseListener, KeyListener, ActionListener, WindowFocusListener {

    private ManageUsersMenu manageMenu;
    private ManageUsersEdit manageEdit;
    private SearchingModel<Users> modelSearching;
    private ModelUsers mdlUsers;
    private long edicion;
    private Users tempUser;

    public ControllerUser(ManageUsersMenu manageMenu) {
        this.manageMenu = manageMenu;
        modelSearching = new SearchingModel<Users>(new String[]{"Id", "Name", "Username", "Type User"}, new SearchingCtrlUsers());
        manageMenu.setSearching(new JSearching(modelSearching));
        mdlUsers = new ModelUsers();
        searchByField("");
        edicion = 0;
    }

    public void searchByField(String string) {
        modelSearching.setElements(mdlUsers.searchAllUserByUserName("%" + string + "%"));
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
            manageEdit = new ManageUsersEdit(null, true, this);
            manageEdit.showFrame();
            return;
        }

        if (e.getSource().equals(manageMenu.getBtnUpdate())) {
            if (edicion != 0) {
                manageEdit = new ManageUsersEdit(null, true, this);
                tempUser = mdlUsers.searchUser(edicion);
                manageEdit.setFieldsValue(tempUser.getLastName(), tempUser.getCellphone(), tempUser.getName(), tempUser.getUsername(), tempUser.getPassword(), tempUser.getTelephone(), tempUser.getTypeUser());
                manageEdit.showFrame();
                return;
            } else {
                javax.swing.JOptionPane.showMessageDialog(manageMenu, "No Ha Sido Seleccionado Un Registro");
            }
            return;
        }

        if (e.getSource().equals(manageMenu.getBtnRemove())) {
            if (edicion != 0) {
                int i = JOptionPane.showConfirmDialog(manageMenu, "Realmente desea Eliminar Este Usuario?", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == 0) {
                    mdlUsers.deleteObject(mdlUsers.searchUser(edicion));
                    javax.swing.JOptionPane.showMessageDialog(manageMenu, "Registro Eliminado");
                }
                searchByField(manageMenu.getSearching().getTxtSearch().getText().toLowerCase());
                edicion = 0;
            } else {
                javax.swing.JOptionPane.showMessageDialog(manageMenu, "No Ha Sido Seleccionado Un Registro");
            }
            return;
        }

        if (e.getSource().equals(manageEdit.getBtnSave())) {

            if (isEmptyFields()) {
                JOptionPane.showMessageDialog(manageEdit, "Existen Campos En Blancos Por Favor Completar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (edicion != 0) {
                try {
                    tempUser.setPassword(EncryptText.md5(manageEdit.getTxtFieldPassword().getText()));
                } catch (Exception ex) {
                    Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (manageEdit.getjRadioButtonAdministrador().isSelected()) {
                    tempUser.setTypeUser("Administrador");
                } else {
                    tempUser.setTypeUser("Operador");
                }
                tempUser.setLastName(manageEdit.getTxtFieldApellido().getText());
                tempUser.setName(manageEdit.getTxtFieldName().getText());
                tempUser.setCellphone(manageEdit.getTxtFieldCellPhone().getText());
                tempUser.setTelephone(manageEdit.getTxtFieldPhone().getText());

                if (mdlUsers.checkDuplicateUserName(manageEdit.getTxtFieldNameUser().getText())) {
                    if (tempUser.getUsername().equalsIgnoreCase(manageEdit.getTxtFieldNameUser().getText())) {
                        update();
                    } else {
                        JOptionPane.showMessageDialog(manageEdit, "Existe Otra Persona Con El Mismo Numero de Usuario", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    tempUser.setUsername(manageEdit.getTxtFieldNameUser().getText());
                    update();
                }
            } else {
                if (mdlUsers.searchAllUserByUserName(manageEdit.getTxtFieldNameUser().getText()).size() > 0) {
                    JOptionPane.showMessageDialog(manageEdit, "Existe Otro Usuario Con El Mismo Nombre de Usuario", "Error GRAVE", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                insert();
            }
        }

        if (e.getSource().equals(manageEdit.getBtnCancel())) {
            int i = JOptionPane.showConfirmDialog(manageEdit, "Realmente desea Cancelar la Insercion de Datos", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (i == 0) {
                manageEdit.dispose();
            }
            return;
        }
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

    private void insert() {
        try {
            Calendar c1 = Calendar.getInstance();
            String i;
            if (manageEdit.getjRadioButtonAdministrador().isSelected()) {
                i = "Administrador";
            } else {
                i = "Operador";
            }
            Users temp = new Users(manageEdit.getTxtFieldNameUser().getText(), EncryptText.md5(manageEdit.getTxtFieldPassword().getText()), i, manageEdit.getTxtFieldName().getText(), manageEdit.getTxtFieldApellido().getText(), manageEdit.getTxtFieldPhone().getText(), manageEdit.getTxtFieldCellPhone().getText());
            mdlUsers.insertObject(temp);
            JOptionPane.showMessageDialog(manageEdit, "Registro Insertado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            manageEdit.dispose();
        } catch (Exception ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update() {
        int i = JOptionPane.showConfirmDialog(manageEdit, "Realmente desea Sobreescribir Los Datos de Este Cliente?", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i == 0) {
            mdlUsers.updateObject(tempUser);
            JOptionPane.showMessageDialog(manageEdit, "Registro Actualizado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            manageEdit.dispose();
        }
    }
}
