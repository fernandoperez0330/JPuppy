/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.business;

import itla.jpuppy.datalayer.Customers;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ModelCustomers implements GeneralModel{

    private QueryManager queryManager;
    
    public ModelCustomers() {
        queryManager = new QueryManager();
    }

     private Customers searchCustomer( int id) {
        //EntityManager entityManager=EntityManagerCreator.getInstanceEM();
        //EntityManager temp = entityManager.find( );
         //return temp;
        return null;
    }
     public List<Customers> searchAllCustomerByName( String name ){
         //return queryManager.searchCustomer(name);
        return null;
     }
     
    @Override
    public boolean insertObject(Object object) {
        //Customer g = ( Customer ) object
        //queryManager.save( g )
        return true;
    }

    @Override
    public boolean updateObject(Object object) {
        //Customer g = ( Customer ) object
        //queryManager.update( g )
        return true;
    }

    @Override
    public boolean deleteObject(Object object) {
        //Customer g = ( Customer )object
        //Customer temp
        //temp= this.serachCustomer(g.getId());
        //queryManager.deleteObject( temp )
        return true;
    }
    
    
     
}
