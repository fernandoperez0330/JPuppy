package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerUser;
import java.awt.Frame;
import javax.swing.JButton;

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
public class ManageUsersMenu extends javax.swing.JDialog implements FrameOption {

    private JSearching searching;
    private ControllerUser ctrlUser;

    public ManageUsersMenu(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Administracion de Usuarios");
        this.setResizable(false);

        ctrlUser = new ControllerUser(this);
        this.addWindowFocusListener(ctrlUser);
        searching.setBounds(54, 90, 786, 474);
        setListener();
        this.add(searching);
    }

    private void setListener() {
        searching.getTxtSearch().addKeyListener(ctrlUser);
        searching.getTblResult().addMouseListener(ctrlUser);

        btnAdd.addActionListener(ctrlUser);
        btnRemove.addActionListener(ctrlUser);
        btnUpdate.addActionListener(ctrlUser);
        getBtnExit.addActionListener(ctrlUser);
    }

    public void setSearching(JSearching searching) {
        this.searching = searching;
    }
    
    public JSearching getSearching() {
        return searching;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnExit() {
        return getBtnExit;
    }
    
    
    
    /** Creates new form NewJFrame */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        getBtnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CrudEntities");

        pnButtons.setLayout(null);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/add.png"))); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnButtons.add(btnAdd);
        btnAdd.setBounds(230, 0, 110, 50);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/edit.png"))); // NOI18N
        btnUpdate.setFocusable(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnButtons.add(btnUpdate);
        btnUpdate.setBounds(350, 0, 110, 50);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/remove.png"))); // NOI18N
        btnRemove.setFocusable(false);
        pnButtons.add(btnRemove);
        btnRemove.setBounds(470, 0, 110, 50);

        getBtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/cancel.png"))); // NOI18N
        getBtnExit.setFocusable(false);
        pnButtons.add(getBtnExit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(435, Short.MAX_VALUE))
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton getBtnExit;
    private javax.swing.JPanel pnButtons;
    // End of variables declaration//GEN-END:variables

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
