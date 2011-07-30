package itla.jpuppy.forms;
import itla.jpuppy.controllers.ControllerPatients;
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


public class ManagePatients extends javax.swing.JDialog implements FrameOption {

    public ManagePatients(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        ControllerPatients cp = new ControllerPatients(this);
         setController(cp);
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
        TxtFieldNombre = new javax.swing.JTextField();
        TxtFieldDueno = new javax.swing.JTextField();
        TxtFieldCumpleano = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreNota = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtFieldUltimaVisita = new javax.swing.JTextField();
        TxtFieldUltimaVisitaDoctor = new javax.swing.JTextField();
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
        jLabel1.setText("Nombre.:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("Dueño.:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel3.setText("Cumpleaño.:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setText("Nota.:");

        jTextAreNota.setColumns(20);
        jTextAreNota.setRows(5);
        jScrollPane1.setViewportView(jTextAreNota);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel5.setText("Ultima Visita.:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel6.setText("Ultima Visita del doctor.:");

        javax.swing.GroupLayout pnFieldsLayout = new javax.swing.GroupLayout(pnFields);
        pnFields.setLayout(pnFieldsLayout);
        pnFieldsLayout.setHorizontalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(56, 56, 56)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(TxtFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(TxtFieldDueno, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(TxtFieldCumpleano, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(TxtFieldUltimaVisita, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(TxtFieldUltimaVisitaDoctor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldDueno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldCumpleano, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldUltimaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldUltimaVisitaDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27))
        );

        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));

        btnAdd.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/add.png"));
        btnAdd.setFocusable(false);
        btnAdd.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAdd.setName("add"); // NOI18N
        btnAdd.setOpaque(false);
        pnButtons.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/edit.png"));
        btnUpdate.setFocusable(false);
        btnUpdate.setName("update"); // NOI18N
        pnButtons.add(btnUpdate);

        btnSearch.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/find.png"));
        btnSearch.setFocusable(false);
        btnSearch.setName("search"); // NOI18N
        pnButtons.add(btnSearch);

        btnSave.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/save.png"));
        btnSave.setFocusable(false);
        btnSave.setName("save"); // NOI18N
        pnButtons.add(btnSave);

        btnRemove.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/remove.png"));
        btnRemove.setFocusable(false);
        btnRemove.setName("remove"); // NOI18N
        pnButtons.add(btnRemove);

        btnCancel.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/cancel.png"));
        btnCancel.setFocusable(false);
        btnCancel.setName("cancel"); // NOI18N
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
                        .addGap(113, 113, 113)
                        .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtFieldCumpleano;
    private javax.swing.JTextField TxtFieldDueno;
    private javax.swing.JTextField TxtFieldNombre;
    private javax.swing.JTextField TxtFieldUltimaVisita;
    private javax.swing.JTextField TxtFieldUltimaVisitaDoctor;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreNota;
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

    /**
     * @return the TxtFieldCumpleano
     */
    public javax.swing.JTextField getTxtFieldCumpleano() {
        return TxtFieldCumpleano;
    }

    /**
     * @param TxtFieldCumpleano the TxtFieldCumpleano to set
     */
    public void setTxtFieldCumpleano(javax.swing.JTextField TxtFieldCumpleano) {
        this.TxtFieldCumpleano = TxtFieldCumpleano;
    }

    /**
     * @return the TxtFieldDueno
     */
    public javax.swing.JTextField getTxtFieldDueno() {
        return TxtFieldDueno;
    }

    /**
     * @param TxtFieldDueno the TxtFieldDueno to set
     */
    public void setTxtFieldDueno(javax.swing.JTextField TxtFieldDueno) {
        this.TxtFieldDueno = TxtFieldDueno;
    }

    /**
     * @return the TxtFieldNombre
     */
    public javax.swing.JTextField getTxtFieldNombre() {
        return TxtFieldNombre;
    }

    /**
     * @param TxtFieldNombre the TxtFieldNombre to set
     */
    public void setTxtFieldNombre(javax.swing.JTextField TxtFieldNombre) {
        this.TxtFieldNombre = TxtFieldNombre;
    }

    /**
     * @return the TxtFieldUltimaVisita
     */
    public javax.swing.JTextField getTxtFieldUltimaVisita() {
        return TxtFieldUltimaVisita;
    }

    /**
     * @param TxtFieldUltimaVisita the TxtFieldUltimaVisita to set
     */
    public void setTxtFieldUltimaVisita(javax.swing.JTextField TxtFieldUltimaVisita) {
        this.TxtFieldUltimaVisita = TxtFieldUltimaVisita;
    }

    /**
     * @return the TxtFieldUltimaVisitaDoctor
     */
    public javax.swing.JTextField getTxtFieldUltimaVisitaDoctor() {
        return TxtFieldUltimaVisitaDoctor;
    }

    /**
     * @param TxtFieldUltimaVisitaDoctor the TxtFieldUltimaVisitaDoctor to set
     */
    public void setTxtFieldUltimaVisitaDoctor(javax.swing.JTextField TxtFieldUltimaVisitaDoctor) {
        this.TxtFieldUltimaVisitaDoctor = TxtFieldUltimaVisitaDoctor;
    }

  
   

    /**
     * @return the jTextAreNota
     */
    public javax.swing.JTextArea getjTextAreNota() {
        return jTextAreNota;
    }

    /**
     * @param jTextAreNota the jTextAreNota to set
     */
    public void setjTextAreNota(javax.swing.JTextArea jTextAreNota) {
        this.jTextAreNota = jTextAreNota;
    }

    private void setController(ControllerPatients cp) {
        btnAdd.addActionListener(cp);
        btnUpdate.addActionListener(cp);
        btnSearch.addActionListener(cp);
        btnSave.addActionListener(cp);
        btnRemove.addActionListener(cp);
        btnCancel.addActionListener(cp);
    }



}
