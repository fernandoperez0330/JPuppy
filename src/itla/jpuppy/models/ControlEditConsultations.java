package itla.jpuppy.models;

import itla.jpuppy.business.ModelAppointments;
import itla.jpuppy.business.ModelConsultations;
import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.business.ModelPatients;
import itla.jpuppy.datalayer.Appointments;
import itla.jpuppy.datalayer.Consultations;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.datalayer.Patients;
import itla.jpuppy.forms.EditConsultations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControlEditConsultations implements ActionListener {

    private EditConsultations ec = null;


    public ControlEditConsultations(EditConsultations ec) {
        this.ec = ec;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String comando = ae.getActionCommand();
        if (comando.equals(ec.getActionCommandSv())) {
            boolean insertObject;
            String[] name = ec.getjComboBox2().getSelectedItem().toString().split("\\ ");
            try {
                insertObject = new ModelConsultations().updateObject(new Consultations(
                        ec.getDateStart(),
                        ec.getDateEnd(),
                        new ModelCustomers().getCustomer(name[0]),
                        new ModelPatients().getPatientsByName(ec.getjComboBox3().getSelectedItem().toString()),
                        ec.getjTextArea1().getText(),
                        new ModelAppointments().getSpecificAppointments(ec.getjComboBox3().getSelectedItem().toString()),
                        ec.getjComboBox1().getSelectedItem().toString()));
            } catch (Exception ecp) {
                //ecp.printStackTrace();
                insertObject = false;
            }
            if (insertObject) {
                //Llenar el JTable de los datos existentes
                //ESTO ESTA EN PRUEBA
//                Object[] nuevo = {new ModelConsultations().getConsultationID(), manageConsultations.getCbTypeConsultations().getSelectedItem().toString(), manageConsultations.getCbCustomerConsultations().getSelectedItem().toString(), manageConsultations.getCbPatientConsultations().getSelectedItem().toString()};
//                //System.out.println(value.getBreedsName());
//                this.addToTable(nuevo);
//
//                //Resetea los campos
//                manageConsultations.getTxtRemarkConsultations().setText(null);
                //new EditConsultations(null, true, null).closeFrame();
                JOptionPane.showMessageDialog(null, "La consulta fue modificada exitosamente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La consulta no pudo ser modificada!", "Informacion", JOptionPane.ERROR_MESSAGE);
            }
        } else if (comando.equals(ec.getActionCommandCn())) {
            int respond = JOptionPane.showConfirmDialog(null, "¿Desea Cancelar esta modificacion?", "Cancelar", JOptionPane.OK_CANCEL_OPTION);
            if (respond == 0) {
                ec.closeFrame();
            }
        }
    }
}
