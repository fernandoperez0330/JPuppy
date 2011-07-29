package itla.jpuppy.forms;
import java.awt.Frame;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Jul 25, 2011, 1:32:21 AM
 */

/**
 *
 * @author Adderly
 */
public class ManageSpecies extends javax.swing.JDialog implements FrameOption{

    public ManageSpecies(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Manage Users");
        this.setResizable(false);
    }

   

    /** Creates new form NewJFrame */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtFieldEspecie = new javax.swing.JTextField();
        jComboBoxNameBreeds = new javax.swing.JComboBox();
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
        jLabel1.setText("Nombre de la raza.:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("Nombre de la especie.:");

        jComboBoxNameBreeds.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnFieldsLayout = new javax.swing.GroupLayout(pnFields);
        pnFields.setLayout(pnFieldsLayout);
        pnFieldsLayout.setHorizontalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(85, 85, 85)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxNameBreeds, 0, 356, Short.MAX_VALUE)
                    .addComponent(TxtFieldEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxNameBreeds, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtFieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/image/add.png"))); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnButtons.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/image/edit.png"))); // NOI18N
        btnUpdate.setFocusable(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnButtons.add(btnUpdate);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/image/find.png"))); // NOI18N
        btnSearch.setFocusable(false);
        pnButtons.add(btnSearch);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/image/save.png"))); // NOI18N
        btnSave.setFocusable(false);
        pnButtons.add(btnSave);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/image/remove.png"))); // NOI18N
        btnRemove.setFocusable(false);
        pnButtons.add(btnRemove);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/image/cancel.png"))); // NOI18N
        btnCancel.setFocusable(false);
        pnButtons.add(btnCancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
            .addGap(0, 880, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
            .addGap(0, 652, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnUpdateActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageSpecies(null,true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtFieldEspecie;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox jComboBoxNameBreeds;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnFields;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showFrame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void closeFrame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
