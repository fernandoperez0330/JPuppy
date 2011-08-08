package itla.jpuppy.utils;

import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.business.ModelPatients;
import itla.jpuppy.datalayer.Customers;
import itla.jpuppy.datalayer.Patients;
import java.lang.String;
import java.util.List;
import java.util.ListIterator;

public class GeneratorDataCombo {

    private String[] listReturn = null;
    //Construye la lista con NOMBRE - APELLIDO que llenara combox
    public synchronized String[] dataCustomers() {
        List<Customers> list = new ModelCustomers().searchAllCustomer();
        if (list.isEmpty()) {
            return null;
        } else {
            listReturn = new String[list.size()];
            ListIterator<Customers> iterator = list.listIterator();
            int i = 0;
            while (iterator.hasNext()) {
                Customers customerIterator = (Customers) iterator.next();
                //intentar ponerle el apellido junto con el nombre
                String algo = customerIterator.getName() + " " + customerIterator.getLastName();
                listReturn[i] = algo;
                i++;
            }
        }
        return listReturn;
    }

    //Construye la lista con NOMBRE - APELLIDO que llenara combox
    public String[] dataPatients() {
        List<Patients> list = new ModelPatients().searchAllPatient();
        if (list.isEmpty()) {
            return null;
        } else {
            listReturn = new String[list.size()];
            ListIterator<Patients> iterator = list.listIterator();
            int i = 0;
            while (iterator.hasNext()) {
                listReturn[i] = iterator.next().getName();
                i++;
            }
        }
        return listReturn;
    }
}
