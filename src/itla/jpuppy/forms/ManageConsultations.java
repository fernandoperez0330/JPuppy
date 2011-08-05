package itla.jpuppy.forms;
//import itla.jpuppy.controllers.ControllerConsultations;
import datechooser.beans.DateChooserCombo;
import itla.jpuppy.controllers.ControllerConsultations;
import itla.jpuppy.utils.TypeConsultations;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ManageConsultations extends javax.swing.JDialog implements FrameOption {

    

    public ManageConsultations(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ControllerConsultations controlConsultations = new ControllerConsultations(this);
 
        btnAddConsultations.addActionListener(controlConsultations);
        btnCancelConsultations.addActionListener(controlConsultations);
        btnRemoveConsultations.addActionListener(controlConsultations);
        btnSaveConsultations.addActionListener(controlConsultations);
        btnSearchConsultations.addActionListener(controlConsultations);
        btnUpdateConsultations.addActionListener(controlConsultations);

        btnAddConsultations.setActionCommand("addConsultation");
        btnCancelConsultations.setActionCommand("cancelConsultation");
        btnRemoveConsultations.setActionCommand("removeConsultation");
        btnSaveConsultations.setActionCommand("saveConsultation");
        btnSearchConsultations.setActionCommand("searchConsultation");
        btnUpdateConsultations.setActionCommand("updateConsultation");
                     
        dateChooserBeginConsultations.setDateFormat(new SimpleDateFormat("dd-MMM-yyyy"));   
        dateChooserEndConsultations.setDateFormat(new SimpleDateFormat("dd-MMM-yyyy"));         
        

        cbTypeConsultations.setModel(new DefaultComboBoxModel(TypeConsultations.values()));

        this.setLocationRelativeTo(null);
        this.setTitle("Manejador de consultas");
        this.setResizable(false);
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
        dateChooserBeginConsultations = new datechooser.beans.DateChooserCombo();
        dateChooserEndConsultations = new datechooser.beans.DateChooserCombo();
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

        cbTypeConsultations.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        cbTypeConsultations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeConsultationsActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel3.setText("Y");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setText("Observacion:");

        cbCustomerConsultations.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel5.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel6.setText("Paciente:");

        cbPatientConsultations.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        cbPatientConsultations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPatientConsultationsActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserBeginConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(dateChooserEndConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(cbTypeConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(cbCustomerConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(cbPatientConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRemarkConsultations)))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnFieldsLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnFieldsLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel6))
                                    .addComponent(dateChooserBeginConsultations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCustomerConsultations)
                                    .addComponent(cbPatientConsultations)
                                    .addComponent(jLabel1)))
                            .addGroup(pnFieldsLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserEndConsultations, 0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))))
                        .addGap(12, 12, 12))
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)))
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtRemarkConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTypeConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(42, 42, 42))
        );

        getContentPane().add(pnFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 880, 120));

        pnButtons3.setLayout(null);

        btnAddConsultations.setIcon(new javax.swing.ImageIcon(FrameOption.dirResources+"add.png"));
        btnAddConsultations.setFocusable(false);
        //btnAddConsultations.setContentAreaFilled( false );
        btnAddConsultations.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAddConsultations.setName("add"); // NOI18N
        pnButtons3.add(btnAddConsultations);
        btnAddConsultations.setBounds(60, 20, 110, 50);

        btnUpdateConsultations.setIcon(new javax.swing.ImageIcon(FrameOption.dirResources+"edit.png"));
        btnUpdateConsultations.setFocusable(false);
        //btnUpdateConsultations.setContentAreaFilled( false );
        btnUpdateConsultations.setName("update"); // NOI18N
        pnButtons3.add(btnUpdateConsultations);
        btnUpdateConsultations.setBounds(460, 20, 110, 50);

        btnSearchConsultations.setIcon(new javax.swing.ImageIcon(FrameOption.dirResources+"find.png"));
        btnSearchConsultations.setFocusable(false);
        //btnSearchConsultations.setContentAreaFilled( false );
        btnSearchConsultations.setName("search"); // NOI18N
        pnButtons3.add(btnSearchConsultations);
        btnSearchConsultations.setBounds(580, 20, 110, 50);

        btnSaveConsultations.setIcon(new javax.swing.ImageIcon(FrameOption.dirResources+"save.png"));
        btnSaveConsultations.setFocusable(false);
        //btnSaveConsultations.setContentAreaFilled( false );
        btnSaveConsultations.setName("save"); // NOI18N
        pnButtons3.add(btnSaveConsultations);
        btnSaveConsultations.setBounds(190, 20, 120, 50);

        btnRemoveConsultations.setIcon(null);
        btnRemoveConsultations.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/remove.png"));
        btnRemoveConsultations.setFocusable(false);
        //btnRemoveConsultations.setContentAreaFilled( false );
        btnRemoveConsultations.setName("remove"); // NOI18N
        pnButtons3.add(btnRemoveConsultations);
        btnRemoveConsultations.setBounds(330, 20, 110, 50);

        btnCancelConsultations.setIcon(new javax.swing.ImageIcon(FrameOption.dirResources+"cancel.png"));
        btnCancelConsultations.setFocusable(false);
        //btnCancelConsultations.setContentAreaFilled( false );
        btnCancelConsultations.setName("cancel"); // NOI18N
        pnButtons3.add(btnCancelConsultations);
        btnCancelConsultations.setBounds(700, 20, 120, 50);

        getContentPane().add(pnButtons3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 880, 90));

        tableConsultations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableConsultations);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 880, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPatientConsultationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPatientConsultationsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPatientConsultationsActionPerformed

    private void cbTypeConsultationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeConsultationsActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_cbTypeConsultationsActionPerformed

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
    private datechooser.beans.DateChooserCombo dateChooserBeginConsultations;
    private datechooser.beans.DateChooserCombo dateChooserEndConsultations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnButtons3;
    private javax.swing.JPanel pnFields;
    private javax.swing.JTable tableConsultations;
    private javax.swing.JTextField txtRemarkConsultations;
    // End of variables declaration//GEN-END:variables

    public DateChooserCombo getDateChooserBeginConsultations() {
        return dateChooserBeginConsultations;
    }

    public DateChooserCombo getDateChooserEndConsultations() {
        return dateChooserEndConsultations;
    }

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
