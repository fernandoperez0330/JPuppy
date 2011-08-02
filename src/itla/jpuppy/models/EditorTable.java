package itla.jpuppy.models;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableCellRenderer;

public class EditorTable extends JCheckBox implements TableCellRenderer {
    JCheckBox check = new JCheckBox();
    public EditorTable() {
        
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        check.setVisible(true);
        check.setSelected(false);
        if (value instanceof Boolean) {
            return check;
        } else {
            return null;
        }
        
    }
}