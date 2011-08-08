package itla.jpuppy.models;

import itla.jpuppy.business.ModelAppointments;
import itla.jpuppy.business.ModelConsultations;
import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.business.ModelPatients;
import itla.jpuppy.datalayer.Consultations;
import itla.jpuppy.forms.EditConsultations;
import itla.jpuppy.forms.ManageConsultations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlEditConsultations implements ActionListener {

    private EditConsultations ec = null;
    DefaultTableModel temp;
    private List<Consultations> list = null;
    
    public ControlEditConsultations(EditConsultations ec) {
        this.ec = ec;
        temp = (DefaultTableModel) new ManageConsultations().getTableConsultations().getModel();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String comando = ae.getActionCommand();
        if (comando.equals(ec.getActionCommandSv())) {
            boolean insertObject;
            String[] name = ec.getjComboBox2().getSelectedItem().toString().split("\\ ");
            try {
                ec.getConsultation().setDateStart(ec.getDateStart());
                ec.getConsultation().setDateEnd(ec.getDateEnd());
                ec.getConsultation().setCustomer(new ModelCustomers().getCustomer(name[0]));
                ec.getConsultation().setPatients(new ModelPatients().getPatientsByName(ec.getjComboBox3().getSelectedItem().toString()));
                ec.getConsultation().setRemark(ec.getjTextArea1().getText());
                ec.getConsultation().setAppointments(new ModelAppointments().getSpecificAppointments(ec.getjComboBox3().getSelectedItem().toString()));
                ec.getConsultation().setTypeConsultations(ec.getjComboBox1().getSelectedItem().toString());
                
                insertObject = new ModelConsultations().updateObject(ec.getConsultation());
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
                ec.closeFrame();
                
                //Refresca la tabla con las consultas almacenadas
                temp.setRowCount(0);
                list = new ModelConsultations().getConsultations();
                for (Consultations value : list) {
                    //System.out.println(new ModelCustomers().searchCustomer(value.getCustomer().getPersonId()).getName());
                    String user = new ModelCustomers().searchCustomer(value.getCustomer().getPersonId()).getName() + " " + new ModelCustomers().searchCustomer(value.getCustomer().getPersonId()).getLastName();
                    Object[] nuevo = {value.getId(), value.getTypeConsultations(), user, new ModelPatients().searchPatient(value.getPatients().getPatientsId()).getName()};
                    temp.addRow(nuevo);
                }
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
