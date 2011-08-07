package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerSpecies;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.models.BreedsTableModel;
//import itla.jpuppy.models.EditorTable;
import java.awt.Frame;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JComboBox;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class ManageSpecies extends JDialog implements FrameOption {

    BreedsTableModel breedsTableModel = new BreedsTableModel();
    private List<Breeds> list;

    public List<Breeds> getList() {
        return list;
    }
    
    public ManageSpecies(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        ControllerSpecies cs = new ControllerSpecies(this);

        btnAdd.addActionListener(cs);
        btnAdd.setActionCommand("Add");
        btnSearch.addActionListener(cs);
        btnSearch.setActionCommand("Search");
        btnRemove.addActionListener(cs);
        btnRemove.setActionCommand("Remove");
        btnRemove.setEnabled(false);
        btnCancel.addActionListener(cs);
        btnCancel.setActionCommand("Cancel");

        //tblBreeds.setModel(BreedsTableModel.getInstance());
        //tblBreeds.getModel().addTableModelListener(cs);

//        int vColIndex = 4;
//        TableColumn col = tblBreeds.getColumnModel().getColumn(vColIndex);
//        col.setCellRenderer(new MyTableCellRenderer());

        //Llenar el JTable de los datos existentes
//         list = new ControllerSpecies().getBreeds();
//        DefaultTableModel temp = (DefaultTableModel) tblBreeds.getModel();
//        for (Breeds value : list) {
//            Object[] nuevo = {value.getBreedsName(), value.getSpecie().getSpeciesName(), value.getWidth(), value.getHeight()};
//            //System.out.println(value.getBreedsName());
//            temp.addRow(nuevo);
//        }
//        
        //EditorTable miRender = new EditorTable();
        //tblBreeds.setDefaultRenderer(Boolean.class, miRender);

        
        //BreedsTableModel BreedsTableModel = new BreedsTableModel().getInstance();
        this.setLocationRelativeTo(null);
        this.setTitle("Manejador de  especies");
        this.setResizable(false);
    }

    //Acceso a los Actions Commands de los botones
    public String getActionCommandAdd() {
        return btnAdd.getActionCommand();
    }
    public String getActionCommandSearch() {
        return btnSearch.getActionCommand();
    }

    public String getActionCommandRemove() {
        return btnRemove.getActionCommand();
    }

    public String getActionCommandCancel() {
        return btnCancel.getActionCommand();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CrudEntities");

        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));

        btnAdd.setIcon(new javax.swing.ImageIcon("src\\itla\\jpuppy\\resources\\add.png"));
        btnAdd.setFocusable(false);
        btnAdd.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAdd.setName("add"); // NOI18N
        pnButtons.add(btnAdd);

        btnSearch.setIcon(new javax.swing.ImageIcon("src\\itla\\jpuppy\\resources\\find.png"));
        btnSearch.setFocusable(false);
        btnSearch.setName("search"); // NOI18N
        pnButtons.add(btnSearch);

        btnRemove.setIcon(new javax.swing.ImageIcon("src\\itla\\jpuppy\\resources\\remove.png"));
        btnRemove.setFocusable(false);
        btnRemove.setName("remove"); // NOI18N
        pnButtons.add(btnRemove);

        btnCancel.setIcon(new javax.swing.ImageIcon("src\\itla\\jpuppy\\resources\\cancel.png"));
        btnCancel.setFocusable(false);
        btnCancel.setName("cancel"); // NOI18N
        pnButtons.add(btnCancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel pnButtons;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showFrame() {
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.dispose();
    }
}
