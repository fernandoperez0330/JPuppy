package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelUsers;
import itla.jpuppy.forms.HomeFrame;
import itla.jpuppy.forms.Login;
import itla.jpuppy.utils.EncryptText;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class ControllerLogin implements ActionListener, KeyListener {

    Login login = null;
    //Home home = null;
    //actionPerformed para los botones del Login

    public ControllerLogin(Login login) {
        this.login = login;
    }

    public void checkLogin(String name, String password) {
        //System.out.println("Funciona");
        //pasandole los parametros al metodo validateUser de la clase ModelUsers
        boolean validate = false;
        try {
             
           validate = new ModelUsers().validateUser( name , EncryptText.md5(password));
    
        } catch (Exception exc) {
            //System.out.println(EncryptText.md5(login.getTxtPassword()));
           // exc.printStackTrace();
            //System.out.println("Catch");
        }
        if (validate) {
            //System.out.println("Funciona");
            //cerrando el Login para mostrar el siguiente
            login.closeFrame();
            new HomeFrame().showFrame();
        } else {
            JOptionPane.showMessageDialog(null, "Error: Nombre de usuario y contrasena incorrecta");
            validate = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //evaluando cual boton fue pulsado y que debe realizar
        String comando = e.getActionCommand();
        if (comando.equals(login.getBotonEnterString())) {
            checkLogin(login.getTxtUsers(), login.getTxtPassword());
        } else if (comando.equals(login.getBotonExitString())) {
            login.closeFrame();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            
            checkLogin(login.getTxtUsers(), login.getTxtPassword());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
