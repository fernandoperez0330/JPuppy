package itla.jpuppy.forms;



import itla.jpuppy.controllers.Controller;
import itla.jpuppy.controllers.ControllerAppointments;
import itla.jpuppy.datalayer.Species;
import itla.jpuppy.utils.enumAppointmentStatus;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.util.calendar.BaseCalendar;
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
 * @author Jansel
 */

/* Necesito que la Persona que trabajo con esta vista por favor le coloque dos BasicArrowButton */
/* Uno con orientacion 3 y otro con orientacion 7*/

public class ManageAppointnments extends JDialog  implements FrameOption{

    public ManageAppointnments(Frame owner, boolean modal) {
        super();
        initComponents();
        ControllerAppointments cb = new ControllerAppointments( this );
        setController( cb );
        //initFields( this.pnFields , this.pnButtons );
        this.setLocationRelativeTo( null );
        this.setTitle( "Manage Appointments" );
        this.setResizable( false );
        setMessageFind("");
    
        
    }

   
    public void setController( ControllerAppointments ca )
    {
//        btnAdd.setActionCommand( "add" );
        btnUpdate.setActionCommand( "update" );
        btnSearch.setActionCommand( "search" );
        btnSave.setActionCommand( "save" );
        btnRemove.setActionCommand( "remove" );
        btnCancel.setActionCommand( "cancel" );
  //      btnAdd.addActionListener(ca);
        btnUpdate.addActionListener(ca);
        btnSearch.addActionListener(ca);
        btnSave.addActionListener(ca);
        btnRemove.addActionListener(ca);
        btnCancel.addActionListener(ca);
 
      
        
       
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
        jComboBoxPaciente = new javax.swing.JComboBox();
        jComboBoxStatus = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxDoctor = new javax.swing.JComboBox();
        pnButtons = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CrudEntities");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("Nombre del Paciente.:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("Fecha de Registro.:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel3.setText("Fecha de Cita.:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setText("Doctor.:");

        jComboBoxPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel6.setText("Status.:");

        jComboBoxDoctor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        javax.swing.GroupLayout pnFieldsLayout = new javax.swing.GroupLayout(pnFields);
        pnFields.setLayout(pnFieldsLayout);
        pnFieldsLayout.setHorizontalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFieldsLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jComboBoxPaciente, 0, 361, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFieldsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxStatus, 0, 361, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnButtons.setLayout(null);

        btnUpdate.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/edit.png"));
        btnUpdate.setFocusable(false);
        btnUpdate.setName("update"); // NOI18N
        pnButtons.add(btnUpdate);
        btnUpdate.setBounds(90, 0, 110, 50);

        btnSearch.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/find.png"));
        btnSearch.setFocusable(false);
        btnSearch.setName("search"); // NOI18N
        pnButtons.add(btnSearch);
        btnSearch.setBounds(220, 0, 110, 50);

        btnSave.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/save.png"));
        btnSave.setFocusable(false);
        btnSave.setName("save"); // NOI18N
        pnButtons.add(btnSave);
        btnSave.setBounds(352, 0, 110, 50);

        btnRemove.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/remove.png"));
        btnRemove.setFocusable(false);
        btnRemove.setName("remove"); // NOI18N
        pnButtons.add(btnRemove);
        btnRemove.setBounds(490, 0, 110, 50);

        btnCancel.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/cancel.png"));
        btnCancel.setFocusable(false);
        btnCancel.setName("cancel"); // NOI18N
        pnButtons.add(btnCancel);
        btnCancel.setBounds(620, 0, 110, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox jComboBoxDoctor;
    private javax.swing.JComboBox jComboBoxPaciente;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnFields;
    // End of variables declaration//GEN-END:variables

    private datechooser.beans.DateChooserCombo dateChooserRegister;
    private datechooser.beans.DateChooserCombo dateChooserCita;
    
    {
        
        dateChooserRegister = new datechooser.beans.DateChooserCombo();
        dateChooserRegister.setDateFormat( new SimpleDateFormat("dd-MMM-yyyy"));
//        this.getContentPane().add( dateChooserRegister );
        dateChooserRegister.setBounds(390, 280, 360, 28);
    }
    {
        dateChooserCita = new datechooser.beans.DateChooserCombo();
        dateChooserCita.setDateFormat( new SimpleDateFormat("dd-MMM-yyyy"));
        this.getContentPane().add( dateChooserCita );
        dateChooserCita.setBounds(390, 315, 360, 28);
    }
    
    @Override
    public void showFrame() {
       this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.dispose();
    }

    
 public void setMessageFind( String text ){
     this.jLabel5.setText( text );
 }
 
public String getPatientName(){
    return ( String ) jComboBoxPaciente.getSelectedItem();
}

public String getDoctorName(){
    return  ( String ) jComboBoxDoctor.getSelectedItem();
}

public enumAppointmentStatus getStatusName(){
    String status= ( String ) jComboBoxStatus.getSelectedItem();
    
    if( status.equals( "ACTIVE" ) )
        return enumAppointmentStatus.ACTIVE;
    else if ( status.equals( "CANCELED" ) )
        return enumAppointmentStatus.CANCELED;
    else if ( status.equals( "POSPUSED" ) )
        return enumAppointmentStatus.POSPUSED;
    else 
        return enumAppointmentStatus.NOTASISTED;

}
public Date getRegisteredDate(){
    return new Date( this.dateChooserRegister.getSelectedDate().getTimeInMillis() );
}

public Date getAcordetDate(){
    return new Date ( this.dateChooserCita.getSelectedDate().getTimeInMillis() );
            
}

   
    public JPanel getPnButtons() {
        return pnButtons;
    }
    
    public void setAllFields(String PatientName , Date registered,Date acordded,String doctor,int status ){
        Calendar c = Calendar.getInstance();
        jComboBoxPaciente.setSelectedItem( PatientName );
        c.setTime( registered );
        dateChooserRegister.setSelectedDate( c );
        c.setTime( acordded );
        dateChooserCita.setSelectedDate( c );
        jComboBoxDoctor.setSelectedItem( doctor );
        jComboBoxStatus.setSelectedIndex( status+1 );
    }

  

    //@Override
    public void eventDelete() {
/*        if( !isEmptyFields() ){
        changeStatePnlEdition( false );
        cleanFields();
        stateButtons(true, false);
 * 
        }else{
            javax.swing.JOptionPane.showMessageDialog( null ,"error: no selected register" );
        }
 * 
 */
    }

    //@Override
    public boolean eventSave() {
       /* boolean state=true;
        if( !isEmptyFields() ){
           
       changeStateWriteFields( false );
       stateButtons(true, false);
        }else {
            state = false;
            javax.swing.JOptionPane.showMessageDialog( null ,"error: cannot save registry , empty field" );
        }
        return state;
        * 
        */
       return true;
    }

    //@Override
    public void eventSearch( String text ) {
           
        /*if( !isEmptyFields() )
            cleanFields();
        if( !text.equals("-") )
            changeStateWriteFields( false );
       stateButtons(true, false);
       changeStatePnlEdition( true );
         * 
         */
       
    }
    public void setJComboBoxModelDoctor( ComboBoxModel boxModel ){
        this.jComboBoxDoctor.setModel( boxModel );
    }
      public void setJComboBoxModelPatients( ComboBoxModel boxModel ){
        this.jComboBoxPaciente.setModel( boxModel );
    }
        public void setJComboBoxModelStatus( ComboBoxModel boxModel ){
        this.jComboBoxStatus.setModel( boxModel );
    }

    

 
}
