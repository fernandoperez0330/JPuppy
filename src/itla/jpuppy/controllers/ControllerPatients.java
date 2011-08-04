package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.business.ModelPatients;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.datalayer.Patients;
import itla.jpuppy.forms.ManagePatients;
import itla.jpuppy.forms.SearchCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerPatients extends Controller implements ActionListener, KeyListener, MouseListener {

    private ManagePatients managePatients;
    private ModelPatients modelPatients = new ModelPatients();
    private ModelCustomers modelCustomer = new ModelCustomers();
    DefaultListModel listModel;
    //elementos para la tabla de pacientes
    private List<Long> arrIndexTblPatients = null;
    //elementos de la ventana searchcustomer para pacientes
    private JList ListCustomertoSearch;
    private SearchCustomer searchCustomer;
    private List<Long> arrIndexCustomers;
    private final String MSG_EMPTY_NAME = "El nombre esta en blanco";
    private final String MSG_EMPTY_BIRTHDATE = "El Cumpleaños esta en blanco";
    private final String MSG_SAVENEW_SUCCESSFULL = "El paciente esta agregado correctamente";
    private final String MSG_SAVENEW_ERROR = "El paciente NO se ha podido agregar, verifque nuevamente";
    private final String MSG_CUSTOMER_NOEXIST = "Este cliente no existe en el sistema";
    
    private final String MSG_SAVEEXISTENT_SUCCESSFULL = "El paciente se ha podido modificado correctamente";
    private final String MSG_SAVEEXISTENT_ERROR = "El paciente No se ha podido modificar, favor intentar nuevamente";

    public ControllerPatients(ManagePatients managePatients) {
        this.managePatients = managePatients;
    }
    
    public DefaultTableModel getTableModelPatients() {
        if (arrIndexTblPatients == null) arrIndexTblPatients = new ArrayList<Long>();
        else arrIndexTblPatients.clear();
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rows, int columns) {
                return false;
            }
        };
        tableModel.addColumn("Id");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Cliente Propietario");
        tableModel.addColumn("Cumpleaño");
        List<Patients> arrPatients = modelPatients.searchAllPatientByName("%%");
        for (Patients patient : arrPatients) {
            //formato a la fecha para mostrarla
            String[] rows = {Integer.toString((int) patient.getPatientsId()), patient.getName(), patient.getOwner().getName(),new SimpleDateFormat().format(patient.getBirthDate())};
            tableModel.addRow(rows);
            tableModel.isCellEditable(tableModel.getRowCount() - 1, tableModel.getRowCount() - 1);
            arrIndexTblPatients.add(patient.getPatientsId());
        }
        return tableModel;
    }

    public DefaultListModel getModelCustomerbyName(String name) {
        listModel = new DefaultListModel();
        List<Customers> arrCustomers = modelCustomer.searchAllCustomerByName("%" + name + "%");
        arrIndexCustomers = new ArrayList<Long>();
        for (Customers customer : arrCustomers) {
            listModel.addElement(Long.toString(customer.getPersonId()) + " - " + customer.getName());
            //arreglo de los id del cliente 
            arrIndexCustomers.add(customer.getPersonId());
        }
        return listModel;
    }

    public JList getListCustomertoSearch() {
        return ListCustomertoSearch;
    }

    public void setListCustomertoSearch(JList ListCustomertoSearch) {
        this.ListCustomertoSearch = ListCustomertoSearch;
    }

    public SearchCustomer getSearchCustomer() {
        return searchCustomer;
    }

    public void setSearchCustomer(SearchCustomer searchCustomer) {
        this.searchCustomer = searchCustomer;
    }

    public void findPatient(Long idPatient) {
        Patients patient = this.modelPatients.searchPatient(idPatient);
        //rellenar el campo el nombre
        managePatients.getTxtFieldNombre().setText(patient.getName());
        //rellenar el campo dueno (solo para muestra)
        managePatients.getTxtFieldDueno().setText(patient.getOwner().getName() + " " + patient.getOwner().getLastName());
        //rellenar el campo id del dueno
        managePatients.setIdDueno(patient.getOwner().getPersonId());
        //rellenar el campo de cumpleanos
        GregorianCalendar dateBirthDate = new GregorianCalendar();
        dateBirthDate.setTime(patient.getBirthDate());
        managePatients.getTxtFieldCumpleano().setSelectedDate(dateBirthDate);
        
        //rellenar la ultima visita
        GregorianCalendar dateLastVisit = new GregorianCalendar();
        try{
        dateLastVisit.setTime(patient.getLastVisit());
        managePatients.getTxtFieldUltimaVisita().setSelectedDate(dateLastVisit);
        }catch (NullPointerException exc) {}
        
        
        
        //poner el doctor que lo visito
        this.managePatients.getTxtFieldUltimaVisitaDoctor().setText(patient.getDoctorLastVisit());
        
        
        //rellenar las notas
        this.managePatients.getjTextAreNota().setText(patient.getNotes());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonPressed = (JButton) e.getSource();
        String nameButtonPressed = buttonPressed.getName();

        if (nameButtonPressed.equals("add")) {
            /*Cuando es para agregar un nuevo paciente */
            new ManagePatients(this.managePatients, true, true).showFrame();
        } else if (nameButtonPressed.equals("save")) {
            if (this.managePatients.getPatientId() == null) {
                /* 
                 * --------------------------------------
                 * Cuando es para grabar un nuevo paciente 
                 * --------------------------------------
                 */
                try{
                    if (managePatients.getTxtFieldNombre().getText().equals("")) {
                        JOptionPane.showMessageDialog(managePatients, MSG_EMPTY_NAME);
                        managePatients.getTxtFieldNombre().requestFocus();
                    } else if (managePatients.getTxtFieldCumpleano().getText().equals("")) {
                        JOptionPane.showMessageDialog(managePatients, MSG_EMPTY_BIRTHDATE);
                        managePatients.getTxtFieldCumpleano().requestFocus();
                    } else if (managePatients.getTxtFieldDueno().getText().equals("") && managePatients.getIdDueno().equals("")) {
                        JOptionPane.showMessageDialog(managePatients, MSG_EMPTY_NAME);
                        managePatients.getTxtFieldDueno().requestFocus();
                    } else {
                        Patients  patient = modelPatients.getPatient();
                        patient.setName(managePatients.getTxtFieldNombre().getText());
                        patient.setBirthDate(new Date(managePatients.getTxtFieldCumpleano().getSelectedDate().getTimeInMillis()));
                        patient.setNotes(managePatients.getjTextAreNota().getText());
                        Customers customer = modelCustomer.searchCustomer(this.managePatients.getIdDueno());
                        patient.setOwner(customer);
                        patient.setDoctorLastVisit(managePatients.getTxtFieldUltimaVisitaDoctor().getText());
                        patient.setLastVisit(new Date(managePatients.getTxtFieldUltimaVisita().getSelectedDate().getTimeInMillis()));
                        
                        
                        if (modelPatients.insertObject(patient)) {
                            JOptionPane.showMessageDialog(managePatients, MSG_SAVENEW_SUCCESSFULL);
                            managePatients.getParent().getjTable1().setModel(managePatients.getParent().getController().getTableModelPatients());
                            managePatients.closeFrame();
                        } else {
                            //cuando todos el proceso se ejecuto correctamente
                            JOptionPane.showMessageDialog(managePatients, MSG_SAVENEW_ERROR);
                        }
                    }
                }catch(NullPointerException exc) { JOptionPane.showMessageDialog(managePatients,"Ocurrio un problema al agregar el paciente, favor intente de nuevo") ; }
            }else{
                /* 
                 * --------------------------------------
                 * Cuando es para modificar un paciente existente
                 * --------------------------------------
                 */
                if (managePatients.getTxtFieldNombre().getText().equals("")) {
                    JOptionPane.showMessageDialog(managePatients, MSG_EMPTY_NAME);
                    managePatients.getTxtFieldNombre().requestFocus();
                } else if (managePatients.getTxtFieldCumpleano().getText().equals("")) {
                    JOptionPane.showMessageDialog(managePatients, MSG_EMPTY_BIRTHDATE);
                    managePatients.getTxtFieldCumpleano().requestFocus();
                } else if (managePatients.getTxtFieldDueno().getText().equals("") && managePatients.getIdDueno().equals("")) {
                    JOptionPane.showMessageDialog(managePatients, MSG_EMPTY_NAME);
                    managePatients.getTxtFieldDueno().requestFocus();
                } else {
                    Patients patients = modelPatients.getPatient();
                    patients.setPatientsId(this.managePatients.getPatientId());
                    patients.setName(managePatients.getTxtFieldNombre().getText());
                    patients.setBirthDate(new Date());
                    patients.setNotes(managePatients.getTxtFieldNombre().getText());
                    Customers customer = modelCustomer.searchCustomer(this.managePatients.getIdDueno());
                    patients.setOwner(customer);
                    patients.setDoctorLastVisit("");
                    patients.setLastVisit(new Date());
                    if (modelPatients.updateObject(patients)) {
                        JOptionPane.showMessageDialog(managePatients, MSG_SAVEEXISTENT_SUCCESSFULL);
                        this.managePatients.getParent().getjTable1().setModel(this.managePatients.getParent().getController().getTableModelPatients());
                        managePatients.closeFrame();
                    } else {
                        //cuando todos el proceso se ejecuto con errores
                        JOptionPane.showMessageDialog(managePatients, MSG_SAVEEXISTENT_ERROR);
                    }
                }
            }

        } else if (nameButtonPressed.equals("searchCustomer")) {
            new SearchCustomer(this.managePatients, true).showFrame();
        }else if (nameButtonPressed.equals("exit")) {
            this.managePatients.closeFrame();
        } else if (nameButtonPressed.equals("cancel")) {
            int respond = JOptionPane.showConfirmDialog(null, "¿Desea Cancelar esta transaccion?", "Cancelar", JOptionPane.OK_CANCEL_OPTION);
            if (respond == 0) {
                this.managePatients.closeFrame();
            }
        } else if (nameButtonPressed.equals("remove")) {
            if (this.managePatients.getjTable1().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "No tiene ningun paciente seleccionado para modificar", "Error", JOptionPane.OK_OPTION);
            } else {
                if (JOptionPane.showConfirmDialog(null,"¿Desea realmente borrar este paciente?","Eliminar Paciente",JOptionPane.YES_NO_OPTION) == 0){
                    //eliminar los pacientes
                    Patients entPatient = null;
                    try{   
                        entPatient = modelPatients.searchPatient(arrIndexTblPatients.get(managePatients.getjTable1().getSelectedRow()));
                        modelPatients.deleteObject(entPatient);
                    }
                    catch(Exception exc){ System.out.println("Error: " + exc.getMessage() + ", Cause: " + exc.getCause()); }
                    //cuando el paciente ha sido eliminado correctamente
                    if (entPatient != null)
                        JOptionPane.showMessageDialog(null,"El paciente ha sido eliminado correctamente");
                    else 
                        JOptionPane.showMessageDialog(null,"El paciente no se ha podido eliminar, favor intentar nuevamente");
                    //actualizar la tabla donde se lista los pacientes
                    managePatients.getjTable1().setModel(this.getTableModelPatients());
                }
            }
        } else if (nameButtonPressed.equals("update")) {
            JTable tablePressed = this.managePatients.getjTable1();
            if (tablePressed.getSelectedRow() == -1) {
                //cuando no tiene nigun elemento seleccionado
                JOptionPane.showMessageDialog(null, "No tiene ningun paciente seleccionado para modificar", "Error", JOptionPane.OK_OPTION);
            } else {
                try{
                    new ManagePatients(managePatients, true, true, arrIndexTblPatients.get(tablePressed.getSelectedRow())).showFrame();
                }catch (IndexOutOfBoundsException exc){}    
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        JTextField inputPressed = (JTextField) e.getSource();
        if (inputPressed.getName().equals("textSearchCustomer")) {
            this.ListCustomertoSearch.setModel(this.getModelCustomerbyName(inputPressed.getText()));;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //cuando clickean 2 veces un elemento
        int clickCount = e.getClickCount();
        if (clickCount == 2) {
            JComponent objPressed = (JComponent) e.getSource();
            //listener de la table de pacientes
            String objName = "";
            try {
                objName = objPressed.getName();
            } catch (Exception exc) {
            }

            if (objName.equals("tablePatients")) {
                JTable tablePressed = (JTable) objPressed;
                Long idPatients = null;
                try{
                   idPatients = arrIndexTblPatients.get(tablePressed.getSelectedRow());
                }catch (Exception exc){ 
                    System.out.println("Error: " + exc.getMessage() + ", Cause: " + exc.getCause());
                }
                new ManagePatients(managePatients, true, true,idPatients).showFrame();
                //listener de la table de clientes para los pacientes
            } else if (objName.equals("listCustomer")) {
                JList listPressed = (JList) objPressed;
                Customers customer = modelCustomer.searchCustomer(arrIndexCustomers.get(listPressed.getSelectedIndex()));
                this.managePatients.setIdDueno(customer.getPersonId());
                //poner el nombre y el apellido en el campo del dueno
                this.managePatients.getTxtFieldDueno().setText(customer.getName() + " " + customer.getLastName());
                this.getSearchCustomer().closeFrame();
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
    public void eventDelete() {
    }

    @Override
    public void eventSearch(String text) {}

    @Override
    public boolean eventSave() {
        return false;
    }
}
