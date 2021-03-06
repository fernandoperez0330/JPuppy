package itla.jpuppy.forms;

import itla.jpuppy.business.ModelConsultations;
import itla.jpuppy.datalayer.Appointments;
import itla.jpuppy.datalayer.Consultations;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.datalayer.Patients;
import itla.jpuppy.models.ControlEditConsultations;
import itla.jpuppy.utils.GeneratorDataCombo;
import itla.jpuppy.utils.TypeConsultations;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class EditConsultations extends javax.swing.JDialog implements FrameOption {

    Long idnew = null;
    private ComboBoxModel model = null;
    private Consultations consultation = null;
    
    private Date dateStart = null;
    private Date dateEnd = null;
    private Customers customer = null;
    private Patients patients = null;
    private String remark = null;
    private Appointments appointments = null;
    private String typeConsultations = null;

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JComboBox getjComboBox2() {
        return jComboBox2;
    }

    public void setjComboBox2(JComboBox jComboBox2) {
        this.jComboBox2 = jComboBox2;
    }

    public JComboBox getjComboBox3() {
        return jComboBox3;
    }

    public void setjComboBox3(JComboBox jComboBox3) {
        this.jComboBox3 = jComboBox3;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Consultations getConsultation() {
        return consultation;
    }
    

    public EditConsultations(java.awt.Frame parent, boolean modal, Object id) {
        super(parent, modal);
        initComponents();

        idnew = Long.parseLong(String.valueOf(id));
        consultation = new ModelConsultations().getConsultationsByID(idnew);
        
        
        //Llena los campos para el editado
        try {
            model = new DefaultComboBoxModel(new GeneratorDataCombo().dataCustomers());
            this.setCbCustomerConsultationsModel(model);
            model = new DefaultComboBoxModel(new GeneratorDataCombo().dataPatients());
            this.setCbPatientsConsultationsModel(model);
            this.jComboBox1.setModel(new DefaultComboBoxModel(TypeConsultations.values()));
        } catch (Exception e) {
        }
        //System.out.println(consultation.getTypeConsultations());
        this.jComboBox1.setSelectedItem(consultation.getTypeConsultations());
        this.jComboBox2.setSelectedItem(consultation.getCustomer().getName()+ " "+ consultation.getCustomer().getLastName());
        this.jComboBox3.setSelectedItem(consultation.getPatients().getName());
        this.jTextArea1.setText(String.valueOf(consultation.getRemark()));

        ControlEditConsultations ce = new ControlEditConsultations(this);

        jButton1.addActionListener(ce);
        jButton2.addActionListener(ce);

        this.setLocationRelativeTo(null);
        this.setTitle("Editar consultas");
        this.setResizable(false);
    }

    public void setCbCustomerConsultationsModel(ComboBoxModel model) {
        this.jComboBox2.setModel(model);
    }

    public void setCbPatientsConsultationsModel(ComboBoxModel model) {
        this.jComboBox3.setModel(model);
    }

    public String getActionCommandSv() {
        return jButton1.getActionCommand();
    }

    public String getActionCommandCn() {
        return jButton2.getActionCommand();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("Paciente:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel3.setText("Tipo:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setText("Observacion:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Modificar");

        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49)
                        .addComponent(jComboBox1, 0, 154, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, 154, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, 154, Short.MAX_VALUE)))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showFrame() {
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.dispose();
    }
}
