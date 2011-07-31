package itla.jpuppy.controllers;

import itla.jpuppy.forms.ManageSpecies;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerSpecies implements ActionListener{

    ManageSpecies manageSpecies = null;

    public ControllerSpecies(ManageSpecies ms) {
        this.manageSpecies = ms;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
