package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerUser;
import java.awt.Frame;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
public class ManageUsersEdit extends javax.swing.JDialog implements FrameOption {

    private ControllerUser ctrlUser;

    public ManageUsersEdit(Frame owner, boolean modal, ControllerUser ctrlUser) {
        super(owner, modal);
        this.ctrlUser = ctrlUser;
        initComponents();
        setListener();
        TxtFieldPhone.setValue(new String(" 809-000-0000"));
        TxtFieldCellPhone.setValue(new String(" 809-000-0000"));
        this.setLocationRelativeTo(null);
        this.setTitle("Manage Users");
        this.setResizable(false);

    }

    public void setFieldsValue(String TxtFieldApellido, String TxtFieldCellPhone, String TxtFieldName, String TxtFieldNameUser, String TxtFieldPassword, String TxtFieldPhone, String typeUser) {
        this.TxtFieldApellido.setText(TxtFieldApellido);
        this.TxtFieldCellPhone.setText(TxtFieldCellPhone);
        this.TxtFieldName.setText(TxtFieldName);
        this.TxtFieldNameUser.setText(TxtFieldNameUser);
        this.TxtFieldPassword.setText(TxtFieldPassword);
        this.TxtFieldPhone.setText(TxtFieldPhone);
        if (typeUser.equalsIgnoreCase("Administrador")) {
            this.jRadioButtonAdministrador.setSelected(true);
        } else {
            this.jRadioButtonOperador.setSelected(true);
        }
    }

    public void setListener() {
        btnCancel.addActionListener(ctrlUser);
        btnSave.addActionListener(ctrlUser);
    }

    public JTextField getTxtFieldApellido() {
        return TxtFieldApellido;
    }

    public JFormattedTextField getTxtFieldCellPhone() {
        return TxtFieldCellPhone;
    }

    public JTextField getTxtFieldName() {
        return TxtFieldName;
    }

    public JTextField getTxtFieldNameUser() {
        return TxtFieldNameUser;
    }

    public JPasswordField getTxtFieldPassword() {
        return TxtFieldPassword;
    }

    public JFormattedTextField getTxtFieldPhone() {
        return TxtFieldPhone;
    }

    public JRadioButton getjRadioButtonAdministrador() {
        return jRadioButtonAdministrador;
    }

    public JRadioButton getjRadioButtonOperador() {
        return jRadioButtonOperador;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtFieldNameUser = new javax.swing.JTextField();
        TxtFieldApellido = new javax.swing.JTextField();
        TxtFieldName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButtonAdministrador = new javax.swing.JRadioButton();
        jRadioButtonOperador = new javax.swing.JRadioButton();
        TxtFieldPassword = new javax.swing.JPasswordField();
        try{
            TxtFieldPhone = new javax.swing.JFormattedTextField(new MaskFormatter(" ###-###-####"));
            TxtFieldCellPhone = new javax.swing.JFormattedTextField(new MaskFormatter(" ###-###-####"));
            pnButtons = new javax.swing.JPanel();
            btnSave = new javax.swing.JButton();
            btnCancel = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("CrudEntities");

            jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
            jLabel1.setText("Nombre de usario.:");

            jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
            jLabel2.setText("Password.:");

            jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
            jLabel3.setText("Nombre.:");

            jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
            jLabel4.setText("Apellido.:");

            jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
            jLabel5.setText("Telefono.:");

            jLabel6.setFont(new java.awt.Font("Arial", 1, 14));
            jLabel6.setText("Tipo de usuario.:");

            jLabel7.setFont(new java.awt.Font("Arial", 1, 14));
            jLabel7.setText("Celular.:");

            btnTypeUser.add(jRadioButtonAdministrador);
            jRadioButtonAdministrador.setFont(new java.awt.Font("Arial", 1, 14));
            jRadioButtonAdministrador.setText("Administrador");
            jRadioButtonAdministrador.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButtonAdministradorActionPerformed(evt);
                }
            });

            btnTypeUser.add(jRadioButtonOperador);
            jRadioButtonOperador.setFont(new java.awt.Font("Arial", 1, 14));
            jRadioButtonOperador.setText("Operador");

        }catch (Exception e){

        }

        javax.swing.GroupLayout pnFieldsLayout = new javax.swing.GroupLayout(pnFields);
        pnFields.setLayout(pnFieldsLayout);
        pnFieldsLayout.setHorizontalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(85, 85, 85)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtFieldCellPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(TxtFieldPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(TxtFieldNameUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(TxtFieldApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(TxtFieldName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnFieldsLayout.createSequentialGroup()
                        .addComponent(jRadioButtonAdministrador)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonOperador))
                    .addComponent(TxtFieldPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtFieldNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtFieldCellPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButtonAdministrador)
                    .addComponent(jRadioButtonOperador))
                .addContainerGap(61, Short.MAX_VALUE))
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAdministradorActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtFieldApellido;
    private javax.swing.JFormattedTextField TxtFieldCellPhone;
    private javax.swing.JTextField TxtFieldName;
    private javax.swing.JTextField TxtFieldNameUser;
    private javax.swing.JPasswordField TxtFieldPassword;
    private javax.swing.JFormattedTextField TxtFieldPhone;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup btnTypeUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButtonAdministrador;
    private javax.swing.JRadioButton jRadioButtonOperador;
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
