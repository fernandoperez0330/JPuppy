package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerSpecies;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.models.BreedsTableModel;

import java.awt.Frame;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JComboBox;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class ManageSpecies extends JDialog implements FrameOption {

    BreedsTableModel breedsTableModel = new BreedsTableModel();

    public ManageSpecies() {
        initComponents();
        ControllerSpecies cs = new ControllerSpecies(this);

        btnAdd.addActionListener(cs);
        btnAdd.setActionCommand("Add");
        btnUpdate.addActionListener(cs);
        btnUpdate.setActionCommand("Update");
        btnSearch.addActionListener(cs);
        btnSearch.setActionCommand("Search");
        btnSave.addActionListener(cs);
        btnSave.setActionCommand("Save");
        btnRemove.addActionListener(cs);
        btnRemove.setActionCommand("Remove");
        btnCancel.addActionListener(cs);
        btnCancel.setActionCommand("Cancel");

        //tblBreeds.setModel(BreedsTableModel.getInstance());
        //tblBreeds.getModel().addTableModelListener(cs);

//        int vColIndex = 4;
//        TableColumn col = tblBreeds.getColumnModel().getColumn(vColIndex);
//        col.setCellRenderer(new MyTableCellRenderer());

//        //Llenar el JTable de los datos existentes
//        List<Breeds> list = new ControllerSpecies().getBreeds();
//        for (Breeds value : list) {
//            breedsTableModel.insertDataModel(value);
//            //System.out.println(value.getBreedsName());
//        }


        //BreedsTableModel BreedsTableModel = new BreedsTableModel().getInstance();
        this.setLocationRelativeTo(null);
        this.setTitle("Manage Species");
        this.setResizable(false);
    }

    //Acceso a los Actions Commands de los botones
    public String getActionCommandAdd() {
        return btnAdd.getActionCommand();
    }

    public String getActionCommandUpd() {
        return btnUpdate.getActionCommand();
    }

    public String getActionCommandSearch() {
        return btnSearch.getActionCommand();
    }

    public String getActionCommandSave() {
        return btnSave.getActionCommand();
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

        pnFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxNameBreeds = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBreeds = new javax.swing.JTable();
        pnButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CrudEntities");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("Nombre de la especie.:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("Grupo de razas.:");

        jComboBoxNameBreeds.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Aviar", "Bovina", "Canina", "Caprina", "Equina", "Exótica", "Felina", "Ovina", "Varias" }));

        tblBreeds.setModel(breedsTableModel);
        jScrollPane1.setViewportView(tblBreeds);

        javax.swing.GroupLayout pnFieldsLayout = new javax.swing.GroupLayout(pnFields);
        pnFields.setLayout(pnFieldsLayout);
        pnFieldsLayout.setHorizontalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(jComboBoxNameBreeds, 0, 352, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBoxNameBreeds, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));

        btnAdd.setIcon(new javax.swing.ImageIcon("src\\itla\\jpuppy\\resources\\add.png"));
        btnAdd.setFocusable(false);
        btnAdd.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAdd.setName("add"); // NOI18N
        pnButtons.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon("src\\itla\\jpuppy\\resources\\edit.png"));
        btnUpdate.setFocusable(false);
        btnUpdate.setName("update"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnButtons.add(btnUpdate);

        btnSearch.setIcon(new javax.swing.ImageIcon("src\\itla\\jpuppy\\resources\\find.png"));
        btnSearch.setFocusable(false);
        btnSearch.setName("search"); // NOI18N
        pnButtons.add(btnSearch);

        btnSave.setIcon(new javax.swing.ImageIcon("src\\itla\\jpuppy\\resources\\save.png"));
        btnSave.setFocusable(false);
        btnSave.setName("save"); // NOI18N
        pnButtons.add(btnSave);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    public JComboBox getjComboBoxNameBreeds() {
        return jComboBoxNameBreeds;
    }

    public void setjComboBoxNameBreeds(JComboBox jComboBoxNameBreeds) {
        this.jComboBoxNameBreeds = jComboBoxNameBreeds;
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox jComboBoxNameBreeds;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnFields;
    private javax.swing.JTable tblBreeds;
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
