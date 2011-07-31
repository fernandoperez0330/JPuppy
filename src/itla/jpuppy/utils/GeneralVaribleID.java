/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.utils;

/**
 *
 * @author jansel
 */
public class GeneralVaribleID {
    
    private static long USerId;
    private static long CustomerID;
    
    public GeneralVaribleID(){
        USerId=0;
        CustomerID=0;
    }

    public static long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(long CustomerID) {
        GeneralVaribleID.CustomerID = CustomerID;
    }

    public long getUSerId() {
        return USerId;
    }

    public void setUSerId(int USerId) {
        GeneralVaribleID.USerId = USerId;
    }
    
}
