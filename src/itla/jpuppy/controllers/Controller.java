package itla.jpuppy.controllers;

import itla.jpuppy.forms.ManageMenu;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowFocusListener;

public abstract class Controller implements MouseListener, KeyListener, ActionListener, WindowFocusListener {

    protected javax.swing.JButton btnAdd;
    protected javax.swing.JButton btnUpdate;
    protected javax.swing.JButton btnSearch;
    protected javax.swing.JButton btnSave;
    protected javax.swing.JButton btnRemove;
    protected javax.swing.JButton btnCancel;
    protected javax.swing.JPanel pnlButton;
    protected javax.swing.JPanel pnlEdition;
    
    

    protected void stateButtons(boolean state1, boolean state2) {
        btnAdd.setEnabled(state1);
        btnUpdate.setEnabled(state1);
        btnSearch.setEnabled(state1);
        btnSave.setEnabled(state2);
        btnRemove.setEnabled(state1);
        btnCancel.setEnabled(state2);

        changeStatePnlEdition(state2);
    }

    protected void initFields(javax.swing.JPanel pnlFields, javax.swing.JPanel pnlButtons) {
        this.pnlButton = pnlButtons;
        this.pnlEdition = pnlFields;
        initButtons();
        stateButtons(true, false);


    }

    protected void initButtons() {
        this.btnAdd = (javax.swing.JButton) this.pnlButton.getComponent(0);
        this.btnUpdate = (javax.swing.JButton) this.pnlButton.getComponent(1);
        this.btnSearch = (javax.swing.JButton) this.pnlButton.getComponent(2);
        this.btnSave = (javax.swing.JButton) this.pnlButton.getComponent(3);
        this.btnRemove = (javax.swing.JButton) this.pnlButton.getComponent(4);
        this.btnCancel = (javax.swing.JButton) this.pnlButton.getComponent(5);

    }

    protected void changeStatePnlEdition(boolean state) {
        javax.swing.JComponent a;
        for (int i = 0; i < pnlEdition.getComponentCount(); i++) {
            a = (javax.swing.JComponent) pnlEdition.getComponent(i);
            a.setEnabled(state);
        }
    }

    protected void cleanFields() {
        javax.swing.text.JTextComponent textField;
        for (int i = 0; i < pnlEdition.getComponentCount(); i++) {
            try {
                textField = (javax.swing.text.JTextComponent) pnlEdition.getComponent(i);
                textField.setText("");
            } catch (Exception e) {
            }
        }
    }

    protected void changeStateWriteFields(boolean estado) {
        javax.swing.text.JTextComponent textField;
        javax.swing.JComboBox combo;

        for (int i = 0; i < pnlEdition.getComponentCount(); i++) {
            try {
                textField = (javax.swing.text.JTextComponent) pnlEdition.getComponent(i);
                textField.setEditable(estado);
            } catch (Exception e) {
                try {
                    combo = (javax.swing.JComboBox) pnlEdition.getComponent(i);
                    combo.setEditable(false);
                } catch (Exception g) {
                }
            }
        }
    }

    protected void eventNew() {//La Variable Global
        cleanFields();
        stateButtons(false, true);
        changeStateWriteFields(true);
        //sNombre = "";
    }

    protected void eventEdit(String text) { ////La Variable Global

        if (text.equals("-") || text.equals("-")) {
            javax.swing.JOptionPane.showMessageDialog(null, "No Selected Register", "Aviso", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            changeStateWriteFields(true);
            stateButtons(false, true);
        }
    }

    protected void eventCancelar() { //La Variable Global
        cleanFields();
        stateButtons(true, false);
        String sNombre = "";
    }

    protected boolean isEmptyFields() {
        boolean state = false;
        javax.swing.text.JTextComponent textField;
        javax.swing.JComboBox combo;


        for (int i = 0; i <= pnlEdition.getComponentCount(); i++) {
            try {
                textField = (javax.swing.text.JTextComponent) pnlEdition.getComponent(i);
                if (textField.getText().equals("")) {
                    state = true;
                } else if (textField.getText().indexOf("-") != -1) {
                    String special = textField.getText().trim();
                    if ((special.length() < 12) && (special.length() != 10)) {
                        state = true;
                    }
                }
            } catch (Exception e) {
                try {
                    combo = (javax.swing.JComboBox) pnlEdition.getComponent(i);
                    if (combo.getSelectedItem().equals("-")) {
                        state = true;
                    }

                } catch (Exception ep) {
                }
            }
        }
        return state;
    }

    public abstract void btnAdd();

    public abstract void btnUpdate();

    public abstract void btnSave();

    public abstract void btnRemove();

    public abstract void btncancelar();

    public abstract void insert();

    public abstract void update();
}
