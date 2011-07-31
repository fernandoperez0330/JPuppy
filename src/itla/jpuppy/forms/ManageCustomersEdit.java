package itla.jpuppy.forms;

import itla.jpuppy.forms.FrameOption;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

/*
 * NewJFrame.java
 *
 * Created on Jul 25, 2011, 1:32:21 AM
 */

/**
 *
 * @author Adderly
 */
public class ManageCustomersEdit extends javax.swing.JDialog implements FrameOption {

    public ManageCustomersEdit(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Manage Customers");
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
        TxtFieldNombre = new javax.swing.JTextField();
        TxtFieldTelefono = new javax.swing.JTextField();
        TxtFieldApellido = new javax.swing.JTextField();
        TxtFieldCelular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtFieldCiudad = new javax.swing.JTextField();
        TxtFieldMail = new javax.swing.JTextField();
        TxtFieldDireccion = new javax.swing.JTextField();
        pnButtons = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CrudEntities");

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
        jLabel8.setText("Mail.:");
        jTextAreaNota = new javax.swing.JTextArea();
        
                jTextAreaNota.setColumns(20);
                jTextAreaNota.setRows(5);
        
        textField = new JTextField();
        
        JLabel label = new JLabel();
        label.setText("Cedula.:");
        label.setFont(new Font("Arial", Font.BOLD, 14));
        
        spnResult = new javax.swing.JScrollPane();
        table = new JTable();
        spnResult.setViewportView(table);
        
        JButton btnAdd = new JButton();
        btnAdd.setFocusable(false);
        
        JButton btnRemove = new JButton();
        btnRemove.setFocusable(false);

        javax.swing.GroupLayout gl_pnFields = new javax.swing.GroupLayout(pnFields);
        gl_pnFields.setHorizontalGroup(
        	gl_pnFields.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnFields.createSequentialGroup()
        			.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pnFields.createSequentialGroup()
        					.addGap(10)
        					.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabel3)
        						.addComponent(label, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel5)))
        				.addGroup(gl_pnFields.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel7)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pnFields.createSequentialGroup()
        					.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        						.addComponent(TxtFieldNombre, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        						.addComponent(TxtFieldApellido, 241, 241, 241)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
        						.addComponent(TxtFieldDireccion, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
        					.addGroup(gl_pnFields.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jLabel2)
        						.addComponent(jLabel4)
        						.addComponent(jLabel8)
        						.addComponent(jLabel6))
        					.addGap(24)
        					.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pnFields.createSequentialGroup()
        							.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        								.addComponent(TxtFieldMail, 206, 206, 206)
        								.addComponent(TxtFieldTelefono, 187, 187, 187)
        								.addComponent(TxtFieldCelular, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
        							.addGap(121))
        						.addGroup(gl_pnFields.createSequentialGroup()
        							.addComponent(TxtFieldCiudad, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
        							.addContainerGap())))
        				.addGroup(gl_pnFields.createSequentialGroup()
        					.addComponent(jTextAreaNota, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        		.addGroup(gl_pnFields.createSequentialGroup()
        			.addComponent(table, GroupLayout.PREFERRED_SIZE, 848, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(538, Short.MAX_VALUE))
        		.addGroup(gl_pnFields.createSequentialGroup()
        			.addGap(265)
        			.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(417, Short.MAX_VALUE))
        );
        gl_pnFields.setVerticalGroup(
        	gl_pnFields.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnFields.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(TxtFieldNombre, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2)
        				.addComponent(TxtFieldCelular, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pnFields.createSequentialGroup()
        					.addGap(18)
        					.addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel3)
        						.addComponent(TxtFieldApellido, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel4))
        					.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pnFields.createSequentialGroup()
        							.addGap(18)
        							.addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE)
        								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        								.addComponent(label, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        							.addGap(18)
        							.addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE)
        								.addComponent(TxtFieldDireccion, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel5)))
        						.addGroup(gl_pnFields.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jLabel8)
        								.addComponent(TxtFieldMail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        							.addGap(18)
        							.addGroup(gl_pnFields.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jLabel6)
        								.addComponent(TxtFieldCiudad, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))))
        				.addGroup(gl_pnFields.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(TxtFieldTelefono, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel7)
        				.addComponent(jTextAreaNota, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
        			.addGroup(gl_pnFields.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(table, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
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
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(pnButtons, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(27)
        			.addComponent(pnFields, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(pnButtons, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(pnFields, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(28, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtFieldApellido;
    private javax.swing.JTextField TxtFieldCelular;
    private javax.swing.JTextField TxtFieldCiudad;
    private javax.swing.JTextField TxtFieldDireccion;
    private javax.swing.JTextField TxtFieldMail;
    private javax.swing.JTextField TxtFieldNombre;
    private javax.swing.JTextField TxtFieldTelefono;
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
    private javax.swing.JTextArea jTextAreaNota;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnFields;
    private JTextField textField;
    private JTable table;
    private javax.swing.JScrollPane spnResult;
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
