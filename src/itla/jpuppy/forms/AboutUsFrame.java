/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.forms;

import java.awt.Frame;
import javax.swing.JDialog;

/**
 *
 * @author Randy
 */
public class AboutUsFrame extends JDialog implements FrameOption {

    /** Creates new form AboutUsFrame */
    public AboutUsFrame(Frame owner, boolean modal) {
        super(owner, true);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        labelTitle = new javax.swing.JLabel();
        labelSubTitle = new javax.swing.JLabel();
        imagAbout = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton("Cerrar");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFrame();                
            }
        });
        setTitle("Acerca de...");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("TexFrame"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelTitle.setText("JPuppy");
        getContentPane().add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));
        
        labelSubTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelSubTitle.setText("Sistema de Veterinaria");
        getContentPane().add(labelSubTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));
        
        imagAbout.setIcon(new javax.swing.ImageIcon(FrameOption.dirResources + "splash.png")); // NOI18N
        getContentPane().add(imagAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, -10, 190, 380));
        
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jTextArea1.setText("Permite Administrar toda la Información\nsobre la salud de sus pacientes, organizada\nen historias clínicas, vacunaciones y analisis,\nde esta forma podrá tomar decisiones correctas\nen poco tiempo."); // NOI18N
        jTextArea1.setSelectionColor(new java.awt.Color(204, 204, 255));
        jScrollPane1.setViewportView(jTextArea1);
        
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 390, 100));
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Version del producto:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Sistema:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("1.0 V");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));
        
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Windows Xp, Vista y 7");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));
        
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Copyright JPuppy. 2011. Todos los derechos reservados.");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 335, -1, -1));
        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagAbout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelSubTitle;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JButton btnExit;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showFrame() {
        this.setVisible(true);
    }
    
    @Override
    public void closeFrame() {
        this.setVisible(false);
    }
}
