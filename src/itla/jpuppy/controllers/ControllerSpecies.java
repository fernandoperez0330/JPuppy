package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelSpecies;
import itla.jpuppy.business.QueryManager;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.datalayer.Species;
import itla.jpuppy.forms.ManageSpecies;
import itla.jpuppy.forms.SearchSpecies;
import itla.jpuppy.models.BreedsTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ControllerSpecies implements ActionListener {

    private ManageSpecies manageSpecies = null;

    public ControllerSpecies(ManageSpecies ms) {
        this.manageSpecies = ms;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //List<Breeds> listBreeds = new LinkedList<Breeds>();
        //Breeds breeds = new Breeds();
        //Evaluando cual boton fue pulsado y que debe realizar
        String comando = e.getActionCommand();

        //System.out.println(comando);
        if (comando.equals(manageSpecies.getActionCommandAdd())) {
            //Object[] possibilities = {"ham", "spam", "yam"};
            String nameSpecie = JOptionPane.showInputDialog(manageSpecies, "Escribe la especie que deseas agregar:", "Insertar especies.", JOptionPane.INFORMATION_MESSAGE);

            if (new ModelSpecies().searchAllSpeciesByName(nameSpecie).isEmpty()) {
                try {
                    if (nameSpecie.equals("")) {
                        JOptionPane.showMessageDialog(null, "Para almacenar especies, debes introdicir una especie!", "Error:", JOptionPane.ERROR_MESSAGE);
                    } else if (nameSpecie == null) {
                        System.out.println("Hola");
                    } else {
                        //ALMACENAMIENTO DE LA ESPECIE
                        if (new ModelSpecies().insertObject(new Species(nameSpecie))) {
                            JOptionPane.showMessageDialog(null, "La especie se ha almacenado correctamente!!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Se ha producido un error!", "Informacion", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (Exception excc) {
                    //excc.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esta especie ya se encuentra almacenada!", "Informacion", JOptionPane.ERROR_MESSAGE);
            }

//            if (manageSpecies.getjComboBoxNameBreeds().getSelectedItem().equals("-")) {
//                JOptionPane.showMessageDialog(null, "Para almacenar especies, debes seleccionar una especie!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                boolean status = false;
//                for (int b = 0; b < manageSpecies.getList().size(); b++) {
//                    Boolean test1 = (Boolean) manageSpecies.getJTableBreeds().getValueAt(b, 4);
//                    if (test1 == null) {
//                        status = false;
//                        continue;
//                    } else if (test1 == true) {
//                        status = true;
//                        break;
//                    } else {
//                        status = false;
//                        continue;
//                    }
//                }
//                if (status == true) {
//                    for (int a = 0; a < manageSpecies.getList().size(); a++) {
//                        Object val = manageSpecies.getJTableBreeds().getValueAt(a, 4);
//                        if (val instanceof Boolean) {
//                            Boolean test = (Boolean) val;
//                            if (test == true) {
//                                //System.out.println(manageSpecies.getJTableBreeds().getValueAt(a, 0).toString() +" - "+ manageSpecies.getJTableBreeds().getValueAt(a, 2).toString() +" - "+ manageSpecies.getJTableBreeds().getValueAt(a, 3).toString());
//                                breeds = queryManager.searchBreeds(manageSpecies.getJTableBreeds().getValueAt(a, 0).toString(), String.valueOf(manageSpecies.getJTableBreeds().getValueAt(a, 2)));
//                                //, Double.valueOf(String.valueOf(manageSpecies.getJTableBreeds().getValueAt(a, 2)))
//                                //System.out.println(breeds.getBreedsId());
//                                listBreeds.add(breeds);
//                            }
//                        }
//                    }
//                    System.out.println("Lista: "+listBreeds.size());
//                    System.out.println("String: "+manageSpecies.getjComboBoxNameBreeds().getSelectedItem().toString());
//                    //ALMACENAMIENTO DE LA ESPECIE
////                    if (new ModelSpecies().insertObject(new Species(manageSpecies.getjComboBoxNameBreeds().getSelectedItem().toString(), listBreeds))) {
////                        JOptionPane.showMessageDialog(null, "Se almaceno conrrectamente!", "Informacion", JOptionPane.PLAIN_MESSAGE);
////                    } else {
////                        JOptionPane.showMessageDialog(null, "Se ha producido un error!", "Informacion", JOptionPane.ERROR_MESSAGE);
////                    }
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "Para almacenar especies, debes seleccionar razas!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
            //new ModelSpecies().insertObject(new Species(manageSpecies.getjComboBoxNameBreeds().getSelectedItem().toString(), listBreeds));

        } else if (comando.equals(manageSpecies.getActionCommandSearch())) {
            new SearchSpecies(null, true).showFrame();
        }  else if (comando.equals(manageSpecies.getActionCommandCancel())) {
            //int respond = JOptionPane.showConfirmDialog(null, "¿Desea Cancelar esta transaccion?", "Cancelar", JOptionPane.OK_CANCEL_OPTION);
            //if (respond == 0) {
                manageSpecies.closeFrame();
            //}
        }
//else if (comando.equals(searchSpecies.getActionCommandSearch())) {
//            System.out.println("Hola");
//
//        }

    }
}
