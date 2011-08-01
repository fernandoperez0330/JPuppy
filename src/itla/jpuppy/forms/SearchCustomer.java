package itla.jpuppy.forms;

import itla.jpuppy.business.ModelCustomers;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SearchCustomer extends JDialog implements FrameOption{
    
    ManagePatients owner;
    ModelCustomers modelCustomer;
    
    /** Creates new form SearchCustomernew */
    public SearchCustomer(ManagePatients owner,boolean modals) {
        super(owner,modals);
        this.owner = owner;
        this.setTitle("Buscar cliente");
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    private void initComponents() {

        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jScrollPane1 = new JScrollPane();
        
        //adaptar el searchCustomer para que el controlador patients pueda manipular sus componentes
        this.owner.getController().setSearchCustomer(this);
        
        
        jList1 = new JList(this.owner.getController().getModelCustomerbyName(jTextField1.getText()));
        
        jList1.addMouseListener(this.owner.getController());
        
        jTextField1.setName("textSearchCustomer");
        //poner el jlist en el controlador para que pueda manipularlo
        this.owner.getController().setListCustomertoSearch(jList1);
        
        jTextField1.addKeyListener(this.owner.getController());
        
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Cliente.:");

        jTextField1.setFont(new Font("Arial", 1, 14)); // NOI18N

        jScrollPane1.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Presione doble click para seleccionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration

    @Override
    public void showFrame() {
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.setVisible(false);
    }
}
