package itla.jpuppy.forms;

import datechooser.beans.DateChooserCombo;
import itla.jpuppy.controllers.ControllerPatients;
import java.awt.Font;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ManagePatients extends JDialog implements FrameOption {
    
    private ManagePatients parent;
    private Long patientId = null;

    private JPanel pnFields;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField TxtFieldNombre;
    private JTextField TxtFieldDueno;
    //id del cliente propietario del paciente
    private Long idDueno;
    private DateChooserCombo TxtFieldCumpleano;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreNota;

    private JLabel jLabel5;
    private JLabel jLabel6;
    private DateChooserCombo TxtFieldUltimaVisita;
    private JTextField TxtFieldUltimaVisitaDoctor;
    private JPanel pnButtons;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnSearch;
    private JButton btnSave;
    private JButton btnRemove;
    private JButton btnCancel;
    private JButton btnSearchCustomer;
    
    private JTable jTable1;

    //controlador
    private ControllerPatients Controller = new ControllerPatients(this);
    
    //constructor cuando es para mostrar el administrador
    public ManagePatients(Frame owner, boolean modal) {
        super(owner, modal);
        this.setIconImage(FrameOption.icon.getImage());
        initComponents(1);
        setController(Controller, 1);
        this.setLocationRelativeTo(null);
        this.setTitle("Lista de pacientes");
        this.setResizable(false);
    }

    public ManagePatients(ManagePatients owner, boolean modal, boolean flagManage) {
        super(owner, modal);
        this.parent = owner;
        this.setIconImage(FrameOption.icon.getImage());
        initComponents(2);
        setController(Controller, 2);
        this.setLocationRelativeTo(null);
        this.setTitle("Agregar paciente nuevo");
        this.setResizable(false);
    }

    public ManagePatients(ManagePatients owner, boolean modal, boolean flagManage,Long patientId) {
        super(owner, modal);
        this.parent = owner;
        this.patientId = patientId;
        this.setIconImage(FrameOption.icon.getImage());
        initComponents(3);
        setController(Controller, 3);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Modificar paciente");
        this.setResizable(false);
    }
    

    private void initComponents(int state) {

        switch (state) {
            //cuando es para agregar un nuevo paciente
            case 2:
                getContentManage(null);
                break;
            //cuando es para modificar un paciente
            case 3:            
                getContentManage(this.patientId);
                break;
            //cuando es para listar los pacientes
            default:
                pnFields = new JPanel();
                jScrollPane1 = new JScrollPane();
                jTable1 = new JTable();
                pnButtons = new JPanel();
                btnAdd = new JButton();
                btnUpdate = new JButton();
                btnSearch = new JButton();
                btnRemove = new JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                //asignar la lista de pacientes a la tabla
                jTable1.setModel(Controller.getTableModelPatients());
                jTable1.addMouseListener(Controller);
                
                jTable1.setRowHeight(25);
                jTable1.setColumnSelectionAllowed(false);
                jTable1.setName("tablePatients");
                jScrollPane1.setViewportView(jTable1);
                GroupLayout pnFieldsLayout = new GroupLayout(pnFields);
                pnFields.setLayout(pnFieldsLayout);
                pnFieldsLayout.setHorizontalGroup(
                        pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE));
                pnFieldsLayout.setVerticalGroup(
                        pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE));

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

                btnRemove.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/remove.png"));
                btnRemove.setFocusable(false);
                btnRemove.setName("remove"); // NOI18N
                pnButtons.add(btnRemove);

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(113, 113, 113).addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap()));
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE).addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(47, 47, 47)));

                pack();
                break;
        }
    }
    /*metodo para */
    public void getContentManage(Long patientId){
        pnFields = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        TxtFieldNombre = new JTextField();
        TxtFieldDueno = new JTextField();
        TxtFieldCumpleano = new DateChooserCombo();
        TxtFieldCumpleano.setDateFormat(new SimpleDateFormat("dd-MMM-yyyy")); 
        
        jScrollPane1 = new JScrollPane();
        jTextAreNota = new JTextArea();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        TxtFieldUltimaVisita = new DateChooserCombo();
        TxtFieldUltimaVisita.setMaxDate(new GregorianCalendar());
        
        TxtFieldUltimaVisita.setDateFormat(new SimpleDateFormat("dd-MMM-yyyy")); 
        TxtFieldUltimaVisitaDoctor = new JTextField();
        pnButtons = new JPanel();
        btnSave = new JButton();
        btnCancel = new JButton();
        btnSearchCustomer = new JButton();
        
        //verificar si es un paciente nuevo a agregar o uno existente a modificar
        if (patientId != null){
            Controller.findPatient(patientId);
        }

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

        jLabel5.setFont(new Font("Arial", 1, 14));
        jLabel5.setText("Ultima Visita.:");

        jLabel6.setFont(new Font("Arial", 1, 14));
        jLabel6.setText("Ultima Visita del doctor.:");

        GroupLayout pnFieldsLayout = new GroupLayout(pnFields);
        pnFields.setLayout(pnFieldsLayout);
        pnFieldsLayout.setHorizontalGroup(
                pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnFieldsLayout.createSequentialGroup().addContainerGap().addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel5).addComponent(jLabel6).addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel1).addComponent(jLabel4)).addGap(56, 56, 56).addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE).addComponent(TxtFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE).addComponent(TxtFieldCumpleano, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE).addComponent(TxtFieldUltimaVisita, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE).addComponent(TxtFieldUltimaVisitaDoctor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnFieldsLayout.createSequentialGroup().addComponent(TxtFieldDueno, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnSearchCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))).addContainerGap()));
        pnFieldsLayout.setVerticalGroup(
                pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnFieldsLayout.createSequentialGroup().addContainerGap().addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(TxtFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel1)).addGap(18, 18, 18).addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(btnSearchCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(TxtFieldDueno, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE).addComponent(jLabel2))).addGap(18, 18, 18).addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(TxtFieldCumpleano, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel3)).addGap(15, 15, 15).addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(TxtFieldUltimaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5)).addGap(18, 18, 18).addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(TxtFieldUltimaVisitaDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel6)).addGap(18, 18, 18).addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel4)).addGap(27, 27, 27)));

        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));


        btnSave.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/save.png"));
        btnSave.setFocusable(false);
        btnSave.setName("save"); // NOI18N
        pnButtons.add(btnSave);


        btnCancel.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/cancel.png"));
        btnCancel.setFocusable(false);
        btnCancel.setName("cancel"); // NOI18N
        pnButtons.add(btnCancel);

        btnSearchCustomer.setName("searchCustomer");
        btnSearchCustomer.setText("Buscar cliente");

        TxtFieldDueno.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(113, 113, 113).addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE).addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(47, 47, 47)));

        pack();
    
    }
    
    public DateChooserCombo getTxtFieldUltimaVisita() {
        return TxtFieldUltimaVisita;
    }

    public void setTxtFieldUltimaVisita(DateChooserCombo TxtFieldUltimaVisita) {
        this.TxtFieldUltimaVisita = TxtFieldUltimaVisita;
    }

    public Long getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(Long idDueno) {
        this.idDueno = idDueno;
    }

    public DateChooserCombo getTxtFieldCumpleano() {
        return TxtFieldCumpleano;
    }

    public void setTxtFieldCumpleano(DateChooserCombo TxtFieldCumpleano) {
        this.TxtFieldCumpleano = TxtFieldCumpleano;
    }

    public JTextField getTxtFieldDueno() {
        return TxtFieldDueno;
    }

    public void setTxtFieldDueno(JTextField TxtFieldDueno) {
        this.TxtFieldDueno = TxtFieldDueno;
    }

    public JTextField getTxtFieldNombre() {
        return TxtFieldNombre;
    }

    public void setTxtFieldNombre(JTextField TxtFieldNombre) {
        this.TxtFieldNombre = TxtFieldNombre;
    }

    public JTextField getTxtFieldUltimaVisitaDoctor() {
        return TxtFieldUltimaVisitaDoctor;
    }

    public void setTxtFieldUltimaVisitaDoctor(JTextField TxtFieldUltimaVisitaDoctor) {
        this.TxtFieldUltimaVisitaDoctor = TxtFieldUltimaVisitaDoctor;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }

    public void setBtnRemove(JButton btnRemove) {
        this.btnRemove = btnRemove;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }
    
    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }
    
    public ManagePatients getParent() {
        return parent;
    }

    public void setParent(ManagePatients parent) {
        this.parent = parent;
    }
    
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    
     public JTextArea getjTextAreNota() {
        return jTextAreNota;
    }

    public void setjTextAreNota(JTextArea jTextAreNota) {
        this.jTextAreNota = jTextAreNota;
    }

    private void setController(ControllerPatients Controller, int state) {
        switch (state) {
            //cuando es para agregar un nuevo paciente
            case 2:
                btnSave.addActionListener(Controller);
                btnCancel.addActionListener(Controller);
                btnSearchCustomer.addActionListener(Controller);
                break;
            //cuando es para modificar un paciente
            case 3:
                btnSave.addActionListener(Controller);
                btnCancel.addActionListener(Controller);
                btnSearchCustomer.addActionListener(Controller);
                break;
            //cuando es para listar los pacientes
            default:
                btnAdd.addActionListener(Controller);
                btnUpdate.addActionListener(Controller);
                btnSearch.addActionListener(Controller);
                btnRemove.addActionListener(Controller);
                break;
        }
    }
    
    public ControllerPatients getController() {
        return Controller;
    }

    public void setController(ControllerPatients Controller) {
        this.Controller = Controller;
    }
    

    @Override
    public void showFrame() {
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.setVisible(false);
    }
    @Override
    public void dispose() {
        super.dispose();
    }
}
