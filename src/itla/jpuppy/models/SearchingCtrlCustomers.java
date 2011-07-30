package itla.jpuppy.models;

import itla.jpuppy.datalayer.Customers;

public class SearchingCtrlCustomers implements SearchingControl {
//new String[] {"Id","Name","Lastname","City"}

    @Override
    public Object getValueAt(Object x, int y) {
        Customers temp = (Customers) x;
        switch (y) {
            case 0:
                //return temp.getCustomersId();
            case 1:
                return temp.getName();
            case 2:
                //return temp.getLastname();
            case 3:
                return temp.getCity();
        }

        return null;
    }
}
