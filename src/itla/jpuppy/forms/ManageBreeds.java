package itla.jpuppy.forms;


import itla.jpuppy.controllers.ControllerBreeds;
import itla.jpuppy.controllers.Controller;
import itla.jpuppy.datalayer.Species;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.ComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
/*
 * NewJFrame.java
 *
 * Created on Jul 25, 2011, 1:32:21 AM
 */

/**
 *
 * @author Adderly
 */

/* Necesito que la Persona que trabajo con esta vista por favor le coloque dos BasicArrowButton */
/* Uno con orientacion 3 y otro con orientacion 7*/

public class ManageBreeds extends JDialog  implements FrameOption{

    public ManageBreeds(Frame owner, boolean modal) {
        super();
        initComponents();
        ControllerBreeds cb = new ControllerBreeds( this );
        setController( cb );
//        initFields( this.pnFields , this.pnButtons );
        this.setLocationRelativeTo( null );
        this.setTitle( "Manage Users" );
        this.setResizable( false );
        this.jComboBox1.setSelectedItem("-");
    }

   
    public void setController( ControllerBreeds cb )
    {
        btnAdd.setActionCommand( "add" );
        btnUpdate.setActionCommand( "update" );
        btnSearch.setActionCommand( "search" );
        btnSave.setActionCommand( "save" );
        btnRemove.setActionCommand( "remove" );
        btnCancel.setActionCommand( "cancel" );
        btnAdd.addActionListener(cb);
        btnUpdate.addActionListener(cb);
        btnSearch.addActionListener(cb);
        btnSave.addActionListener(cb);
        btnRemove.addActionListener(cb);
        btnCancel.addActionListener(cb);
      
        
       
    }
    /** Creates new form NewJFrame */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtFieldRaza = new javax.swing.JTextField();
        TxtFieldAncho = new javax.swing.JTextField();
        TxtFieldAltura = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        pnButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CrudEntities");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("Nombre de la raza.:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("Especie.:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel3.setText("Altura.:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setText("Ancho.:");

        jComboBox1.setEditable(true);

        javax.swing.GroupLayout pnFieldsLayout = new javax.swing.GroupLayout(pnFields);
        pnFields.setLayout(pnFieldsLayout);
        pnFieldsLayout.setHorizontalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(85, 85, 85)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtFieldRaza, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(TxtFieldAncho, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(TxtFieldAltura, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, 356, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnFieldsLayout.setVerticalGroup(
            pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtFieldRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtFieldAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnButtons.setLayout(null);

        btnAdd.setIcon(new javax.swing.ImageIcon("./src/itla/jpuppy/resources/add.png"));
        btnAdd.setFocusable(false);
        btnAdd.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAdd.setName("add"); // NOI18N
        pnButtons.add(btnAdd);
        btnAdd.setBounds(50, 0, 110, 50);

        btnUpdate.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/edit.png"));
        btnUpdate.setFocusable(false);
        btnUpdate.setName("update"); // NOI18N
        pnButtons.add(btnUpdate);
        btnUpdate.setBounds(170, 0, 110, 50);

        btnSearch.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/find.png"));
        btnSearch.setFocusable(false);
        btnSearch.setName("search"); // NOI18N
        pnButtons.add(btnSearch);
        btnSearch.setBounds(292, 0, 110, 50);

        btnSave.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/save.png"));
        btnSave.setFocusable(false);
        btnSave.setName("save"); // NOI18N
        pnButtons.add(btnSave);
        btnSave.setBounds(420, 0, 110, 50);

        btnRemove.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/remove.png"));
        btnRemove.setFocusable(false);
        btnRemove.setName("remove"); // NOI18N
        pnButtons.add(btnRemove);
        btnRemove.setBounds(550, 0, 110, 50);

        btnCancel.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/cancel.png"));
        btnCancel.setFocusable(false);
        btnCancel.setName("cancel"); // NOI18N
        pnButtons.add(btnCancel);
        btnCancel.setBounds(680, 0, 110, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtFieldAltura;
    private javax.swing.JTextField TxtFieldAncho;
    private javax.swing.JTextField TxtFieldRaza;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnFields;
    // End of variables declaration//GEN-END:variables

   
    
    
    @Override
    public void showFrame() {
       this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.dispose();
    }
    
    public String getBreedName(){
        return TxtFieldRaza.getText();
    }
   
    public String getSpecieName(){
        return (String ) jComboBox1.getSelectedItem();
    }
    
 public void setMessageFind( String text ){
     this.jLabel5.setText( text );
 }
 
    public double getBreedWidth(){
        double width=0;
        try{
        width = Double.parseDouble(TxtFieldAncho.getText() );
        }catch( Exception e ){
            
        }
        return width;
    }
    
    
    public double getBreedHeigth(){
        double heigth=0;
        try{
        heigth = Double.parseDouble(TxtFieldAltura.getText() );
        }catch( Exception e ){
            
        }
        return heigth;
    }
   
    public JPanel getPnButtons() {
        return pnButtons;
    }
    
    public void setAllFields(String breedName,String specieName,double width,double heigth){
        TxtFieldRaza.setText( breedName );
        jComboBox1.setSelectedItem( ( String )specieName );
        TxtFieldAncho.setText( String.valueOf( width ) );
        TxtFieldAltura.setText( String.valueOf( heigth ) );
    }
  

    //@Override
    public void eventDelete() {
    /*    if( !isEmptyFields() ){
        changeStatePnlEdition( false );
        cleanFields();
        stateButtons(true, false);
        }else{
            javax.swing.JOptionPane.showMessageDialog( null ,"error: no selected register" );
        }
     * 
     */
    }

    //@Override
    public boolean eventSave() {
        /*boolean state=true;
        if( !isEmptyFields() ){
            
       changeStateWriteFields( false );
       stateButtons(true, false);
        }else {
            state = false;
            javax.swing.JOptionPane.showMessageDialog( null ,"error: cannot save registry , empty field" );
        }
        return state;
         * 
         */
       return true;
    }

    //@Override
    public void eventSearch( String text ) {
        /*
        if( !isEmptyFields() )
            cleanFields();
        if( !text.equals("") )
            changeStateWriteFields( false );
       stateButtons(true, false);
       changeStatePnlEdition( true );
         * 
         */
       
    }
    public void setJComboBoxModel( ComboBoxModel boxModel ){
        this.jComboBox1.setModel( boxModel );
    }
 
   

}
