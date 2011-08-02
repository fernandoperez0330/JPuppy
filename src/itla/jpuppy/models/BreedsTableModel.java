package itla.jpuppy.models;

import itla.jpuppy.datalayer.Breeds;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

//Modelo de agregado de Breeds
public class BreedsTableModel extends AbstractTableModel {

    private static BreedsTableModel breedsTableModel;
    ArrayList<Breeds> containerBreeds;
    String[] nameColumns = {"Raza", "Especie", "Height", "Width", ""};
//    Class[] types = new Class [] {
//                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
//            };

//    public synchronized static BreedsTableModel getInstance(){
//        if (breedsTableModel == null) {
//            breedsTableModel = new BreedsTableModel();
//        }
//        return breedsTableModel;
//    }
    public BreedsTableModel() {
        this.containerBreeds = new ArrayList<Breeds>();
    }

    public void insertDataModel(Breeds breed) {
        containerBreeds.add(breed);
        fireTableDataChanged();
        //System.out.println(ingredient.getNomIngredient());
    }

    @Override
    public int getRowCount() {
        int intReturn = 0;
        if (containerBreeds != null) {
            intReturn = containerBreeds.size();
        }
        return intReturn;
    }

    @Override
    public int getColumnCount() {
        return nameColumns.length;
    }

    @Override
    public String getColumnName(int column) {
        return nameColumns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String objectRetorn = "";
        Breeds breeds = containerBreeds.get(rowIndex);

        switch (columnIndex) {
            case 0:
                objectRetorn = breeds.getBreedsName();
                break;
            case 1:
                objectRetorn = breeds.getSpecie().getSpeciesName();
                break;
            case 2:
                objectRetorn = String.valueOf(breeds.getHeight());
                break;
            case 3:
                objectRetorn = String.valueOf(breeds.getWidth());
                break;
        }

        return objectRetorn;
    }

//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
////        if (columnIndex == 4) {
////            return Boolean.class;
////        } else {
////            return getColumnClass(columnIndex);
////        }
//
//    }
}