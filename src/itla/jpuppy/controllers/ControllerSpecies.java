package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelSpecies;
import itla.jpuppy.business.QueryManager;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.datalayer.Species;
import itla.jpuppy.forms.ManageSpecies;

import itla.jpuppy.models.BreedsTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ControllerSpecies implements ActionListener, TableModelListener {

    ManageSpecies manageSpecies = null;

    public ControllerSpecies(ManageSpecies ms) {
        this.manageSpecies = ms;
    }

    public ControllerSpecies(){}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        //Evaluando cual boton fue pulsado y que debe realizar
        String comando = e.getActionCommand();
        if (comando.equals(manageSpecies.getActionCommandAdd())) {
        //String valueBreed = (String) manageSpecies.getjComboBoxNameBreeds().getSelectedItem();
        
        //
        //this.addSpecie(valueBreed, manageSpecies.getTxtFieldEspecie().getText());
        } else if (comando.equals(manageSpecies.getActionCommandAddSpecie())) {
        System.out.println(manageSpecies.getActionCommandAddSpecie());
        new SelectBreeds().showFrame();
        }
         * 
         */
    }

    @Override
    public void tableChanged(TableModelEvent e) {
//        int row = e.getFirstRow();
//        int column = e.getColumn();
//        BreedsTableModel model = (BreedsTableModel) e.getSource();
//        String columnName = model.getColumnName(column);
//        Object data = model.getValueAt(row, column);
//        
//        System.out.println("Presionaste!");
    }
    
    //Metodos que conectan con el ModelSpecies
    public void addSpecie(String breed, String name) {
//        if (breed.equals("-") || name.equals("")) {
//            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            //Species species = new ModelSpecies().getSpecies();
//            //species.
//            
//            
//            //new ModelSpecies().insertObject(species);
//            JOptionPane.showMessageDialog(null, "Se ha almacenado correctamente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//        }
        //System.out.println("Especie: "+ breed + " nombre: "+ name);    
    }
    
    public List<Breeds> getBreeds(){
        //return new QueryManager().getBreeds();
        return null;
    }
}
