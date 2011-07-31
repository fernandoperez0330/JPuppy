/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JSearching.java
 *
 * Created on 27-jul-2011, 1:49:28
 */
package itla.jpuppy.forms;

import itla.jpuppy.models.SearchingModel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Jordhano
 */
public class JSearching extends javax.swing.JPanel {

    private SearchingModel model;

    /** Creates new form JSearching */
    public JSearching(SearchingModel model) {
        initComponents();
        this.model = model;
        tblResult.setModel(model);
        txtSearch.setName("txtSearch");
    }
    

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public JTable getTblResult() {
        return tblResult;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        spnResult = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        spnResult.setViewportView(tblResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spnResult, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnResult, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane spnResult;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
