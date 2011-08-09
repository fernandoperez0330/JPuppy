/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelBreeds;
import itla.jpuppy.business.ModelSpecies;
import itla.jpuppy.business.QueryManager;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.datalayer.Species;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.ManageBreedEdit;
import itla.jpuppy.forms.ManageBreedMenu;
import itla.jpuppy.models.SearchingCrtlBreeds;
import itla.jpuppy.models.SearchingModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Jansel
 */
public class ControllerBreeds implements ActionListener, KeyListener, MouseListener, WindowFocusListener {

    private ModelBreeds modelBreeds = null;
    private ManageBreedMenu manageBreeds = null;
    private ModelSpecies modelSpecies = new ModelSpecies();
    private Breeds breed = null;
    private Species species = null;
    private ManageBreedEdit manageEdit = null;
    private SearchingModel<Breeds> searchingModel = null;
    private long id;
    private Breeds temp = null;
    private ComboBoxModel model = null;
    private String text = "";

    public ControllerBreeds(ManageBreedMenu manageBreeds) {
        modelBreeds = new ModelBreeds();
        this.manageBreeds = manageBreeds;
        searchingModel = new SearchingModel<Breeds>(new String[]{"ID", "NOMBRE", "ESPECIE", "ANCHO", "ALTO"}, new SearchingCrtlBreeds());
        this.manageBreeds.setSearching(new JSearching(searchingModel));
        searchByField("");
        id = 0;
        model = new DefaultComboBoxModel(this.searchAllSpecies());

    }

    public void searchByField(String string) {
        searchingModel.setElements(modelBreeds.searchAllBreedsByName("%" + string + "%"));
    }

    public ControllerBreeds() {
    }

    public String[] searchAllSpecies() {

        List<Species> list = modelSpecies.searchAllSpecies();
        String[] listReturn = new String[list.size()];
        ListIterator<Species> iterator = list.listIterator();
        int i = 0;
        while (iterator.hasNext()) {
            listReturn[ i] = iterator.next().getSpeciesName();
            i++;
        }

        return listReturn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        if (command.equals("add")) {
            this.manageEdit = new ManageBreedEdit(null, true, this);
            this.manageEdit.setComboBoxModel(model);
            this.manageEdit.showFrame();
            temp = null;

        } else if (command.equals("remove")) {
            if (temp != null) {
                int i = JOptionPane.showConfirmDialog(null, "En Realidad Desea Eliminar El Registro", "Atencion", JOptionPane.OK_OPTION);
                if (i == 0) {
                    this.modelBreeds.deleteObject(temp);
                    id = 0;
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    temp = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Transaccion Cancelada");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No Se Ha Seleccionado Ningun Registro");
            }

        } else if (command.equals("save")) {

            if (isEmptyFields()) {
                JOptionPane.showMessageDialog(null, "Existen Campos En Blancos Por Favor Completar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                if (temp == null) {
                    if (this.manageEdit.getBreedHeigth() != 0 && this.manageEdit.getBreedWidth() != 0) {
                        this.species = modelSpecies.getSpeciesByName(this.manageEdit.getSpecieName());
                        this.breed = new Breeds(manageEdit.getBreedName(), species, manageEdit.getBreedHeigth(), manageEdit.getBreedWidth());
                        modelBreeds.insertObject(this.breed);
                        JOptionPane.showMessageDialog(null, "Registro Agregado ");
                        this.manageEdit.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Existen Malas Entradas En Campos Favor Corrregir", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    int i = JOptionPane.showConfirmDialog(null, "Seguro De Querer Alterar La Informacion De Este Registro", "Atencion", JOptionPane.OK_OPTION);
                    if (i == 0) {
                        Species es = this.modelSpecies.getSpeciesByName(this.manageEdit.getSpecieName());
                        temp.setBreedsName(this.manageEdit.getBreedName());
                        temp.setSpecie(es);
                        temp.setHeight(this.manageEdit.getBreedHeigth());
                        temp.setWidth(this.manageEdit.getBreedWidth());

                        modelBreeds.updateObject(temp);
                        this.manageEdit.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Tansaccion Cancelada");
                    }

                }
                temp = null;


            }

        } else if (command.equals("cancel")) {
            int i = JOptionPane.showConfirmDialog(null, " En Realidad Desea Cancelar El registro", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (i == 0) {
                manageEdit.dispose();
                temp = null;
            }

        } else if (command.equals("update")) {

            if (id != 0) {
                this.manageEdit = new ManageBreedEdit(null, true, this);
                this.manageEdit.setComboBoxModel(model);
                this.manageEdit.setAllFields(temp.getBreedsName(), temp.getSpecie().getSpeciesName(), temp.getWidth(), temp.getHeight());
                this.manageEdit.showFrame();
            } else {
                JOptionPane.showMessageDialog(null, "No Existe Un Registro Seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (command.equals("exit")) {
            this.manageBreeds.closeFrame();
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(manageBreeds.getSearching().getTxtSearch())) {
            searchByField(manageBreeds.getSearching().getTxtSearch().getText().toLowerCase());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(manageBreeds.getSearching().getTblResult())) {
            int fila = manageBreeds.getSearching().getTblResult().rowAtPoint(e.getPoint());
            if (fila > -1) {
                id = (Long) manageBreeds.getSearching().getTblResult().getValueAt(fila, 0);
                temp = modelBreeds.searchBreedById(id);
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
        ;
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        searchByField(manageBreeds.getSearching().getTxtSearch().getText().toLowerCase());
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
    }

    private boolean isEmptyFields() {
        boolean state = false;
        javax.swing.text.JTextComponent textField;
        javax.swing.JComboBox combo;
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
}
