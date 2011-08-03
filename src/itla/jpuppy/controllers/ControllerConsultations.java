package itla.jpuppy.controllers;

import itla.jpuppy.business.*;
import itla.jpuppy.datalayer.Appointments;
import itla.jpuppy.datalayer.Consultations;
import itla.jpuppy.forms.ManageConsultations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerConsultations implements ActionListener {

    private ManageConsultations manageConsultations = null;

    public ControllerConsultations(ManageConsultations mc) {
        this.manageConsultations = mc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals(manageConsultations.getActionCommandAdd())) {
            if (manageConsultations.getCbCustomerConsultations().getSelectedItem().toString().equals("-")) {
                JOptionPane.showMessageDialog(null, "Seleccione el cliente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (manageConsultations.getCbPatientConsultations().getSelectedItem().toString().equals("-")) {
                    JOptionPane.showMessageDialog(null, "Selecione el paciente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (manageConsultations.getCbTypeConsultations().getSelectedItem().toString().equals("-")) {
                        JOptionPane.showMessageDialog(null, "Selecione el tipo de consulta!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (manageConsultations.getTxtRemarkConsultations().getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "El campo observacion es requerido!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        } else {
//                            new ModelConsultations().insertObject(
//                            new Consultations(
//                                    //manageConsultations.getDateChooserBeginConsultations().getText(), 
//                                    //manageConsultations.getDateChooserEndConsultations().getText(), 
//                                    //new ModelCustomers().getCustomer(manageConsultations.getCbCustomerConsultations().getSelectedItem().toString()), 
//                                    //new ModelPatients().searchAllPatientByName(manageConsultations.getCbPatientConsultations().getSelectedItem().toString()).get(0), 
//                                    //manageConsultations.getTxtRemarkConsultations().getText(), 
//                                    
//                                    //SE DEBE COMPLETAR EL MODELO
//                                    //new ModelAppointments(), 
//                                    
//                                    //COMO SE OBTIENE UN OBJETO DE ESTE TIPO?
//                                    //new TypeConsultations())
//                             );
                        }
                    }
                }
            }
        }
    }
}