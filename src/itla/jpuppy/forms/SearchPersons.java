/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SearchPersons.java
 *
 * Created on 06-ago-2011, 20:42:38
 */
package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerSearchPersons;
import itla.jpuppy.datalayer.Persons;

/**
 *
 * @author Jordhano
 */
public class SearchPersons extends javax.swing.JDialog implements FrameOption {

    private itla.jpuppy.datalayer.Persons temp;
    private JSearching searching;
    private ControllerSearchPersons ctrlSeach;

    /** Creates new form SearchPersons */
    public SearchPersons(javax.swing.JDialog parent, boolean modal, itla.jpuppy.business.QueryManager queryManager, int filter) {
        super(parent, modal);
        initComponents();
        ctrlSeach = new ControllerSearchPersons(this, queryManager,filter);
        searching.setBounds(0, 0, 786, 474);
        this.add(searching);
        this.setTitle("Seleccionar Persona A Cargar");
        this.setSize(793, 488);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setListener();
    }

    public void setPerson(Persons temp) {
        this.temp = temp;
    }
    
    
    
    private void setListener() {
        searching.getTxtSearch().addKeyListener(ctrlSeach);
        searching.getTblResult().addMouseListener(ctrlSeach);
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
            .addGap(0, 603, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
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

    public itla.jpuppy.datalayer.Persons personShowSearch() {
        this.setVisible(true);
        return temp;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
    
    
}
