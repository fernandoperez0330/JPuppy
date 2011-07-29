/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JHomeFrame.java
 *
 * Created on Jul 28, 2011, 8:07:30 PM
 */

package itla.jpuppy.forms;

import itla.jpuppy.utils.Background;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Guillermo Hdez
 */
public class HomeFrame extends javax.swing.JFrame implements FrameOption {

    /** Creates new form JHomeFrame */
    public HomeFrame() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("JPuppy"); // NOI18N
        setResizable(false);

        jMenu1.setText("Administrador");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ventas");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Usuarios");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ayuda");

        jMenuItem1.setText("Acerca de...");
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showFrame() {
        JPanel background = new Background("src/itla/jpuppy/resources/logoJPuppy.png");
        background.setBounds(0, 0, this.getWidth(),this.getHeight());
        this.add(background);
        this.setTitle("JPuppy: Sistema de veterinaria");
        this.setIconImage(HomeFrame.icon.getImage());
        this.setPreferredSize(new Dimension(700,700));
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.setVisible(false);
    }

}
