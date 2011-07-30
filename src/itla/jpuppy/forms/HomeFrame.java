/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JHomeFrame.java
 *
 * Created on Jul 28, 2011, 8:07:30 PM
 */
package itla.jpuppy.forms;

import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.models.SearchingCtrlCustomers;
import itla.jpuppy.models.SearchingModel;
import itla.jpuppy.utils.Background;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author Guillermo Hdez
 */
public class HomeFrame extends javax.swing.JFrame implements FrameOption {

    /** Creates new form JHomeFrame */
    private JPanel background;
    private JPanel searching;
    private SearchingModel<Customers> modelSearching;
    private SearchingCtrlCustomers ctrlCustormers;

    public HomeFrame() {
        initComponents();
        background = new Background("src/itla/jpuppy/resources/logoJPuppy.png");
        background.setBounds(0, 0, this.getWidth(), this.getHeight());
        modelSearching = new SearchingModel<Customers>(new String[] {"Id","Name","Lastname","City"},new SearchingCtrlCustomers());
        searching = new JSearching(modelSearching);
        this.add(background);
        background.setLayout(new FlowLayout());
        background.add(searching);
        this.setTitle("JPuppy: Sistema de veterinaria");
        this.setIconImage(HomeFrame.icon.getImage());
        this.setPreferredSize(new Dimension(700, 700));
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnubHome = new javax.swing.JMenuBar();
        mnuAdministrator = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        mnuUsuarios = new javax.swing.JMenu();
        mnuAcerca = new javax.swing.JMenu();
        mnuiAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("JPuppy"); // NOI18N
        setResizable(false);

        mnuAdministrator.setText("Administrador");

        jMenuItem1.setText("Clientes");
        mnuAdministrator.add(jMenuItem1);

        jMenuItem2.setText("Pacientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuAdministrator.add(jMenuItem2);

        mnubHome.add(mnuAdministrator);

        mnuVentas.setText("Ventas");
        mnubHome.add(mnuVentas);

        mnuUsuarios.setText("Usuarios");
        mnubHome.add(mnuUsuarios);

        mnuAcerca.setText("Ayuda");

        mnuiAcerca.setText("Acerca de...");
        mnuAcerca.add(mnuiAcerca);

        mnubHome.add(mnuAcerca);

        setJMenuBar(mnubHome);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ManagePatients managePatients = new ManagePatients(this,true);
        managePatients.showFrame();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu mnuAcerca;
    private javax.swing.JMenu mnuAdministrator;
    private javax.swing.JMenu mnuUsuarios;
    private javax.swing.JMenu mnuVentas;
    private javax.swing.JMenuBar mnubHome;
    private javax.swing.JMenuItem mnuiAcerca;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showFrame() {
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.setVisible(false);
    }
}
