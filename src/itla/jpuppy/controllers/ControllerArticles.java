package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelArticles;
import itla.jpuppy.datalayer.Articles;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.ManageArticlesEdit;
import itla.jpuppy.forms.ManageArticlesMenu;
import itla.jpuppy.models.SearchingCtrlArticles;
import itla.jpuppy.models.SearchingModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerArticles implements MouseListener, KeyListener, ActionListener, WindowFocusListener {

    private ManageArticlesMenu manageMenu;
    private ManageArticlesEdit manageEdit;
    private SearchingModel<Articles> modelSearching;
    private ModelArticles mdlArticles;
    private long edicion;
    private Articles tempArticles;

    public ControllerArticles(ManageArticlesMenu manageMenu) {
        this.manageMenu = manageMenu;
        modelSearching = new SearchingModel<Articles>(new String[]{"ArticleId", "Nombre", "Cantidad", "Precio"}, new SearchingCtrlArticles());
        manageMenu.setSearching(new JSearching(modelSearching));
        mdlArticles = new ModelArticles();
        searchByField("");
        edicion = 0;
    }

    public void searchByField(String string) {
        modelSearching.setElements(mdlArticles.searchAllArticleByName("%" + string + "%"));
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
            edicion = 0;
            manageEdit = new ManageArticlesEdit(null, true, this);
            manageEdit.showFrame();
            return;
        }

        if (e.getSource().equals(manageMenu.getBtnUpdate())) {
            if (edicion != 0) {
                manageEdit = new ManageArticlesEdit(null, true, this);
                tempArticles = mdlArticles.searchArticle(edicion);
                manageEdit.setFields(String.valueOf(tempArticles.getAmount()), tempArticles.getName(), String.valueOf(tempArticles.getPrice()), tempArticles.getDescription());
                manageEdit.showFrame();
                edicion = 0;
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
                    mdlArticles.deleteObject(mdlArticles.searchArticle(edicion));
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
                update();
            } else {
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
            Articles temp = new Articles(manageEdit.getTxtFieldName().getText(), Double.parseDouble(manageEdit.getTxtFieldPrice().getText()), Integer.parseInt(manageEdit.getTxtFieldPrice().getText()), manageEdit.getjTxtAreaDescription().getText());
            mdlArticles.insertObject(temp);
            JOptionPane.showMessageDialog(manageEdit, "Registro Insertado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            manageEdit.dispose();
        } catch (Exception ex) {
            Logger.getLogger(ControllerArticles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update() {
        tempArticles.setName(manageEdit.getTxtFieldName().getText());
        tempArticles.setPrice(Double.parseDouble(manageEdit.getTxtFieldPrice().getText()));
        tempArticles.setAmount(Integer.parseInt(manageEdit.getTxtFieldAmount().getText()));
        tempArticles.setDescription(manageEdit.getjTxtAreaDescription().getText());
        int i = JOptionPane.showConfirmDialog(manageEdit, "Realmente desea Sobreescribir Los Datos de Este Cliente?", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i == 0) {
            mdlArticles.updateObject(tempArticles);
            JOptionPane.showMessageDialog(manageEdit, "Registro Actualizado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            manageEdit.dispose();
        }
    }
}
