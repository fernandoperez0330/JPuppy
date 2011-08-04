package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerEmployee;
import java.awt.Frame;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

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
public class ManageEmployeesEdit extends javax.swing.JDialog implements FrameOption {

    private ControllerEmployee ctrlUser;

    public ManageEmployeesEdit(Frame owner, boolean modal, ControllerEmployee ctrlUser) {
        super(owner, modal);
        this.ctrlUser = ctrlUser;
        initComponents();
        setListener();
        TxtFieldPhone.setValue(new String(" 809-000-0000"));
        TxtFieldCellPhone.setValue(new String(" 809-000-0000"));
        TxtFieldCedula.setValue(new String(" 032-0000000-1"));
        this.jRadioButtonNormal.setSelected(true);
        this.TxtFieldSpeciality.setVisible(false);
        this.lblSpeciality.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Manage Users");
        this.setResizable(false);
    }

    public void setFieldsValue(String TxtFieldCedula, String TxtFieldCellPhone, String TxtFieldJobPosition, String TxtFieldLastName, String TxtFieldName, String TxtFieldPhone, String typeUser) {
        this.TxtFieldCedula.setText(TxtFieldCedula);
        this.TxtFieldCellPhone.setText(TxtFieldCellPhone);
        this.TxtFieldJobPosition.setText(TxtFieldJobPosition);
        this.TxtFieldLastName.setText(TxtFieldLastName);
        this.TxtFieldName.setText(TxtFieldName);
        this.TxtFieldPhone.setText(TxtFieldPhone);
        
        if (typeUser.equalsIgnoreCase("Doctor")) {
            this.jRadioButtonDoctor.setSelected(true);
        } else {
            this.jRadioButtonNormal.setSelected(true);
        }
    }

    public void setFieldsValueDoctor(String TxtFieldCedula, String TxtFieldCellPhone, String TxtFieldJobPosition, String TxtFieldLastName, String TxtFieldName, String TxtFieldPhone, String TxtFieldSpeciality) {
        setFieldsValue(TxtFieldCedula,TxtFieldCellPhone,TxtFieldJobPosition,TxtFieldLastName,TxtFieldName,TxtFieldPhone,"Doctor");
        this.TxtFieldSpeciality.setText(TxtFieldSpeciality);
        this.TxtFieldSpeciality.setVisible(true);
        this.lblSpeciality.setVisible(true);
    }

    public void setListener() {
        btnCancel.addActionListener(ctrlUser);
        btnSave.addActionListener(ctrlUser);
        jRadioButtonNormal.addActionListener(ctrlUser);
        jRadioButtonDoctor.addActionListener(ctrlUser);
    }

    public JFormattedTextField getTxtFieldCedula() {
        return TxtFieldCedula;
    }

    public JFormattedTextField getTxtFieldCellPhone() {
        return TxtFieldCellPhone;
    }

    public JTextField getTxtFieldJobPosition() {
        return TxtFieldJobPosition;
    }

    public JTextField getTxtFieldLastName() {
        return TxtFieldLastName;
    }

    public JTextField getTxtFieldName() {
        return TxtFieldName;
    }

    public JFormattedTextField getTxtFieldPhone() {
        return TxtFieldPhone;
    }

    public JTextField getTxtFieldSpeciality() {
        return TxtFieldSpeciality;
    }

    public JRadioButton getjRadioButtonDoctor() {
        return jRadioButtonDoctor;
    }

    public JRadioButton getjRadioButtonNormal() {
        return jRadioButtonNormal;
    }

    public JLabel getLblSpeciality() {
        return lblSpeciality;
    }

