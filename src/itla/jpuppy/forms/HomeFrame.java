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

import itla.jpuppy.controllers.ControllerHome;
import itla.jpuppy.utils.Background;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Guillermo Hdez
 */
public class HomeFrame extends javax.swing.JFrame implements FrameOption {

    /** Creates new form JHomeFrame */
    private JPanel background;
    private JSearching searching;
    
    private ControllerHome ctrlhome;

    public HomeFrame() {
        initComponents();
        //poner el icono al frame
        this.setTitle("JPuppy: Sistema de veterinaria");
        //poner la imagen de fondo para el frame principal
        background = new Background("src/itla/jpuppy/resources/Vet.jpg");
        background.setBounds(0, 0, this.getWidth(), this.getHeight());
        ctrlhome = new ControllerHome(this);
        this.addWindowFocusListener(ctrlhome);
        this.add(background);
        background.setLayout(new FlowLayout());
        background.add(searching);
        this.setIconImage(HomeFrame.icon.getImage());
        this.setPreferredSize(new Dimension(700, 700));
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMaximizedBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        setListener();

    }

    public JMenuItem getMnuiAcerca() {
        return mnuiAcerca;
    }

    public JMenuItem getMnuiBreeds() {
        return mnuiBreeds;
    }

    public JMenuItem getMnuiCloseSeccion() {
        return mnuiCloseSeccion;
    }

    public JMenuItem getMnuiCustomers() {
        return mnuiCustomers;
    }

    public JMenuItem getMnuiEmployees() {
        return mnuiEmployees;
    }

    public JMenuItem getMnuiExit() {
        return mnuiExit;
    }

    public JMenuItem getMnuiPatients() {
        return mnuiPatients;
    }

    public JMenuItem getMnuiPerfil() {
        return mnuiPerfil;
    }

    public JMenuItem getMnuiSpecies() {
        return mnuiSpecies;
    }

    public JMenuItem getMnuiUsers() {
        return mnuiUsers;
    }

    public JMenuItem getMnuiProductosServicios() {
        return mnuiProductosServicios;
    }
    

    private void setListener() {
        searching.getTxtSearch().addKeyListener(ctrlhome);
        mnuiAcerca.addActionListener(ctrlhome);
        mnuiBreeds.addActionListener(ctrlhome);
        mnuiCloseSeccion.addActionListener(ctrlhome);
        mnuiCustomers.addActionListener(ctrlhome);
        mnuiEmployees.addActionListener(ctrlhome);
        mnuiExit.addActionListener(ctrlhome);
        mnuiPatients.addActionListener(ctrlhome);
        mnuiPerfil.addActionListener(ctrlhome);
        mnuiSpecies.addActionListener(ctrlhome);
        mnuiUsers.addActionListener(ctrlhome);
        mnuiProductosServicios.addActionListener(ctrlhome);
    }
    
    public JSearching getSearching() {
        return searching;
    }

    public void setSearching(JSearching searching) {
        this.searching = searching;
    }
    
    
    @Override
    public void repaint(long time, int x, int y, int width, int height) {
        super.repaint(time, x, y, width, height);
        background.setBounds(0, 0, this.getWidth(), this.getHeight());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnubHome = new javax.swing.JMenuBar();
        mnuAdministrator = new javax.swing.JMenu();
        mnuiCustomers = new javax.swing.JMenuItem();
        mnuiPatients = new javax.swing.JMenuItem();
        spAdmin1 = new javax.swing.JPopupMenu.Separator();
        mnuiSpecies = new javax.swing.JMenuItem();
        mnuiBreeds = new javax.swing.JMenuItem();
        spAdmin2 = new javax.swing.JPopupMenu.Separator();
        mnuiEmployees = new javax.swing.JMenuItem();
        mnuiUsers = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuiProductosServicios = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        mnuUsuarios = new javax.swing.JMenu();
        mnuiPerfil = new javax.swing.JMenuItem();
        mnuiCloseSeccion = new javax.swing.JMenuItem();
        mnuiExit = new javax.swing.JMenuItem();
        mnuAcerca = new javax.swing.JMenu();
        mnuiAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("JPuppy"); // NOI18N
        setResizable(false);

        mnuAdministrator.setText("Administrador");

        mnuiCustomers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        mnuiCustomers.setText("Clientes");
        mnuAdministrator.add(mnuiCustomers);

        mnuiPatients.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        mnuiPatients.setText("Pacientes");
        mnuAdministrator.add(mnuiPatients);
        mnuAdministrator.add(spAdmin1);

        mnuiSpecies.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        mnuiSpecies.setText("Especies");
        mnuAdministrator.add(mnuiSpecies);

        mnuiBreeds.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        mnuiBreeds.setText("Razas");
        mnuAdministrator.add(mnuiBreeds);
        mnuAdministrator.add(spAdmin2);

        mnuiEmployees.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        mnuiEmployees.setText("Empleados");
        mnuAdministrator.add(mnuiEmployees);

        mnuiUsers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        mnuiUsers.setText("Usuarios");
        mnuAdministrator.add(mnuiUsers);
        mnuAdministrator.add(jSeparator1);

        mnuiProductosServicios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.CTRL_MASK));
        mnuiProductosServicios.setText("Productos y Servicios");
        mnuAdministrator.add(mnuiProductosServicios);

        mnubHome.add(mnuAdministrator);

        mnuVentas.setText("Ventas");
        mnubHome.add(mnuVentas);

        mnuUsuarios.setText("Usuario");

        mnuiPerfil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        mnuiPerfil.setText("Perfil");
        mnuUsuarios.add(mnuiPerfil);

        mnuiCloseSeccion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        mnuiCloseSeccion.setText("Cerrar Seccion");
        mnuUsuarios.add(mnuiCloseSeccion);

        mnuiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        mnuiExit.setText("Salir");
        mnuUsuarios.add(mnuiExit);

        mnubHome.add(mnuUsuarios);

        mnuAcerca.setText("Ayuda");

        mnuiAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnuiAcerca.setText("Acerca de...");
        mnuAcerca.add(mnuiAcerca);

        mnubHome.add(mnuAcerca);

        setJMenuBar(mnubHome);

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
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu mnuAcerca;
    private javax.swing.JMenu mnuAdministrator;
    private javax.swing.JMenu mnuUsuarios;
    private javax.swing.JMenu mnuVentas;
    private javax.swing.JMenuBar mnubHome;
    private javax.swing.JMenuItem mnuiAcerca;
    private javax.swing.JMenuItem mnuiBreeds;
    private javax.swing.JMenuItem mnuiCloseSeccion;
    private javax.swing.JMenuItem mnuiCustomers;
    private javax.swing.JMenuItem mnuiEmployees;
    private javax.swing.JMenuItem mnuiExit;
    private javax.swing.JMenuItem mnuiPatients;
    private javax.swing.JMenuItem mnuiPerfil;
    private javax.swing.JMenuItem mnuiProductosServicios;
    private javax.swing.JMenuItem mnuiSpecies;
    private javax.swing.JMenuItem mnuiUsers;
    private javax.swing.JPopupMenu.Separator spAdmin1;
    private javax.swing.JPopupMenu.Separator spAdmin2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showFrame() {
        this.setVisible(true);
    }

    @Override
    public void closeFrame() {
        this.setVisible(false);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
