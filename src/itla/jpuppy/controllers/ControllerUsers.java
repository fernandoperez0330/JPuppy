package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelUsers;
import itla.jpuppy.forms.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControllerUsers implements ActionListener {

    Login login = null;
    //actionPerformed para los botones del Login
    public ControllerUsers(Login login){
        this.login = login;
    }
    
    @Override
      public void actionPerformed(ActionEvent e) {
        //evaluando cual boton fue pulsado y que debe realizar
        JButton comando = (JButton) e.getSource();
        if (comando.getName().equals("Login.btnLogin")) {
            //pasandole los parametros al metodo validateUser de la clase ModelUsers
            boolean validate= ModelUsers.validateUser(login.getTxtUsers(), login.getTxtPassword());
            if(validate){
                //cerrando el Login para mostrar el siguiente
                login.closeFrame();
                
                
            }else{
                //
                JOptionPane.showMessageDialog(null,"Error: Nombre de usuario y contrasena incorrecta");
            }
        } else if (comando.getName().equals("Login.btnExit")) {
            login.closeFrame();
        }
    }
}
