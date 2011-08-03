package itla.jpuppy.models;

import itla.jpuppy.business.*;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.forms.SearchSpecies;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerSearchSpecies implements ActionListener {

    private SearchSpecies searchSpecies = null;
    private List<Breeds> list = null;

    public ControllerSearchSpecies(SearchSpecies ss) {
        this.searchSpecies = ss;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals(searchSpecies.getActionCommandSearch())) {
            if (searchSpecies.getjComboBox1().getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona la especie que deseas buscasr!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //list = new ModelBreeds().searchBreedsBySpecie(new ModelSpecies().getSpeciesByName(searchSpecies.getjComboBox1().getSelectedItem().toString()).getSpeciesId());
//                //Llenar el JTable de los datos existentes
//                DefaultTableModel temp = (DefaultTableModel) searchSpecies.getjTable1().getModel();
////                for (Breeds value : list) {
////                    Object[] nuevo = {value.getBreedsName(), value.getSpecie().getSpeciesName(), value.getWidth(), value.getHeight()};
////                    //System.out.println(value.getBreedsName());
////                    temp.addRow(nuevo);
////                }
                System.out.println(new ModelBreeds().searchBreedsBySpecie(new ModelSpecies().getSpeciesByName(searchSpecies.getjComboBox1().getSelectedItem().toString())).size());
                //EditorTable miRender = new EditorTable();
                //tblBreeds.setDefaultRenderer(Boolean.class, miRender);
            }
        }
    }
}