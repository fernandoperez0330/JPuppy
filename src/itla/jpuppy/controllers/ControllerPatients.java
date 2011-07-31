package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.business.ModelPatients;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.datalayer.Patients;
import itla.jpuppy.forms.ManagePatients;
import itla.jpuppy.utils.GeneralVaribleID;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerPatients extends Controller implements ActionListener{
    
    ManagePatients managePatients;
    ModelPatients modelPatients = new ModelPatients(); 
    ModelCustomers modelCustomer = new ModelCustomers();
    
    private final String MSG_EMPTY_NAME = "El nombre esta en blanco";
    private final String MSG_EMPTY_BIRTHDATE = "El Cumpleaños esta en blanco";
    private final String MSG_SAVE_SUCCESSFULL = "El paciente esta agregado correctamente";
    private final String MSG_ERROR_SUCCESSFULL = "El paciente NO se ha podido agregar, verifque nuevamente";
    private final String MSG_CUSTOMER_NOEXIST = "Este cliente no existe en el sistema";
    
    
    public ControllerPatients(ManagePatients managePatients){
        this.managePatients = managePatients;
    }
    
    public DefaultTableModel getTableModelPatients(){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Cliente Propietario");
        tableModel.addColumn("Cumpleaños");
        List<Patients> arrPatients = modelPatients.searchAllPatientByName("");
        for(Patients patient:arrPatients){
            String[] rows = {Integer.toString((int)patient.getPatientsId()),patient.getName(),patient.getOwner().getName(),patient.getBirthDate().toString()};
            tableModel.addRow(rows);
        }
        return tableModel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonPressed = (JButton) e.getSource();
        String nameButtonPressed = buttonPressed.getName();
        //cambiar
        int customerId = 1; 
        if (nameButtonPressed.equals("save")){
            if (managePatients.getTxtFieldNombre().getText().equals("")){
                JOptionPane.showMessageDialog(managePatients,MSG_EMPTY_NAME);
                managePatients.getTxtFieldNombre().requestFocus();                  
            }
            else if(managePatients.getTxtFieldCumpleano().getText().equals("")){
                JOptionPane.showMessageDialog(managePatients,MSG_EMPTY_BIRTHDATE);
                managePatients.getTxtFieldCumpleano().requestFocus();
            }else if(managePatients.getTxtFieldDueno().getText().equals("")){
                JOptionPane.showMessageDialog(managePatients,MSG_EMPTY_NAME);
            }else{ 
                System.out.println(modelCustomer.searchCustomer(customerId));
                Patients patients =  modelPatients.getPatient();
                patients.setName(managePatients.getTxtFieldNombre().getText());
                patients.setBirthDate(new Date());
                patients.setNotes(managePatients.getTxtFieldNombre().getText());
                GeneralVaribleID gen = new GeneralVaribleID();
                gen.setCustomerID(1);
                modelCustomer.searchCustomer(gen.getCustomerID());
                Customers customer = modelCustomer.searchCustomer(1);
                
                patients.setOwner(customer);
                patients.setDoctorLastVisit("");
                patients.setLastVisit(new Date());
                if (modelPatients.insertObject(patients)) {
                    JOptionPane.showMessageDialog(managePatients,MSG_SAVE_SUCCESSFULL); 
                    managePatients.closeFrame();
                }else 
                    JOptionPane.showMessageDialog(managePatients,MSG_ERROR_SUCCESSFULL); 
            }
        }else if (nameButtonPressed.equals("cancel")){
            System.out.println("ha cancelado");
        }else if (nameButtonPressed.equals("search")){
            System.out.println("ha buscado");
        }else if (nameButtonPressed.equals("update")){
            System.out.println("ha actualizado");
        }
    }
}
