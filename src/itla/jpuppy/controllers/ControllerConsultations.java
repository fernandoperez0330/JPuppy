package itla.jpuppy.controllers;

import itla.jpuppy.business.*;
import itla.jpuppy.datalayer.Appointments;
import itla.jpuppy.datalayer.Consultations;
import itla.jpuppy.forms.ManageConsultations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
            if (manageConsultations.getCbCustomerConsultations().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Seleccione el cliente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (manageConsultations.getCbPatientConsultations().getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Selecione el paciente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (manageConsultations.getCbTypeConsultations().getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null, "Selecione el tipo de consulta!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (manageConsultations.getTxtRemarkConsultations().getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "El campo observacion es requerido!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            System.out.println(new ModelPatients().searchAllPatientByName(manageConsultations.getCbPatientConsultations().getSelectedItem().toString()).get(0));
                            boolean insertObject;
                            try {
                                insertObject = new ModelConsultations().insertObject(new Consultations(
                                        new Date(manageConsultations.getDateChooserBeginConsultations().getSelectedDate().getTimeInMillis()),
                                        new Date(manageConsultations.getDateChooserEndConsultations().getSelectedDate().getTimeInMillis()),
                                        new ModelCustomers().getCustomer(manageConsultations.getCbCustomerConsultations().getSelectedItem().toString()),
                                        new ModelPatients().getPatientsByName(manageConsultations.getCbPatientConsultations().getSelectedItem().toString()),
                                        manageConsultations.getTxtRemarkConsultations().getText(),
                                        new ModelAppointments().getSpecificAppointments(manageConsultations.getCbPatientConsultations().getSelectedItem().toString()),
                                        manageConsultations.getCbTypeConsultations().getSelectedItem().toString()));
                            } catch (Exception ecp) {
                                //ecp.printStackTrace();
                                insertObject = false;
                            }
                            if (insertObject) {
                                JOptionPane.showMessageDialog(null, "La consulta fue agregada exitosamente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "La consulta no pudo ser agregada !", "Informacion", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }
        }
    }
}