package itla.jpuppy.controllers;

import itla.jpuppy.forms.ManageConsultations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerConsultations implements ActionListener{
    private ManageConsultations manageConsultations = null;
    
    public ControllerConsultations(ManageConsultations mc) {
        this.manageConsultations = mc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}