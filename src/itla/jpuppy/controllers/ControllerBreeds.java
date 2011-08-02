/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelBreeds;
import itla.jpuppy.business.QueryManager;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.datalayer.Species;
import itla.jpuppy.forms.ManageBreeds;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class ControllerBreeds implements ActionListener{

    
   
    private ModelBreeds modelBreeds=null;
    private ManageBreeds manageBreeds=null;
    private Breeds breed=null;
    private Species species=null;;
    private java.util.LinkedList<Breeds> listBreeds=null;
    private java.util.List<Breeds> listSearched=null;
    private Breeds temp=null;
    public ControllerBreeds( ManageBreeds manageBreeds ) {
        modelBreeds = new ModelBreeds();
        this.manageBreeds = manageBreeds;
        listBreeds =  new java.util.LinkedList<Breeds>();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
                 
        String command = e.getActionCommand();
        if( command.equals( "add" ) ){
           this.manageBreeds.eventNew();
           
        }else if( command.equals( "update" ) ){
            
                this.manageBreeds.eventEdit(this.manageBreeds.getBreedName());
            
        }else if( command.equals( "remove" ) ){
            this.manageBreeds.eventDelete();
            if( temp !=null ){
                this.modelBreeds.deleteObject( temp );
                temp =null;
            }
            
        }else if( command.equals( "save" ) ){
           boolean state= this.manageBreeds.eventSave();
           if( state ){
               
               this.species = new Species( manageBreeds.getSpecieName() );
               this.breed = new Breeds( manageBreeds.getBreedName(), species, manageBreeds.getBreedHeigth(),manageBreeds.getBreedWidth() );
               this.listBreeds.add( breed );
               this.species.setBreeds( listBreeds );
               EntityManager em = Persistence.createEntityManagerFactory( "JPuppyPU" ).createEntityManager();
               em.getTransaction().begin();
               
               if( temp==null ){
                  
               em.persist( this.species );
               em.persist( this.breed );
               }else {
                temp.setBreedsName( this.manageBreeds.getBreedName() );
                temp.getSpecie().setSpeciesName( this.manageBreeds.getSpecieName() );
                temp.setHeight( this.manageBreeds.getBreedHeigth() );
                temp.setWidth( this.manageBreeds.getBreedWidth() );
                
                   em.merge( temp );
               }
               em.getTransaction().commit();
               em.close();
               temp = null;
           }
            
        }else if( command.equals( "cancel" ) ){
            this.manageBreeds.eventCancelar();
            
        }else if( command.equals( "search" ) ){
            this.manageBreeds.eventSearch( this.manageBreeds.getBreedName() );
            
            if( !this.manageBreeds.getBreedName().equals("") ){
            this.listSearched = this.modelBreeds.searchAllBreedsByName( this.manageBreeds.getBreedName() );
            try{
            temp = this.listSearched.get( 0 );
            this.manageBreeds.setAllFields( temp.getBreedsName(),temp.getSpecie().getSpeciesName(),temp.getWidth(),temp.getHeight() );
            }catch( Exception eh){
                
            }
                    }
        }
                
    }
    
}
