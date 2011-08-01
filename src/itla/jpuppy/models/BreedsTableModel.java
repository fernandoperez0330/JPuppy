package itla.jpuppy.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

//Modelo de agregado de Breeds
public class BreedsTableModel extends AbstractTableModel{
    
    private static BreedsTableModel breedsTableModel;
    ArrayList<Breed> containerBreeds;

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public synchronized static BreedsTableModel getInstance(){
        if (breedsTableModel == null) {
            breedsTableModel = new BreedsTableModel();
        }
        return breedsTableModel;
    }    

}