package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerCutomers;
import itla.jpuppy.utils.RestrictionSLength;
import java.awt.Font;
import java.awt.Frame;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;

public class ManageCustomersEdit extends javax.swing.JDialog implements FrameOption {

    private ControllerCutomers ctrlCustormers;

    public ManageCustomersEdit(Frame owner, boolean modal, ControllerCutomers ctrlCustormers) {
        super(owner, modal);
        this.ctrlCustormers = ctrlCustormers;
        try {
            initComponents();
        } catch (ParseException ex) {
            Logger.getLogger(ManageCustomersEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        TxtFieldLastName.setDocument(new RestrictionSLength(TxtFieldLastName, 30));
        TxtFieldCity.setDocument(new RestrictionSLength(TxtFieldCity, 30));
        TxtFieldAdress.setDocument(new RestrictionSLength(TxtFieldAdress, 100));
        TxtFieldMail.setDocument(new RestrictionSLength(TxtFieldMail, 100));
        TxtFieldName.setDocument(new RestrictionSLength(TxtFieldName, 30));
        jTextAreaNote.setDocument(new RestrictionSLength(jTextAreaNote, 200));
        this.btnPerson.setVisible(false);
        setListener();

        pack();


        this.setLocationRelativeTo(null);
        this.setTitle("Administrando Cliente");
        this.setResizable(false);

    }

    public void setFieldsValue(String TxtFieldLastName, String TxtFieldCellphone, String TxtFieldCity, String TxtFieldAdress, String TxtFieldMail, String TxtFieldName, String TxtFieldPhone, String jTextAreaNote, String TxtFieldCedula) {
        this.TxtFieldLastName.setText(TxtFieldLastName);
        this.TxtFieldCellphone.setText(TxtFieldCellphone);
        this.TxtFieldCity.setText(TxtFieldCity);
        this.TxtFieldAdress.setText(TxtFieldAdress);
        this.TxtFieldMail.setText(TxtFieldMail);
        this.TxtFieldName.setText(TxtFieldName);
        this.TxtFieldPhone.setText(TxtFieldPhone);
        this.jTextAreaNote.setText(jTextAreaNote);
        this.TxtFieldCedula.setText(TxtFieldCedula);
    }

    public void setFieldsValue(String TxtFieldLastName, String TxtFieldCellphone, String TxtFieldMail, String TxtFieldName, String TxtFieldPhone, String TxtFieldCedula) {
        this.TxtFieldLastName.setText(TxtFieldLastName);
        this.TxtFieldCellphone.setText(TxtFieldCellphone);
        this.TxtFieldMail.setText(TxtFieldMail);
        this.TxtFieldName.setText(TxtFieldName);
        this.TxtFieldPhone.setText(TxtFieldPhone);
        this.TxtFieldCedula.setText(TxtFieldCedula);
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

    public JTextField getTxtFieldAdress() {
        return TxtFieldAdress;
    }

    public JFormattedTextField getTxtFieldCedula() {
        return TxtFieldCedula;
    }

    public JFormattedTextField getTxtFieldCellphone() {
        return TxtFieldCellphone;
    }

    public JTextField getTxtFieldCity() {
        return TxtFieldCity;
    }

    public JTextField getTxtFieldLastName() {
        return TxtFieldLastName;
    }

    public JTextField getTxtFieldMail() {
        return TxtFieldMail;
    }

    public JTextField getTxtFieldName() {
        return TxtFieldName;
    }

    public JFormattedTextField getTxtFieldPhone() {
        return TxtFieldPhone;
    }

    public JTextArea getjTextAreaNote() {
        return jTextAreaNote;
    }

    public void setListener() {
        btnCancel.addActionListener(ctrlCustormers);
        btnSave.addActionListener(ctrlCustormers);
        btnPerson.addActionListener(ctrlCustormers);
    }

    public JButton getBtnPerson() {
        return btnPerson;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() throws ParseException {

        pnFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtFieldName = new javax.swing.JTextField();
        TxtFieldPhone = new JFormattedTextField(new MaskFormatter(" ###-###-####"));
        TxtFieldPhone.setValue(new String(" 809-000-0000"));
        TxtFieldLastName = new javax.swing.JTextField();
        TxtFieldCellphone = new JFormattedTextField(new MaskFormatter(" ###-###-####"));
        TxtFieldCellphone.setValue(new String(" 809-000-0000"));

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtFieldCity = new javax.swing.JTextField();
        TxtFieldMail = new javax.swing.JTextField();
        TxtFieldAdress = new javax.swing.JTextField();
        pnButtons = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPerson = new javax.swing.JButton("Search");


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("Nombre.:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("Celular.:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel3.setText("Apellido.:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setText("Telefono.:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel5.setText("Direccion.:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel6.setText("Ciudad.:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel7.setText("Nota.:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel8.setText("Correo.:");
        jTextAreaNote = new javax.swing.JTextArea();

        jTextAreaNote.setColumns(20);
        jTextAreaNote.setRows(5);

        TxtFieldCedula = new JFormattedTextField(new MaskFormatter(" ###-#######-#"));
        TxtFieldCedula.setValue(new String(" 032-0000000-1"));

        JLabel label = new JLabel();
        label.setText("Cedula.:");
        label.setFont(new Font("Arial", Font.BOLD, 14));


        javax.swing.GroupLayout gl_pnFields = new javax.swing.GroupLayout(pnFields);
        gl_pnFields.setHorizontalGroup(
                gl_pnFields.createParallelGroup(Alignment.LEADING).addGroup(gl_pnFields.createSequentialGroup().addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING).addGroup(gl_pnFields.createSequentialGroup().addGap(10).addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING).addComponent(jLabel1).addComponent(jLabel3).addComponent(label, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addComponent(jLabel5))).addGroup(gl_pnFields.createSequentialGroup().addContainerGap().addComponent(jLabel7))).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING).addGroup(gl_pnFields.createSequentialGroup().addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING).addComponent(TxtFieldName, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE).addComponent(TxtFieldLastName, 241, 241, 241).addComponent(TxtFieldCedula, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE).addComponent(TxtFieldAdress, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE).addGroup(gl_pnFields.createParallelGroup(Alignment.TRAILING).addComponent(jLabel2).addComponent(jLabel4).addComponent(jLabel8).addComponent(jLabel6)).addGap(24).addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING).addGroup(gl_pnFields.createSequentialGroup().addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING).addComponent(TxtFieldMail, 206, 206, 206).addComponent(TxtFieldPhone, 187, 187, 187).addComponent(TxtFieldCellphone, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)).addGap(121)).addGroup(gl_pnFields.createSequentialGroup().addComponent(TxtFieldCity, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE).addContainerGap()))).addGroup(gl_pnFields.createSequentialGroup().addComponent(jTextAreaNote, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE).addContainerGap()))).addGroup(gl_pnFields.createSequentialGroup().addContainerGap(417, Short.MAX_VALUE)));
        gl_pnFields.setVerticalGroup(
                gl_pnFields.createParallelGroup(Alignment.LEADING).addGroup(gl_pnFields.createSequentialGroup().addContainerGap().addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1).addComponent(TxtFieldName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addComponent(jLabel2).addComponent(TxtFieldCellphone, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)).addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING).addGroup(gl_pnFields.createSequentialGroup().addGap(18).addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE).addComponent(jLabel3).addComponent(TxtFieldLastName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addComponent(jLabel4)).addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING).addGroup(gl_pnFields.createSequentialGroup().addGap(18).addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE).addComponent(TxtFieldCedula, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addComponent(label, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)).addGap(18).addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE).addComponent(TxtFieldAdress, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addComponent(jLabel5))).addGroup(gl_pnFields.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE).addComponent(jLabel8).addComponent(TxtFieldMail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)).addGap(18).addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE).addComponent(jLabel6).addComponent(TxtFieldCity, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))).addGroup(gl_pnFields.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED).addComponent(TxtFieldPhone, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING).addComponent(jLabel7).addComponent(jTextAreaNote, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE).addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)).addPreferredGap(ComponentPlacement.RELATED)));
        pnFields.setLayout(gl_pnFields);
        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/save.png"))); // NOI18N
        btnSave.setFocusable(false);
        pnButtons.add(btnSave);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/cancel.png"))); // NOI18N
        btnCancel.setFocusable(false);
        pnButtons.add(btnCancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnButtons, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(27).addComponent(pnFields, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnButtons, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(pnFields, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap(28, Short.MAX_VALUE)));
        getContentPane().setLayout(layout);
        btnPerson.setBounds(770, 15, 85, 25);
        pnFields.add(btnPerson);
    }// </editor-fold>                        
    // Variables declaration - do not modify                     
    private javax.swing.JTextField TxtFieldLastName;
    private javax.swing.JFormattedTextField TxtFieldCellphone;
    private javax.swing.JTextField TxtFieldCity;
    private javax.swing.JTextField TxtFieldAdress;
    private javax.swing.JTextField TxtFieldMail;
    private javax.swing.JTextField TxtFieldName;
    private javax.swing.JFormattedTextField TxtFieldPhone;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextArea jTextAreaNote;
    private javax.swing.JButton btnPerson;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnFields;
    private javax.swing.JFormattedTextField TxtFieldCedula;

    @Override
    public void showFrame() {
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.setVisible(false);
    }
}
