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
    
    private int USerId;
    private int CustomerID;
    private int specieId;
    {
        USerId=0;
        CustomerID=0;
        specieId=0;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getUSerId() {
        return USerId;
    }

    public void setUSerId(int USerId) {
        this.USerId = USerId;
    }

    public int getSpecieId() {
        return specieId;
    }

    public void setSpecieId(int specieId) {
        this.specieId = specieId;
    }
    
}
