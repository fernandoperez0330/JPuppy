package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelSpecies;
import itla.jpuppy.datalayer.Species;
import itla.jpuppy.forms.ManageSpecies;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

public class ControllerSpecies implements ActionListener {

    ManageSpecies manageSpecies = null;

    public ControllerSpecies(ManageSpecies ms) {
        this.manageSpecies = ms;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Evaluando cual boton fue pulsado y que debe realizar
        String comando = e.getActionCommand();
        if (comando.equals(manageSpecies.getActionCommandAdd())) {
            String valueBreed = (String) manageSpecies.getjComboBoxNameBreeds().getSelectedItem();
            //System.out.println(valueBreed);
            //this.addSpecie(valueBreed, manageSpecies.getTxtFieldEspecie().getText());
        } else if (comando.equals(manageSpecies.getActionCommandAddSpecie())) {
            String name = (String)JOptionPane.showInputDialog("Inserte la raza que desea agregar:");
        }
    }

    //Metodos que conectan con el ModelSpecies
    public void addSpecie(String breed, String name) {

        if (breed.equals("-") || name.equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Species species = new ModelSpecies().getSpecies();
            //species.
            
            
            //new ModelSpecies().insertObject(species);
            JOptionPane.showMessageDialog(null, "Se ha almacenado correctamente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        //System.out.println("Especie: "+ breed + " nombre: "+ name);    
    }
}
