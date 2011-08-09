/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.models;

import itla.jpuppy.datalayer.Breeds;

/**
 *
 * @author jansel
 */
public class SearchingCrtlBreeds implements SearchingControl{

    @Override
    public Object getValueAt(Object x, int y) {
        Breeds breed = ( Breeds ) x;
        
        switch( y ){
            default:
            case 0:
                return breed.getBreedsId();
            case 1:
                return breed.getBreedsName();
            case 2:
                return breed.getSpecie().getSpeciesName();
            case 3:
                return breed.getWidth();
            case 4: 
                return breed.getHeight();
        }
    }
    
}
