/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelBreeds;
import itla.jpuppy.business.ModelSpecies;
import itla.jpuppy.business.QueryManager;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.datalayer.Species;
import itla.jpuppy.forms.ManageBreeds;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class ControllerBreeds implements ActionListener{

    
   
    private ModelBreeds modelBreeds=null;
    private ManageBreeds manageBreeds=null;
    private ModelSpecies modelSpecies = new ModelSpecies();
    private Breeds breed=null;
    private Species species=null;;
    private java.util.LinkedList<Breeds> listBreeds=null;
    private java.util.List<Breeds> listSearched=null;
    private Breeds temp=null;
    private ComboBoxModel model = null;
    private String text ="";
   
    
    public ControllerBreeds( ManageBreeds manageBreeds ) {
        modelBreeds = new ModelBreeds();
        this.manageBreeds = manageBreeds;
        listBreeds =  new java.util.LinkedList<Breeds>();
        model = new DefaultComboBoxModel( this.searchAllSpecies() );
        this.manageBreeds.setJComboBoxModel( model );
    }

    public ControllerBreeds() {
    }
    
    public String[] searchAllSpecies(){
        
        List<Species> list = modelSpecies.searchAllSpecies();
        String [] listReturn = new String[ list.size() ];
        ListIterator<Species> iterator = list.listIterator();
        int i=0;
        while( iterator.hasNext() ){
          listReturn[ i ]= iterator.next().getSpeciesName();
          i++;
        }
        
        return listReturn;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
                 
        String command = e.getActionCommand();
        if( command.equals( "add" ) ){
           this.manageBreeds.eventNew();
           this.manageBreeds.setMessageFind("");
           
        }else if( command.equals( "update" ) ){
            
                this.manageBreeds.eventEdit(this.manageBreeds.getBreedName());
            
        }else if( command.equals( "remove" ) ){
            this.manageBreeds.eventDelete();
            if( temp !=null ){
                this.modelBreeds.deleteObject( temp );
                this.manageBreeds.setMessageFind("");
                temp =null;
            }
            
        }else if( command.equals( "save" ) ){
           boolean state= this.manageBreeds.eventSave();
           this.manageBreeds.setMessageFind("");
           if( state ){
               
               if( temp==null ){
                   if( !this.manageBreeds.getSpecieName().equals("") && this.manageBreeds.getBreedHeigth()!=0 && this.manageBreeds.getBreedWidth()!=0){
                       
               this.species = modelSpecies.getSpeciesByName( this.manageBreeds.getSpecieName() );
             
               this.breed = new Breeds( manageBreeds.getBreedName(), species, manageBreeds.getBreedHeigth(),manageBreeds.getBreedWidth() );
            
            
               modelBreeds.insertObject( this.breed );
                  }else{
                       javax.swing.JOptionPane.showMessageDialog( null, "error : cannot save register,Specie field is empty or bad input" );
                   }
               }else {
                temp.setBreedsName( this.manageBreeds.getBreedName() );
                temp.getSpecie().setSpeciesName( this.manageBreeds.getSpecieName() );
                temp.setHeight( this.manageBreeds.getBreedHeigth() );
                temp.setWidth( this.manageBreeds.getBreedWidth() );
                
                   modelBreeds.updateObject( temp );
               }
               
               temp = null; 
           }
          
           
        }else if( command.equals( "cancel" ) ){
            this.manageBreeds.eventCancelar();
            this.manageBreeds.setMessageFind("");
            temp = null;
            
        }else if( command.equals( "search" ) ){
            this.manageBreeds.eventSearch( this.manageBreeds.getBreedName() );
            
            if( !this.manageBreeds.getBreedName().equals("") ){
            this.listSearched = this.modelBreeds.searchAllBreedsByName( this.manageBreeds.getBreedName() );
            this.manageBreeds.setMessageFind("<html><font size=+0.5 color=red>Se han seleccionado "+this.listSearched.size()+" registros </font></html>");
            try{
            temp = this.listSearched.get( 0 );
            this.manageBreeds.setAllFields( temp.getBreedsName(),temp.getSpecie().getSpeciesName(),temp.getWidth(),temp.getHeight() );
            }catch( Exception eh){
                
            }
                    }
        }
        
                
    }
    
}
