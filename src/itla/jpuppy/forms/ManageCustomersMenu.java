package itla.jpuppy.forms;

import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.controllers.ControllerCutomers;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.models.SearchingCtrlCustomers;
import itla.jpuppy.models.SearchingModel;
import java.awt.Frame;
import javax.swing.JButton;

public class ManageCustomersMenu extends javax.swing.JDialog implements FrameOption {

    private JSearching searching;
    private SearchingModel<Customers> modelSearching;
    private SearchingCtrlCustomers ctrlCustormers;
    private ModelCustomers mdlCustomers;
    private ControllerCutomers ctrlCustormersEntity;

    public ManageCustomersMenu(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Manage Customers");
        this.setResizable(false);
        modelSearching = new SearchingModel<Customers>(new String[]{"Id", "Name", "Lastname", "City"}, new SearchingCtrlCustomers());
        searching = new JSearching(modelSearching);
        mdlCustomers = new ModelCustomers();
        ctrlCustormersEntity = new ControllerCutomers(this);
        searching.setBounds(54, 160, 786, 474);
        setListener();
        this.add(searching);
    }

    public ModelCustomers getMdlCustomers() {
        return mdlCustomers;
    }

    public SearchingModel<Customers> getModelSearching() {
        return modelSearching;
    }

    public JSearching getSearching() {
        return searching;
    }

    private void setListener() {
        searching.getTxtSearch().addKeyListener(ctrlCustormersEntity);
        searching.getTblResult().addMouseListener(ctrlCustormersEntity);

        btnAdd.addActionListener(ctrlCustormersEntity);
        btnRemove.addActionListener(ctrlCustormersEntity);
        btnUpdate.addActionListener(ctrlCustormersEntity);
    }

    /** Creates new form NewJFrame */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CrudEntities");

        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/add.png"))); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnButtons.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/edit.png"))); // NOI18N
        btnUpdate.setFocusable(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnButtons.add(btnUpdate);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/remove.png"))); // NOI18N
        btnRemove.setFocusable(false);
        pnButtons.add(btnRemove);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(526, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel pnButtons;

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    // End of variables declaration//GEN-END:variables
    @Override
    public void showFrame() {
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.setVisible(false);
    }

    private void unload() {
        mdlCustomers.getQueryManager().getEntityManager().close();
    }

    @Override
    public void dispose() {
        super.dispose();
        unload();
    }
}
