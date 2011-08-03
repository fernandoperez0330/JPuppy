package itla.jpuppy.forms;

import itla.jpuppy.controllers.ControllerLogin;
import itla.jpuppy.utils.Background;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Login implements FrameOption {

    private Background background;
    private JLabel title;
    private JLabel lbUserName;
    private JLabel lbPassword;
    public JTextField txtUsers;
    public JPasswordField txtPassword;
    public JButton btnEnter;
    public JButton btnExit;
    private JFrame fLogin;
    private JLabel image;
    private static Login login;

    public Login() {

        fLogin = new JFrame();
        background = new Background("");
        background.setLayout(null);
        //componentes
        title = new JLabel("Sistema de Veterinaria JPuppy");
        lbUserName = new JLabel("USUARIO");
        lbPassword = new JLabel("CONTRASEÑA");
        txtUsers = new JTextField("");
        txtPassword = new JPasswordField();
        btnEnter = new JButton();
        btnEnter.setActionCommand("ENTRAR");
        btnExit = new JButton();
        btnExit.setActionCommand("SALIR");
        background.setSize(400, 200);
        background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 128, 128)));
        Font fuente = new Font("Monospaced", Font.BOLD, 22);
        title.setFont(fuente);
        image = new JLabel();


        


        //seteo de posicion
        image.setBounds(15, 65, 100, 80);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/logoLogin.png")));
        title.setBounds(30, 18, 500, 30);
        txtUsers.setBounds(210, 75, 150, 30);
        txtPassword.setBounds(210, 120, 150, 30);
        lbUserName.setBounds(120, 65, 60, 50);
        lbPassword.setBounds(120, 110, 80, 50);
        btnEnter.setBounds(165, 170, 100, 40);
        btnExit.setBounds(260, 170, 100, 40);

        btnEnter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/good.png")));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itla/jpuppy/resources/cancelLogin.png")));


        //Instancia del Controlador
        ControllerLogin mainControl = new ControllerLogin(this);

        //agregando los actionListener a los botones del login
        btnEnter.addActionListener(mainControl);
        btnExit.addActionListener(mainControl);
        txtPassword.addKeyListener(mainControl);

        //agregando los diferentes componentes al panel con imagen llamado background
        background.add(title);
        background.add(lbUserName);
        background.add(lbPassword);
        background.add(txtUsers);
        background.add(txtPassword);
        background.add(btnEnter);
        background.add(btnExit);
        background.add(image);

    }

    //metodo para tener valor del JTextField Usuario
    public String getTxtUsers() {

        return txtUsers.getText();
    }
    //metodo para tener valor del JTextField de contraseña

    public String getTxtPassword() {

       return  txtPassword.getText();

    }

    public String getBotonEnterString(){
        return btnEnter.getActionCommand();
    }
     public String getBotonExitString(){
        return btnExit.getActionCommand();
    }
    //metodo para obtener la instacia de Login
    public synchronized static Login getInstance() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }

    @Override
    public void showFrame() {
        fLogin.setIconImage(FrameOption.icon.getImage());
        fLogin.getContentPane().add(background, "Center");
        fLogin.add(background);
        fLogin.setSize(450, 230);
        fLogin.setLocationRelativeTo(null);
        fLogin.setUndecorated(true);
        fLogin.setVisible(true);
    }

    @Override
    public void closeFrame() {
        fLogin.dispose();
    }
}
