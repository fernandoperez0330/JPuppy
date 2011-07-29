package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelUsers;
import itla.jpuppy.forms.Login;
import itla.jpuppy.utils.EncryptText;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControllerUsers implements ActionListener, KeyListener {

    Login login = null;
    //Home home = null;
    //actionPerformed para los botones del Login

    public ControllerUsers(Login login) {
        this.login = login;
    }

    public void checkLogin(String name, String password) {
        //System.out.println("Funciona");
        //pasandole los parametros al metodo validateUser de la clase ModelUsers
        boolean validate = false;
        try {
            validate = ModelUsers.validateUser(login.getTxtUsers(), login.getTxtPassword());
        } catch (Exception exc) {
            //System.out.println(EncryptText.md5(login.getTxtPassword()));
            exc.printStackTrace();
            //System.out.println("Catch");
        }
        if (validate) {
            System.out.println("Funciona");
            //cerrando el Login para mostrar el siguiente
            login.closeFrame();
        } else {
            JOptionPane.showMessageDialog(null, "Error: Nombre de usuario y contrasena incorrecta");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //evaluando cual boton fue pulsado y que debe realizar
        JButton comando = (JButton) e.getSource();
        if (comando.getName().equals("Login.btnLogin")) {
            checkLogin(login.getTxtUsers(), login.getTxtPassword());
        } else if (comando.getName().equals("Login.btnExit")) {
            login.closeFrame();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Captura el evento ENTER");

        if (e.getKeyCode() == 10) {
            checkLogin(login.getTxtUsers(), login.getTxtPassword());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
