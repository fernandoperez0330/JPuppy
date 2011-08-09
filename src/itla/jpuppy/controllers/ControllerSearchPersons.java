/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelPersons;
import itla.jpuppy.business.QueryManager;
import itla.jpuppy.datalayer.Persons;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.SearchPersons;
import itla.jpuppy.models.SearchingCtrlPersons;
import itla.jpuppy.models.SearchingModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Jordhano
 */
public class ControllerSearchPersons implements MouseListener, KeyListener {

    private SearchPersons searchPerson;
    private SearchingModel<Persons> modelSearching;
    private ModelPersons mdlPersons;

    public ControllerSearchPersons(SearchPersons searchPerson, QueryManager queryManager, int filter) {
        this.searchPerson = searchPerson;
        modelSearching = new SearchingModel<Persons>(new String[]{"ID", "NOMBRE", "APELLIDOS", "CEDULA"}, new SearchingCtrlPersons());
        this.searchPerson.setSearching(new JSearching(modelSearching));
        mdlPersons = new ModelPersons(queryManager);
        mdlPersons.setFilter(filter);
        searchByField("");
    }

    public void searchByField(String string) {
        modelSearching.setElements(mdlPersons.searchAllPersons("%" + string + "%"));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(searchPerson.getSearching().getTblResult())) {
            int fila = searchPerson.getSearching().getTblResult().rowAtPoint(e.getPoint());
            if (fila > -1) {
                long edicion = (Long) searchPerson.getSearching().getTblResult().getValueAt(fila, 0);
                searchPerson.setPerson(mdlPersons.searchPerson(edicion));
                searchPerson.dispose();
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
        if (e.getSource().equals(searchPerson.getSearching().getTxtSearch())) {
            searchByField(searchPerson.getSearching().getTxtSearch().getText().toLowerCase());
        }
    }
}
