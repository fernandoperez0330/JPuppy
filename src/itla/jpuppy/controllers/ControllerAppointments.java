/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelAppointments;
import itla.jpuppy.business.ModelEmployees;
import itla.jpuppy.business.ModelPatients;
import itla.jpuppy.datalayer.Appointments;
import itla.jpuppy.datalayer.Doctor;
import itla.jpuppy.datalayer.Patients;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.ManageAppointmentsMenu;
import itla.jpuppy.forms.ManageAppointnmentsEdit;
import itla.jpuppy.models.SearchingCrtlAppointments;
import itla.jpuppy.models.SearchingModel;
import itla.jpuppy.utils.IDS;
import itla.jpuppy.utils.enumAppointmentStatus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import javax.print.Doc;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jansel
 */

    

public class ControllerAppointments implements ActionListener,KeyListener,MouseListener,WindowFocusListener{
    
    private ManageAppointmentsMenu manageAppointments=null;
    private ManageAppointnmentsEdit manageEdit = null;
    private ModelAppointments modelAppointments =null;
    private ModelEmployees modelEmployees = null;
    private ModelPatients modelPatients=null;
    private Appointments appointments=null;
    private Appointments temp=null;
    private enumAppointmentStatus enumStatus=null;
    private List<Appointments> listSearched=null;
    private Date AcordetDate=null;
    private Date registerDate=null;
    private Doctor doctor = null;
    private Patients patients=null;
    private ComboBoxModel model=null;
    private itla.jpuppy.utils.IDS idsPatieIds = null;
    private itla.jpuppy.utils.IDS idsDoctors = null;
    private long specificId=0;
    private SearchingModel<Appointments> modelSearching=null;
    
    public ControllerAppointments(ManageAppointmentsMenu aThis) {
            this.manageAppointments = aThis;
            this.modelAppointments = new ModelAppointments();
            this.modelEmployees = new ModelEmployees();
            this.modelPatients = new ModelPatients();
            idsDoctors = new IDS();
            idsPatieIds = new IDS();
            modelSearching = new SearchingModel<Appointments>(new String[]{"ID","PACIENTE","FECHA DE REGISTRO","CITA","DOCTOR","STATUS"},new SearchingCrtlAppointments());
            manageAppointments.setSearching(new JSearching(modelSearching));
            searchByField("");
        
    }
    
    
    public void initComboBox(){
        model= new DefaultComboBoxModel( this.searchAllDoctorModel() );
        this.manageEdit.setJComboBoxModelDoctor( model );
        model = new DefaultComboBoxModel( this.searchAllPatientsModel() );
        this.manageEdit.setJComboBoxModelPatients( model );
        model = new DefaultComboBoxModel( this.searchAllAppointmentState() );
        this.manageEdit.setJComboBoxModelStatus( model );
    }
    
        public String[] searchAllDoctorModel(){
        
        List<Doctor> list = modelEmployees.searchAllDoctor();
        String [] listReturn = new String[ list.size()+1 ];
        listReturn[ 0 ]="-";
        ListIterator<Doctor> iterator = list.listIterator();
        int i=1;
        while( iterator.hasNext() ){
            Doctor doctor = iterator.next();
          listReturn[ i ]= doctor.getName();
          idsDoctors.addId( doctor.getPersonId() );
          i++;
        }
        
        return listReturn;
    }
    
            
     public String[] searchAllPatientsModel(){
        
        List<Patients> list = modelPatients.searchAllPatient();
        String [] listReturn = new String[ list.size()+1 ];
        listReturn[ 0 ]="-";
        ListIterator<Patients> iterator = list.listIterator();
        int i=1;
        while( iterator.hasNext() ){
            Patients patients = iterator.next();
          listReturn[ i ]= patients.getName();
          idsPatieIds.addId( patients.getPatientsId() );
          i++;
        }
        
        return listReturn;
    }
     
     public String[] searchAllAppointmentState(){
         String [] listResult = {"-","ACTIVE","CANCELED","POSPUSED","NOTASISTED"};
         return listResult;
     }