    public JPanel getPnFields() {
        return pnFields;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    /** Creates new form NewJFrame */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTypeUser = new javax.swing.ButtonGroup();
        pnFields = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtFieldLastName = new javax.swing.JTextField();
        TxtFieldName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButtonDoctor = new javax.swing.JRadioButton();
        jRadioButtonNormal = new javax.swing.JRadioButton();
        try{
            TxtFieldPhone = new javax.swing.JFormattedTextField(new MaskFormatter(" ###-###-####"));
            TxtFieldCellPhone = new javax.swing.JFormattedTextField(new MaskFormatter(" ###-###-####"));
            try{
                TxtFieldCedula = new javax.swing.JFormattedTextField(new MaskFormatter(" ###-#######-#"));
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                lblSpeciality = new javax.swing.JLabel();
                TxtFieldJobPosition = new javax.swing.JTextField();
                TxtFieldSpeciality = new javax.swing.JTextField();
                pnButtons = new javax.swing.JPanel();
                btnSave = new javax.swing.JButton();
                btnCancel = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("CrudEntities");

                jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
                jLabel3.setText("Nombre.:");

                jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
                jLabel4.setText("Apellido.:");

                jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
                jLabel5.setText("Telefono.:");

                jLabel6.setFont(new java.awt.Font("Arial", 1, 14));
                jLabel6.setText("Tipo de Empleado.:");

                jLabel7.setFont(new java.awt.Font("Arial", 1, 14));
                jLabel7.setText("Celular.:");

                btnTypeUser.add(jRadioButtonDoctor);
                jRadioButtonDoctor.setFont(new java.awt.Font("Arial", 1, 14));
                jRadioButtonDoctor.setText("Doctor");
                jRadioButtonDoctor.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jRadioButtonDoctorActionPerformed(evt);
                    }
                });

                btnTypeUser.add(jRadioButtonNormal);
                jRadioButtonNormal.setFont(new java.awt.Font("Arial", 1, 14));
                jRadioButtonNormal.setText("Normal");

            }catch (Exception e){

            }

        }catch (Exception e){

        }

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel8.setText("Cedula.:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel9.setText("Cargo.:");

        lblSpeciality.setFont(new java.awt.Font("Arial", 1, 14));
        lblSpeciality.setText("Especialidad.:");

        javax.swing.GroupLayout pnFieldsLayout = new javax.swing.GroupLayout(pnFields);
        pnFields.setLayout(pnFieldsLayout);
        pnFieldsLayout.setHorizontalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFieldsLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(85, 85, 85)
                                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                                    .addComponent(TxtFieldLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFieldsLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel8)
                                .addGap(85, 85, 85)
                                .addComponent(TxtFieldCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                            .addGroup(pnFieldsLayout.createSequentialGroup()
                                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnFieldsLayout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(jLabel9))
                                    .addGroup(pnFieldsLayout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5))))
                                .addGap(85, 85, 85)
                                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TxtFieldJobPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                                    .addComponent(TxtFieldCellPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                                    .addComponent(TxtFieldPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)))
                            .addGroup(pnFieldsLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(85, 85, 85)
                                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtFieldSpeciality, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                    .addGroup(pnFieldsLayout.createSequentialGroup()
                                        .addComponent(jRadioButtonDoctor)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonNormal)
                                        .addGap(238, 238, 238))))))
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lblSpeciality)))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldCellPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtFieldJobPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButtonDoctor)
                    .addComponent(jRadioButtonNormal))
                .addGap(9, 9, 9)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpeciality)
                    .addComponent(TxtFieldSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/save.png"))); // NOI18N
        btnSave.setFocusable(false);
        pnButtons.add(btnSave);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/cancel.png"))); // NOI18N
        btnCancel.setFocusable(false);
        pnButtons.add(btnCancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonDoctorActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField TxtFieldCedula;
    private javax.swing.JFormattedTextField TxtFieldCellPhone;
    private javax.swing.JTextField TxtFieldJobPosition;
    private javax.swing.JTextField TxtFieldLastName;
    private javax.swing.JTextField TxtFieldName;
    private javax.swing.JFormattedTextField TxtFieldPhone;
    private javax.swing.JTextField TxtFieldSpeciality;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup btnTypeUser;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButtonDoctor;
    private javax.swing.JRadioButton jRadioButtonNormal;
    private javax.swing.JLabel lblSpeciality;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnFields;
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
