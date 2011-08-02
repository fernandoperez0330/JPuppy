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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerPatients implements ActionListener, KeyListener, MouseListener {

    private ManagePatients managePatients;
    private ModelPatients modelPatients = new ModelPatients();
    private ModelCustomers modelCustomer = new ModelCustomers();
    DefaultListModel listModel;
    //elementos para la tabla de pacientes
    private List<Long> arrIndexTblPatients;
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
        this.arrIndexTblPatients = new ArrayList<Long>();
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
            String[] rows = {Integer.toString((int) patient.getPatientsId()), patient.getName(), patient.getOwner().getName(), patient.getBirthDate().toString()};
            tableModel.addRow(rows);
            tableModel.isCellEditable(tableModel.getRowCount() - 1, tableModel.getRowCount() - 1);
            this.arrIndexTblPatients.add(patient.getPatientsId());
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
        Patients patient = this.modelPatients.searchPatient(Long.toString(idPatient));
        this.managePatients.getTxtFieldNombre().setText(patient.getName());
        this.managePatients.getTxtFieldDueno().setText(patient.getOwner().getName() + " " + patient.getOwner().getLastName());
        this.managePatients.setIdDueno(patient.getOwner().getPersonId());
        try {
            this.managePatients.getTxtFieldUltimaVisita().setText(patient.getLastVisit().toString());
        } catch (NullPointerException exc) {
            this.managePatients.getTxtFieldUltimaVisita().setText("");
        }
        try {
            this.managePatients.getTxtFieldCumpleano().setText(patient.getBirthDate().toString());
        } catch (NullPointerException exc) {
            this.managePatients.getTxtFieldCumpleano().setText("");
        }
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
                    patients.setName(managePatients.getTxtFieldNombre().getText());
                    patients.setBirthDate(new Date());
                    patients.setNotes(managePatients.getTxtFieldNombre().getText());
                    Customers customer = modelCustomer.searchCustomer(this.managePatients.getIdDueno());
                    patients.setOwner(customer);
                    patients.setDoctorLastVisit("");
                    patients.setLastVisit(new Date());
                    if (modelPatients.insertObject(patients)) {
                        JOptionPane.showMessageDialog(managePatients, MSG_SAVENEW_SUCCESSFULL);
                        this.managePatients.getParent().getjTable1().setModel(this.getTableModelPatients());
                        managePatients.closeFrame();
                    } else {
                        //cuando todos el proceso se ejecuto correctamente
                        JOptionPane.showMessageDialog(managePatients, MSG_SAVENEW_ERROR);
                    }
                }
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
                        this.managePatients.getParent().getjTable1().setModel(this.getTableModelPatients());
                        managePatients.closeFrame();
                    } else {
                        //cuando todos el proceso se ejecuto correctamente
                        JOptionPane.showMessageDialog(managePatients, MSG_SAVEEXISTENT_ERROR);
                    }
                }
            }

        } else if (nameButtonPressed.equals("searchCustomer")) {
            new SearchCustomer(this.managePatients, true).showFrame();
        } else if (nameButtonPressed.equals("cancel")) {
            int respond = JOptionPane.showConfirmDialog(null, "¿Desea Cancelar esta transaccion?", "Cancelar", JOptionPane.OK_CANCEL_OPTION);
            if (respond == 0) {
                this.managePatients.closeFrame();
            }
        } else if (nameButtonPressed.equals("remove")) {
            if (this.managePatients.getjTable1().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "No tiene ningun paciente seleccionado para modificar", "Error", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Opcion en construccion");
            }
        } else if (nameButtonPressed.equals("update")) {
            JTable tablePressed = this.managePatients.getjTable1();
            if (tablePressed.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "No tiene ningun paciente seleccionado para modificar", "Error", JOptionPane.OK_OPTION);
            } else {
                new ManagePatients(managePatients, true, true, arrIndexTblPatients.get(tablePressed.getSelectedRow())).showFrame();
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
                //new ManagePatients(managePatients, true, true,tablePressed.getSelectedColumn()).showFrame();
                new ManagePatients(managePatients, true, true, arrIndexTblPatients.get(tablePressed.getSelectedRow())).showFrame();

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

    
}
