/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.datalayer.Doctor;
import itla.jpuppy.datalayer.Patients;
import itla.jpuppy.forms.ManageAppointnments;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author jansel
 */

    

public class ControllerAppointments implements ActionListener{
    
    private ManageAppointnments manageAppointments=null;
    private Date AcordetDate=null;
    private Date registerDate=null;
    private Doctor doctor = null;
    private Patients patients=null;
    
    public ControllerAppointments(ManageAppointnments aThis) {
            this.manageAppointments = aThis;
            
            
    }
    
    

     @Override
    public void actionPerformed(ActionEvent e) {
                 
        String command = e.getActionCommand();
        
        if( command.equals( "add" ) ){
           this.manageAppointments.eventNew();
           this.manageAppointments.setMessageFind("");
           
        }else if( command.equals( "update" ) ){
            
                this.manageAppointments.eventEdit(this.manageAppointments.getPatientName());
            
        }else if( command.equals( "remove" ) ){
            this.manageAppointments.eventDelete();
          
            
        }else if( command.equals( "save" ) ){
           boolean state= this.manageAppointments.eventSave();
           this.manageAppointments.setMessageFind("");
          
           
        }else if( command.equals( "cancel" ) ){
            this.manageAppointments.eventCancelar();
            this.manageAppointments.setMessageFind("");
            
            
        }else if( command.equals( "search" ) ){
            this.manageAppointments.eventSearch( this.manageAppointments.getPatientName() );
            
            
                    }
        }
        
                
    }
    

