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
import itla.jpuppy.forms.ManageAppointnments;
import itla.jpuppy.utils.enumAppointmentStatus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    

public class ControllerAppointments implements ActionListener{
    
    private ManageAppointnments manageAppointments=null;
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
    
    public ControllerAppointments(ManageAppointnments aThis) {
            this.manageAppointments = aThis;
            this.modelAppointments = new ModelAppointments();
            this.modelEmployees = new ModelEmployees();
            this.modelPatients = new ModelPatients();
      
            initComboBox();
            
    }
    
    
    public void initComboBox(){
        model= new DefaultComboBoxModel( this.searchAllDoctorModel() );
        this.manageAppointments.setJComboBoxModelDoctor( model );
        model = new DefaultComboBoxModel( this.searchAllPatientsModel() );
        this.manageAppointments.setJComboBoxModelPatients( model );
        model = new DefaultComboBoxModel( this.searchAllAppointmentState() );
        this.manageAppointments.setJComboBoxModelStatus( model );
    }
    
        public String[] searchAllDoctorModel(){
        
        List<Doctor> list = modelEmployees.searchAllDoctor();
        String [] listReturn = new String[ list.size()+1 ];
        listReturn[ 0 ]="-";
        ListIterator<Doctor> iterator = list.listIterator();
        int i=1;
        while( iterator.hasNext() ){
          listReturn[ i ]= iterator.next().getName();
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
          listReturn[ i ]= iterator.next().getName();
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
           this.manageAppointments.eventNew();
           this.manageAppointments.setMessageFind("");
           initComboBox();
           temp = null;
        }else if( command.equals( "update" ) ){
            
                this.manageAppointments.eventEdit(this.manageAppointments.getPatientName());
            
        }else if( command.equals( "remove" ) ){
            this.manageAppointments.eventDelete();
               if( temp !=null ){
                this.modelAppointments.deleteObject( temp );
                this.manageAppointments.setMessageFind("");
                temp =null;
            }
            
        }else if( command.equals( "save" ) ){
           boolean state= this.manageAppointments.eventSave();
           this.manageAppointments.setMessageFind("");
           
           
       
          
           if( state ){
               
               if( temp==null ){
                   if( !this.manageAppointments.getDoctorName().equals("-") && !this.manageAppointments.getPatientName().equals("-") && !this.manageAppointments.getStatusName().equals("-")){
                       
               this.doctor = modelEmployees.getDoctorByName( this.manageAppointments.getDoctorName() );
               this.patients= modelPatients.getPatientsByName( this.manageAppointments.getPatientName() );
               this.AcordetDate =  this.manageAppointments.getAcordetDate() ;
               this.registerDate = this.manageAppointments.getRegisteredDate() ;
               this.enumStatus = this.manageAppointments.getStatusName();
               
               this.appointments = new Appointments(registerDate, AcordetDate, patients, doctor, enumStatus);
            
               this.modelAppointments.insertObject( appointments );
               JOptionPane.showConfirmDialog( null, "appointments saved ");
                  }else{
                       javax.swing.JOptionPane.showMessageDialog( null, "error : cannot save register,Specie field is empty or bad input" );
                   }
               }else {
                   Doctor t = modelEmployees.getDoctorByName( this.manageAppointments.getDoctorName() );
                temp.setDoctor( t );
                temp.setDateRegistered( this.manageAppointments.getRegisteredDate() );
                temp.setAcordedDate( this.manageAppointments.getAcordetDate() );
                    Patients p = modelPatients.getPatientsByName( this.manageAppointments.getPatientName() );
                     temp.setPatient( p );
                temp.setStatus( this.manageAppointments.getStatusName() );
                
                   modelAppointments.updateObject( temp );
               }
               
               temp = null; 
           }
          
          
           
        }else if( command.equals( "cancel" ) ){
            this.manageAppointments.eventCancelar();
            this.manageAppointments.setMessageFind("");
            temp = null;
            
        }else if( command.equals( "search" ) ){
            this.manageAppointments.eventSearch( this.manageAppointments.getPatientName() );
            
              if( !this.manageAppointments.getPatientName().equals("-") ){
            temp = this.modelAppointments.getSpecificAppointments(this.manageAppointments.getPatientName() );
            //this.manageAppointments.setMessageFind("<html><font size=+0.5 color=red>Se han seleccionado "+this.listSearched.size()+" registros </font></html>");
            try{
            if( temp!=null )     
            this.manageAppointments.setAllFields( temp.getPatientName(),temp.getDateRegistered() , temp.getAcordedDate(), temp.getDoctorName(), temp.getStatus().ordinal());
            else
                JOptionPane.showMessageDialog(null,"there are no appointments for the patient "+this.manageAppointments.getPatientName());
                    }catch( Exception eh){
                
            }
                    }
            
                    }
        }
        
                
}
    

