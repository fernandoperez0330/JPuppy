/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.utils;

import java.util.LinkedList;

/**
 *
 * @author jansel
 */
public class IDS {
    
  private LinkedList<Long> id =  new LinkedList<Long>();
  

    public Long getId( int index ) {
        return id.get( index );
    }

    public void addId(Long id) {
        this.id.add( id ); 
    }
    public boolean isEmpty(){
        return id.isEmpty();
    }
    public void removeId ( int index ){
        this.id.remove( index );
    }
    public void removeAllIds(){
        id.clear();
    }
  
    
}
