/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelArticles;
import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.business.ModelInvoice;
import itla.jpuppy.datalayer.Articles;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.datalayer.Invoice;
import itla.jpuppy.datalayer.Persons;
import itla.jpuppy.forms.HomeFrame;
import itla.jpuppy.forms.InvoiceMenu;
import itla.jpuppy.forms.JSearching;
import itla.jpuppy.forms.SearchPersons;
import itla.jpuppy.models.SearchingCtrlArticles;
import itla.jpuppy.models.SearchingModel;
import itla.jpuppy.utils.GeneratedValues;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerInvoices implements ActionListener, KeyListener, MouseListener, WindowFocusListener {

    private InvoiceMenu invoice;
    private SearchingModel<Articles> modelSearching;
    private SearchingModel<Articles> myInvoice;
    private ModelArticles mdlArticles;
    private ModelInvoice mdlInvoice;
    private Customers tempCustomer;
    private Date now;

    public ControllerInvoices(InvoiceMenu invoice) {
        this.invoice = invoice;
        modelSearching = new SearchingModel<Articles>(new String[]{"ID", "NOMBRE", "CANTIDAD", "PRECIO"}, new SearchingCtrlArticles());
        myInvoice = new SearchingModel<Articles>(new String[]{"ID", "NOMBRE", "CANTIDAD", "PRECIO"}, new SearchingCtrlArticles());
        invoice.setSearching(new JSearching(modelSearching));
        invoice.getTblMyArticles().setModel(myInvoice);
        mdlArticles = new ModelArticles();
        mdlInvoice = new ModelInvoice(mdlArticles.getQueryManager());
        searchByField("");
        myPriceChanched();
        invoice.getTxtNoInvoice().setText(String.valueOf(GeneratedValues.getNextInvoiceId()));
        Calendar c1 = Calendar.getInstance();
        now = new Date(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DATE));
        invoice.getTxtDateInvoice().setText(String.valueOf(now));
    }

    public void searchByField(String string) {
        List<Articles> temp = mdlArticles.searchAllArticleByName("%" + string + "%");
        for (int i = 0; i < myInvoice.getElements().size(); i++) {
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j).equals(myInvoice.getElements().get(i))) {
                    temp.remove(j);
                }
            }

        }
        modelSearching.setElements(temp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(invoice.getBtnNew())) {
            int i = JOptionPane.showConfirmDialog(invoice, "Realmente Desea Crear Una Nueva Factura?", "Atencion", JOptionPane.OK_CANCEL_OPTION);
            if (i == 0) {
                for (int j = 0; j < invoice.getTblMyArticles().getRowCount(); j++) {
                    clean(j);
                }
                myPriceChanched();
            }
        }

        if (e.getSource().equals(invoice.getBtnSave())) {
            if (tempCustomer == null) {
                JOptionPane.showMessageDialog(invoice, "Error Debe Tener Seleccionado Un Cliente", "Atencion", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!(myInvoice.getRowCount() > 0)) {
                JOptionPane.showMessageDialog(invoice, "Error Debe Tener Seleccionado Aunque Sea Un Producto", "Atencion", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < modelSearching.getElements().size(); i++) {
                mdlArticles.updateObject(modelSearching.getElements().get(i));
            }
            mdlInvoice.insertObject(new Invoice(now, calcTotal(), tempCustomer, myInvoice.getElements()));
            JOptionPane.showMessageDialog(invoice, "Factura Guardada");
            for (int j = 0; j < invoice.getTblMyArticles().getRowCount(); j++) {
                clean(j);
            }
            myPriceChanched();
            invoice.getTxtNoInvoice().setText(String.valueOf(GeneratedValues.getNextInvoiceId()));
        }

        if (e.getSource().equals(invoice.getBtnExit())) {
            try {
                this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(ControllerInvoices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource().equals(invoice.getBtnSearch())) {
            try {
                Persons temp = new SearchPersons(null, true, mdlArticles.getQueryManager(), 4).personShowSearch();
                tempCustomer = new ModelCustomers().searchCustomer(temp.getPersonId());
                invoice.setCustomerFields(tempCustomer.getAddress(), String.valueOf(tempCustomer.getPersonId()), tempCustomer.getName() + " " + tempCustomer.getLastName());
            } catch (java.lang.NullPointerException d) {
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
        if (e.getSource().equals(invoice.getSearching().getTxtSearch())) {
            searchByField(invoice.getSearching().getTxtSearch().getText().toLowerCase());
        }

        if ((e.getSource().equals(invoice.getTblMyArticles())) && (e.getKeyCode() == 127)) {
            clean(invoice.getTblMyArticles().getSelectedRow());
        }
    }

    private void clean(int row) {
        if (myInvoice.getElements().size() > 0) {
            try {
                Articles obj = myInvoice.getElements().get(row);
                obj.setAmount(obj.getAmount() - 1);
                for (int i = 0; i < modelSearching.getElements().size(); i++) {
                    if (obj.getArticleId() == modelSearching.getElements().get(i).getArticleId()) {
                        modelSearching.getElements().get(i).setAmount(modelSearching.getElements().get(i).getAmount() + 1);
                    }
                }
                if (obj.getAmount() == 0) {
                    myInvoice.getElements().remove(obj);
                }
                myInvoice.fireTableDataChanged();
                modelSearching.fireTableDataChanged();
                myPriceChanched();
            } catch (java.lang.ArrayIndexOutOfBoundsException ds) {
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(invoice.getSearching().getTblResult())) {
            int fila = invoice.getSearching().getTblResult().rowAtPoint(e.getPoint());
            if (fila > -1) {
                Articles obj = modelSearching.getElements().get(fila);
                if (obj.getAmount() > 0) {
                    obj.setAmount(obj.getAmount() - 1);
                    for (int i = 0; i < myInvoice.getElements().size(); i++) {
                        if (obj.getArticleId() == myInvoice.getElements().get(i).getArticleId()) {
                            myInvoice.getElements().get(i).setAmount(myInvoice.getElements().get(i).getAmount() + 1);
                            myInvoice.fireTableDataChanged();
                            modelSearching.fireTableDataChanged();
                            myPriceChanched();
                            return;
                        }
                    }
                    Articles temp = new Articles(obj.getName(), obj.getPrice(), 1, obj.getDescription());
                    temp.setArticleId(obj.getArticleId());
                    myInvoice.getElements().add(temp);
                    myInvoice.fireTableDataChanged();
                    modelSearching.fireTableDataChanged();
                    myPriceChanched();
                    return;
                }
            }
        }
    }

    public double calcTotal() {
        double total = 0;
        for (int i = 0; i < myInvoice.getElements().size(); i++) {
            total += (myInvoice.getElements().get(i).getAmount() * myInvoice.getElements().get(i).getPrice());
        }
        return total;
    }

    public void myPriceChanched() {
        invoice.getTxtTotal().setText(String.valueOf(calcTotal()));
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
    public void windowGainedFocus(WindowEvent e) {
        searchByField(invoice.getSearching().getTxtSearch().getText().toLowerCase());
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
    }

    @Override
    protected void finalize() throws Throwable {
        new HomeFrame().showFrame();
        super.finalize();
    }
}
