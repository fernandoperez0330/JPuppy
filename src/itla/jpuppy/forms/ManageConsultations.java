package itla.jpuppy.forms;
//import itla.jpuppy.controllers.ControllerConsultations;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
public class ManageConsultations extends javax.swing.JDialog  implements FrameOption{

   
    public ManageConsultations(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //ControllerConsultations controlConsultations = new ControllerConsultations();

/*        btnAddConsultations.addActionListener(controlConsultations);
        btnCancelConsultations.addActionListener(controlConsultations);
        btnRemoveConsultations.addActionListener(controlConsultations);
        btnSaveConsultations.addActionListener(controlConsultations);
        btnSearchConsultations.addActionListener(controlConsultations);
        btnUpdateConsultations.addActionListener(controlConsultations);*/
        btnAddConsultations.setActionCommand("addConsultation");
        btnCancelConsultations.setActionCommand("cancelConsultation");
        btnRemoveConsultations.setActionCommand("removeConsultation");
        btnSaveConsultations.setActionCommand("saveConsultation");
        btnSearchConsultations.setActionCommand("searchConsultation");
        btnUpdateConsultations.setActionCommand("updateConsultation");
  }
        //getter ActionCommand
        public String getActionCommandAdd() {
        return btnAddConsultations.getActionCommand();
    }

        public String getActionCommandUpd() {
        return btnUpdateConsultations.getActionCommand();
    }

        public String getActionCommandSearch() {
        return btnSearchConsultations.getActionCommand();
    }

        public String getActionCommandSave() {
        return btnSaveConsultations.getActionCommand();
    }

        public String getActionCommandRemove() {
        return btnRemoveConsultations.getActionCommand();
    }

        public String getActionCommandCancel() {
        return btnCancelConsultations.getActionCommand();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTypeConsultations = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbCustomerConsultations = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbPatientConsultations = new javax.swing.JComboBox();
        txtRemarkConsultations = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnButtons3 = new javax.swing.JPanel();
        btnAddConsultations = new javax.swing.JButton();
        btnUpdateConsultations = new javax.swing.JButton();
        btnSearchConsultations = new javax.swing.JButton();
        btnSaveConsultations = new javax.swing.JButton();
        btnRemoveConsultations = new javax.swing.JButton();
        btnCancelConsultations = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableConsultations = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manejador De Consultas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnFields.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("Entre La Fecha:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("Tipo De Consulta:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel3.setText("Y");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setText("Observacion:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel5.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel6.setText("Paciente:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFieldsLayout = new javax.swing.GroupLayout(pnFields);
        pnFields.setLayout(pnFieldsLayout);
        pnFieldsLayout.setHorizontalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(cbTypeConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCustomerConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(cbPatientConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRemarkConsultations)))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnFieldsLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel1))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbCustomerConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnFieldsLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel6))
                            .addComponent(cbPatientConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)))
                .addGap(12, 12, 12)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRemarkConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(cbTypeConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        getContentPane().add(pnFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 166, 845, 100));

        pnButtons3.setLayout(new java.awt.GridLayout(1, 0, 6, 8));

        btnAddConsultations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/add.png"))); // NOI18N
        btnAddConsultations.setFocusable(false);
        btnAddConsultations.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAddConsultations.setName("add"); // NOI18N
        pnButtons3.add(btnAddConsultations);

        btnUpdateConsultations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/edit.png"))); // NOI18N
        btnUpdateConsultations.setFocusable(false);
        btnUpdateConsultations.setName("update"); // NOI18N
        pnButtons3.add(btnUpdateConsultations);

        btnSearchConsultations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/find.png"))); // NOI18N
        btnSearchConsultations.setFocusable(false);
        btnSearchConsultations.setName("search"); // NOI18N
        pnButtons3.add(btnSearchConsultations);

        btnSaveConsultations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/save.png"))); // NOI18N
        btnSaveConsultations.setFocusable(false);
        btnSaveConsultations.setName("save"); // NOI18N
        pnButtons3.add(btnSaveConsultations);

        btnRemoveConsultations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/remove.png"))); // NOI18N
        btnRemoveConsultations.setFocusable(false);
        btnRemoveConsultations.setName("remove"); // NOI18N
        pnButtons3.add(btnRemoveConsultations);

        btnCancelConsultations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/cancel.png"))); // NOI18N
        btnCancelConsultations.setFocusable(false);
        btnCancelConsultations.setName("cancel"); // NOI18N
        pnButtons3.add(btnCancelConsultations);

        getContentPane().add(pnButtons3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 885, 120));

        tableConsultations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableConsultations);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 284, 845, 143));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddConsultations;
    private javax.swing.JButton btnCancelConsultations;
    private javax.swing.JButton btnRemoveConsultations;
    private javax.swing.JButton btnSaveConsultations;
    private javax.swing.JButton btnSearchConsultations;
    private javax.swing.JButton btnUpdateConsultations;
    private javax.swing.JComboBox cbCustomerConsultations;
    private javax.swing.JComboBox cbPatientConsultations;
    private javax.swing.JComboBox cbTypeConsultations;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel pnButtons3;
    private javax.swing.JPanel pnFields;
    private javax.swing.JTable tableConsultations;
    private javax.swing.JTextField txtRemarkConsultations;
    // End of variables declaration//GEN-END:variables

    //Demas getters y setters
   /* public JComboBox getCbBeginDateConsultations() {
        return cbBeginDateConsultations;
    }

    public void setCbBeginDateConsultations(JComboBox cbBeginDateConsultations) {
        this.cbBeginDateConsultations = cbBeginDateConsultations;
    }*/

    public JComboBox getCbCustomerConsultations() {
        return cbCustomerConsultations;
    }

    public void setCbCustomerConsultations(JComboBox cbCustomerConsultations) {
        this.cbCustomerConsultations = cbCustomerConsultations;
    }
 /*
    public JComboBox getCbEndDateConsultations() {
        return cbEndDateConsultations;
    }

    public void setCbEndDateConsultations(JComboBox cbEndDateConsultations) {
        this.cbEndDateConsultations = cbEndDateConsultations;
    } */

    public JComboBox getCbPatientConsultations() {
        return cbPatientConsultations;
    }

    public void setCbPatientConsultations(JComboBox cbPatientConsultations) {
        this.cbPatientConsultations = cbPatientConsultations;
    }

    public JComboBox getCbTypeConsultations() {
        return cbTypeConsultations;
    }

    public void setCbTypeConsultations(JComboBox cbTypeConsultations) {
        this.cbTypeConsultations = cbTypeConsultations;
    }

    public JTable getTableConsultations() {
        return tableConsultations;
    }

    public void setTableConsultations(JTable tableConsultations) {
        this.tableConsultations = tableConsultations;
    }

    public JTextField getTxtRemarkConsultations() {
        return txtRemarkConsultations;
    }

    public void setTxtRemarkConsultations(JTextField txtRemarkConsultations) {
        this.txtRemarkConsultations = txtRemarkConsultations;
    }
//metodos de la interface
    @Override
    public void showFrame() {
        this.setVisible(true);

    }

    @Override
    public void closeFrame() {
        this.dispose();
    }

}