     @Override
    public void actionPerformed(ActionEvent e) {
                 
        String command = e.getActionCommand();
        
        if( command.equals( "add" ) ){
           this.manageEdit = new ManageAppointnmentsEdit(null, true, this);            
           initComboBox();
           this.manageEdit.showFrame();
           temp = null;
           specificId=0;
        }else if( command.equals( "update" ) ){
            if( specificId != 0){
            this.manageEdit =  new ManageAppointnmentsEdit(null, true, this);
            temp = modelAppointments.getSpecificAppointments(specificId);
            initComboBox();
            this.manageEdit.setAllFields( temp.getPatientName(),temp.getDateRegistered() , temp.getAcordedDate(), temp.getDoctorName(), temp.getStatus().ordinal());
            this.manageEdit.showFrame();
            }else
                JOptionPane.showMessageDialog( null, "No Existe Un Registro Seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
            
        }else if( command.equals( "remove" ) ){

             if( temp !=null ){
                int i = JOptionPane.showConfirmDialog(null, "En Realidad Desea Eliminar El Registro", "Atencion", JOptionPane.OK_OPTION);
                if( i==0 ){
                this.modelAppointments.deleteObject( temp );
                idsPatieIds.removeId( this.manageEdit.getPatientsNamePosition());
                specificId = 0;
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                temp =null;
                }else{
                    JOptionPane.showMessageDialog(null, "Transaccion Cancelada");
                }
            }else{
                JOptionPane.showMessageDialog(null, "No Se Ha Seleccionado Ningun Registro");
            }
            
        }else if( command.equals( "save" ) ){
     
            if( isEmptyFields()){
                JOptionPane.showMessageDialog( null, "Existen Campos En Blancos Por Favor Completar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
               if( temp==null ){
                   if( !this.manageEdit.getDoctorName().equals("-") && !this.manageEdit.getPatientName().equals("-") && !this.manageEdit.getStatusName().equals("-")){
               
               specificId = idsDoctors.getId( this.manageEdit.getDoctorNamePosition());
               this.doctor = modelEmployees.searchDoctorEmployee( specificId );
               this.patients= modelPatients.getPatientsByName( this.manageEdit.getPatientName() );
               specificId = idsPatieIds.getId( this.manageEdit.getPatientsNamePosition());
               this.AcordetDate =  this.manageEdit.getAcordetDate() ;
               this.registerDate = this.manageEdit.getRegisteredDate() ;
               this.enumStatus = this.manageEdit.getStatusName();
               
               this.appointments = new Appointments(registerDate, AcordetDate, patients, doctor, enumStatus);
            
               this.modelAppointments.insertObject( appointments );
               JOptionPane.showMessageDialog( null, "Registro Almacenado ");
               this.manageEdit.dispose();
               
                  }else{
                       javax.swing.JOptionPane.showMessageDialog( null, "error : Existen Malas Entradas Favor Corregirlas" );
                   }
               }else {
                   int i = JOptionPane.showConfirmDialog(null, "Seguro De Querer Alterar La Informacion De Este Registro","Atencion",JOptionPane.OK_OPTION);
                 if( i==0 ){
                specificId = idsDoctors.getId( this.manageEdit.getDoctorNamePosition());
                Doctor t = modelEmployees.searchDoctorEmployee( specificId );
                temp.setDoctor( t );
                temp.setDateRegistered( this.manageEdit.getRegisteredDate() );
                temp.setAcordedDate( this.manageEdit.getAcordetDate() );
                specificId = idsPatieIds.getId( this.manageEdit.getPatientsNamePosition());
                    Patients p = modelPatients.searchPatient( specificId );
                     temp.setPatient( p );
                     temp.setStatus( this.manageEdit.getStatusName() );
                
                      modelAppointments.updateObject( temp );
                   this.manageEdit.dispose();
               }else
                    JOptionPane.showMessageDialog(null, "Tansaccion Cancelada");
               }
               temp = null; 
               specificId=0;
           }
         
        }else if( command.equals( "cancel" ) ){
        int i = JOptionPane.showConfirmDialog( null, " En Realidad Desea Cancelar El registro", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (i == 0) {
                manageEdit.dispose();
                temp = null;
                specificId=0;
            }
            
        }
        }
        public void searchByField(String string) {
        modelSearching.setElements(modelAppointments.serachAllAppointments());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
          if (e.getSource().equals(manageAppointments.getSearching().getTxtSearch())) {
            searchByField(manageAppointments.getSearching().getTxtSearch().getText().toLowerCase());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
                if (e.getSource().equals(manageAppointments.getSearching().getTblResult())) {
            int fila = manageAppointments.getSearching().getTblResult().rowAtPoint(e.getPoint());
            if (fila > -1) {
                specificId = (Long) manageAppointments.getSearching().getTblResult().getValueAt(fila, 0);
                return;
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        searchByField(manageAppointments.getSearching().getTxtSearch().getText().toLowerCase());
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        
    }
     private boolean isEmptyFields() {
        boolean state = false;
        javax.swing.text.JTextComponent textField;
        javax.swing.JComboBox combo;
        String date;


        for (int i = 0; i <= manageEdit.getPnFields().getComponentCount(); i++) {
            try {
                textField = (javax.swing.text.JTextComponent) manageEdit.getPnFields().getComponent(i);
                if (textField.getText().equals("-")) {
                    state = true;
                    textField.requestFocus();
                } else if (textField.getText().indexOf("-") != -1) {
                    String special = textField.getText().trim();
                    if ((special.length() < 12) && (special.length() != 10)) {
                        state = true;
                        textField.requestFocus();
                    }
                }
            } catch (Exception e) {
            
            }
        }
        return state;
    }
    
        
                
}
    

