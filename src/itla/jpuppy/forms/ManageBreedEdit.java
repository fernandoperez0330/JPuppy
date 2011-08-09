package itla.jpuppy.forms;


import itla.jpuppy.controllers.ControllerBreeds;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JDialog;
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

public class ManageBreedEdit extends JDialog  implements FrameOption{
    private ControllerBreeds cb =null;

    public ManageBreedEdit(Frame owner, boolean modal , ControllerBreeds controler) {
        super(owner,modal);
        this.cb = controler;
          try {
            initComponents();
        } catch (Exception ex) {
            Logger.getLogger(ManageCustomersEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        setController();
        pack();
        this.setLocationRelativeTo( null );
        this.setTitle( "Manage Breeds" );
        this.setResizable( false );
        this.jComboBox1.setSelectedItem("-");
    }

   
    public void setController()
    {
        btnSave.setActionCommand( "save" );
        btnCancel.setActionCommand( "cancel" );
        btnSave.addActionListener(cb);
        btnCancel.addActionListener(cb);  
    }
   

                         
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
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("Nombre de la raza.:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("Especie.:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel3.setText("Altura.:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setText("Ancho.:");

        jComboBox1.setEditable(false);

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

        pnButtons.setLayout(new java.awt.GridLayout(1, 0, 6, 8));
        
        btnSave.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/save.png"));
        btnSave.setFocusable(false);
        btnSave.setName("save"); // NOI18N
        pnButtons.add(btnSave);


        btnCancel.setIcon(new javax.swing.ImageIcon("src/itla/jpuppy/resources/cancel.png"));
        btnCancel.setFocusable(false);
        btnCancel.setName("cancel"); // NOI18N
        pnButtons.add(btnCancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(144, 144, 144)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(pnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        
    }

                        
    private javax.swing.JTextField TxtFieldAltura;
    private javax.swing.JTextField TxtFieldAncho;
    private javax.swing.JTextField TxtFieldRaza;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnFields;
                    

   
    
    
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

    public JPanel getPnFields() {
        return pnFields;
    }
  
    public void setComboBoxModel( ComboBoxModel model ){
        this.jComboBox1.setModel(model);
    }
    
}
