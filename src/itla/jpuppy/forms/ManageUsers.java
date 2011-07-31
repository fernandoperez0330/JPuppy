package itla.jpuppy.forms;
import java.awt.Frame;

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
public class ManageUsers extends javax.swing.JDialog implements FrameOption{

    public ManageUsers(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Manage Users");
        this.setResizable(false);
        
    }

   

    /** Creates new form NewJFrame */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtFieldNombreUsuario = new javax.swing.JTextField();
        TxtFieldApellido = new javax.swing.JTextField();
        TxtFieldPassword = new javax.swing.JTextField();
        TxtFieldName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtFieldCelular = new javax.swing.JTextField();
        TxtFieldTelefono = new javax.swing.JTextField();
        jRadioButtonAdministrador = new javax.swing.JRadioButton();
        jRadioButtonOperador = new javax.swing.JRadioButton();
        pnButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
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

        jRadioButtonAdministrador.setFont(new java.awt.Font("Arial", 1, 14));
        jRadioButtonAdministrador.setText("Administrador");
        jRadioButtonAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAdministradorActionPerformed(evt);
            }
        });

        jRadioButtonOperador.setFont(new java.awt.Font("Arial", 1, 14));
        jRadioButtonOperador.setText("Operador");

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
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtFieldNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(TxtFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(TxtFieldApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(TxtFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(TxtFieldTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(TxtFieldCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addGroup(pnFieldsLayout.createSequentialGroup()
                        .addComponent(jRadioButtonAdministrador)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonOperador)))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
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
                    .addComponent(TxtFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButtonAdministrador)
                    .addComponent(jRadioButtonOperador))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/add.png"))); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnButtons.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/edit.png"))); // NOI18N
        btnUpdate.setFocusable(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnButtons.add(btnUpdate);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/find.png"))); // NOI18N
        btnSearch.setFocusable(false);
        pnButtons.add(btnSearch);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/save.png"))); // NOI18N
        btnSave.setFocusable(false);
        pnButtons.add(btnSave);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/remove.png"))); // NOI18N
        btnRemove.setFocusable(false);
        pnButtons.add(btnRemove);

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
                        .addGap(142, 142, 142)
                        .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnUpdateActionPerformed

    private void jRadioButtonAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAdministradorActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtFieldApellido;
    private javax.swing.JTextField TxtFieldCelular;
    private javax.swing.JTextField TxtFieldName;
    private javax.swing.JTextField TxtFieldNombreUsuario;
    private javax.swing.JTextField TxtFieldPassword;
    private javax.swing.JTextField TxtFieldTelefono;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
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
