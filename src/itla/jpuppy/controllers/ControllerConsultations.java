package itla.jpuppy.controllers;

import itla.jpuppy.business.*;
import itla.jpuppy.datalayer.Consultations;
import itla.jpuppy.forms.EditConsultations;
import itla.jpuppy.forms.ManageConsultations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ControllerConsultations implements ActionListener {

    private ManageConsultations manageConsultations = null;
    //private List<Consultations> list = null;
    DefaultTableModel temp;

    public ControllerConsultations(ManageConsultations mc) {
        this.manageConsultations = mc;
        temp = (DefaultTableModel) manageConsultations.getTableConsultations().getModel();
    }

    public ControllerConsultations() {
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
                            //System.out.println(new ModelPatients().searchAllPatientByName(manageConsultations.getCbPatientConsultations().getSelectedItem().toString()).get(0));
                            boolean insertObject;
                            String[] name = manageConsultations.getCbCustomerConsultations().getSelectedItem().toString().split("\\ ");
                            try {
                                insertObject = new ModelConsultations().insertObject(new Consultations(
                                        new Date(manageConsultations.getDateChooserBeginConsultations().getSelectedDate().getTimeInMillis()),
                                        new Date(manageConsultations.getDateChooserEndConsultations().getSelectedDate().getTimeInMillis()),
                                        new ModelCustomers().getCustomer(name[0]),
                                        new ModelPatients().getPatientsByName(manageConsultations.getCbPatientConsultations().getSelectedItem().toString()),
                                        manageConsultations.getTxtRemarkConsultations().getText(),
                                        new ModelAppointments().getSpecificAppointments(manageConsultations.getCbPatientConsultations().getSelectedItem().toString()),
                                        manageConsultations.getCbTypeConsultations().getSelectedItem().toString()));
                            } catch (Exception ecp) {
                                //ecp.printStackTrace();
                                insertObject = false;
                            }
                            if (insertObject) {
                                //Llenar el JTable de los datos existentes
                                //ESTO ESTA EN PRUEBA
                                Object[] nuevo = {new ModelConsultations().getConsultationID(), manageConsultations.getCbTypeConsultations().getSelectedItem().toString(), manageConsultations.getCbCustomerConsultations().getSelectedItem().toString(), manageConsultations.getCbPatientConsultations().getSelectedItem().toString()};
                                //System.out.println(value.getBreedsName());
                                this.addToTable(nuevo);

                                JOptionPane.showMessageDialog(null, "La consulta fue agregada exitosamente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "La consulta no pudo ser agregada !", "Informacion", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }
        } else if (comando.equals(manageConsultations.getActionCommandRemove())) {
            int delets = 0;
            boolean status = false;
            for (int b = 0; b < manageConsultations.getList().size(); b++) {
                Boolean test1 = (Boolean) manageConsultations.getTableConsultations().getValueAt(b, 4);
                if (test1 == null) {
                    status = false;
                    continue;
                } else if (test1 == true) {
                    status = true;
                    break;
                } else {
                    status = false;
                    continue;
                }
            }
            if (status == true) {
                if (JOptionPane.showConfirmDialog(null, "¿Desea realmente borrar esta(s) consulta(s)?", "Eliminar consulta:", JOptionPane.YES_NO_OPTION) == 0) {
                    for (int a = 0; a < manageConsultations.getList().size(); a++) {
                        Object val = manageConsultations.getTableConsultations().getValueAt(a, 4);
                        if (val instanceof Boolean) {
                            Boolean test = (Boolean) val;
                            if (test == true) {
                                //System.out.println(new ModelConsultations().getConsultationsByID(Long.parseLong(String.valueOf(manageConsultations.getTableConsultations().getValueAt(a, 0)))).getRemark());;
                                //Elimina la consulta
                                if (new ModelConsultations().deleteObject(new ModelConsultations().getConsultationsByID(Long.parseLong(String.valueOf(manageConsultations.getTableConsultations().getValueAt(a, 0)))))) {
                                    delets = delets + 1;
                                    //manageConsultations.getTableConsultations().remove(a);

                                    //temp.setRowCount(manageConsultations.getTableConsultations().getSelectedRow());
                                }

//                                //System.out.println(manageSpecies.getJTableBreeds().getValueAt(a, 0).toString() +" - "+ manageSpecies.getJTableBreeds().getValueAt(a, 2).toString() +" - "+ manageSpecies.getJTableBreeds().getValueAt(a, 3).toString());
//                                breeds = queryManager.searchBreeds(manageSpecies.getJTableBreeds().getValueAt(a, 0).toString(), String.valueOf(manageSpecies.getJTableBreeds().getValueAt(a, 2)));
//                                //, Double.valueOf(String.valueOf(manageSpecies.getJTableBreeds().getValueAt(a, 2)))
//                                //System.out.println(breeds.getBreedsId());
//                                listBreeds.add(breeds);
                            }
                        }
                    }
                    if (delets > 0) {
                        String MSG = delets + " consulta(s) eliminada(s) exitosamente!";
                        JOptionPane.showMessageDialog(null, MSG, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Favor selecciona las consultas que deseas eliminar!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (comando.equals(manageConsultations.getActionCommandUpd())) {
            //System.out.println();
            if (manageConsultations.getTableConsultations().getSelectedRow() == -1 || manageConsultations.getTableConsultations().getSelectedRows().length > 1) {
                JOptionPane.showMessageDialog(null, "Favor selecciona la consulta que sera editada!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Object[] values = {
                    manageConsultations.getTableConsultations().getValueAt(manageConsultations.getTableConsultations().getSelectedRow(), 1),
                    manageConsultations.getTableConsultations().getValueAt(manageConsultations.getTableConsultations().getSelectedRow(), 2),
                    manageConsultations.getTableConsultations().getValueAt(manageConsultations.getTableConsultations().getSelectedRow(), 3),
                    new ModelConsultations().getConsultationsByID(Long.parseLong(String.valueOf(manageConsultations.getTableConsultations().getValueAt(manageConsultations.getTableConsultations().getSelectedRow(), 0)))).getRemark()
                };
                new EditConsultations(null, true, manageConsultations.getTableConsultations().getValueAt(manageConsultations.getTableConsultations().getSelectedRow(), 0), values).showFrame();
            }

        } else if (comando.equals(manageConsultations.getActionCommandCancel())) {
            manageConsultations.closeFrame();
        } else if (comando.equals(manageConsultations.getActionCommandSearchCus())) {
            if (manageConsultations.getTxtCustomerName().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Favor inserta el cliente que deseas buscar!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                List<Consultations> nuevos = new ModelConsultations().getConsultationsByName("%" + manageConsultations.getTxtCustomerName().getText().toLowerCase() + "%");
                //System.out.println(nuevos.size());
                if (nuevos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se han encontrado consultas de este cliente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    temp.setRowCount(0);
                    //System.out.println(nuevos.size());
                    for (Consultations value : nuevos) {
                        String user = new ModelCustomers().searchCustomer(value.getCustomer().getPersonId()).getName() + " " + new ModelCustomers().searchCustomer(value.getCustomer().getPersonId()).getLastName();
                        Object[] found = {value.getId(), value.getTypeConsultations(), user, new ModelPatients().searchPatient(value.getPatients().getPatientsId()).getName()};
                        this.addToTable(found);
                    }
                }
            }
            //System.out.println("Funciona: "+ manageConsultations.getTxtCustomerName().getText());

            //System.out.println(value.getBreedsName());


            //Llena la tabla de las consultas almacenadas
//            list = new ModelConsultations().getConsultations();
//            for (Consultations value : list) {
//                //System.out.println(new ModelCustomers().searchCustomer(value.getCustomer().getPersonId()).getName());
//                DefaultTableModel temp = (DefaultTableModel) this.getTableConsultations().getModel();
//                String user = new ModelCustomers().searchCustomer(value.getCustomer().getPersonId()).getName() + " " + new ModelCustomers().searchCustomer(value.getCustomer().getPersonId()).getLastName();
//                Object[] nuevo = {value.getId(), value.getTypeConsultations(), user, new ModelPatients().searchPatient(value.getPatients().getPatientsId()).getName()};
//                temp.addRow(nuevo);
//            }
        }
    }

    public void addToTable(Object[] nuevo) {
        DefaultTableModel temp = (DefaultTableModel) manageConsultations.getTableConsultations().getModel();
        temp.addRow(nuevo);
    }
}