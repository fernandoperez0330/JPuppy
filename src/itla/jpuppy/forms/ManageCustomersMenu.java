package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerCutomers;
import java.awt.Frame;
import javax.swing.JButton;

public class ManageCustomersMenu extends javax.swing.JDialog implements FrameOption {

    private JSearching searching;
    private ControllerCutomers ctrlCustormers;

    public ManageCustomersMenu(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        btnExit = new JButton();
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/cancel.png")));
        btnExit.setFocusable(false);
        pnButtons.add(btnExit);
        
        this.setLocationRelativeTo(null);
        this.setTitle("Administracion de Clientes");
        this.setResizable(false);
        
        ctrlCustormers = new ControllerCutomers(this);
        this.addWindowFocusListener(ctrlCustormers);
        searching.setBounds(54, 160, 786, 474);
        setListener();
        this.add(searching);
    }

    public void setSearching(JSearching searching) {
        this.searching = searching;
    }
    

    public JSearching getSearching() {
        return searching;
    }

    private void setListener() {
        searching.getTxtSearch().addKeyListener(ctrlCustormers);
        searching.getTblResult().addMouseListener(ctrlCustormers);

        btnAdd.addActionListener(ctrlCustormers);
        btnRemove.addActionListener(ctrlCustormers);
        btnUpdate.addActionListener(ctrlCustormers);
        btnExit.addActionListener(ctrlCustormers);
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
    private javax.swing.JButton btnExit;

    public JButton getBtnExit() {
        return btnExit;
    }
    
    @Override
    public void showFrame() {
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        dispose();
    }

    @Override
    public void dispose() {
        itla.jpuppy.business.EntityManagerCreator.close();
        super.dispose();
    }
}
