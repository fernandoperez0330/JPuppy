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
import itla.jpuppy.utils.RestrictionSLength;
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
        txtSearch.setDocument(new RestrictionSLength(txtSearch, 60));
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

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        spnResult.setViewportView(tblResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnResult, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnResult, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane spnResult;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
