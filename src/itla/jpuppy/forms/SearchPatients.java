/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SearchPatients.java
 *
 * Created on 02-ago-2011, 3:29:49
 */
package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerCutomers;
import itla.jpuppy.datalayer.Patients;
import java.awt.FlowLayout;

/**
 *
 * @author Jordhano
 */
public class SearchPatients extends javax.swing.JDialog implements FrameOption{

    private JSearching searching;
    private ControllerCutomers ctrlCustomers;

    public SearchPatients(java.awt.Frame parent, boolean modal, JSearching searching, ControllerCutomers ctrlCustomers) {
        super(parent, modal);
        initComponents();
        this.searching = searching;
        this.ctrlCustomers = ctrlCustomers;
        this.setLocationRelativeTo(null);
        this.setTitle("Select Patients");
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.add(searching);
        setListenerCtrlCustomers();

    }

    private void setListenerCtrlCustomers() {
        searching.getTxtSearch().addKeyListener(ctrlCustomers);
        searching.getTblResult().addMouseListener(ctrlCustomers);
    }

    public JSearching getSearching() {
        return searching;
    }

    public void setSearching(JSearching searching) {
        this.searching = searching;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
