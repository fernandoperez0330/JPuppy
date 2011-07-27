package itla.jpuppy.controllers;

import itla.jpuppy.business.ModelUsers;
import itla.jpuppy.forms.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControllerUsers implements ActionListener {

    //actionPerformed para los botones del Login
    @Override
      public void actionPerformed(ActionEvent e) {

        //instancia de Login (singleton)
        Login log = Login.getInstance();

        //evaluando cual boton fue pulsado y que debe realizar
        JButton comando = (JButton) e.getSource();
        if (comando.getName().equals("btnLogin")) {

            //pasandole los parametros al metodo validateUser de la clase ModelUsers
            boolean validate= ModelUsers.validateUser(log.getTxtUsers(), log.getTxtPassword());

            if(validate){
                //cerrando el Login para mostrar el siguiente
                log.closeLogin();
            
            }

        } else if (comando.getName().equals("btnExit")) {
            System.exit(0);
        }
    }
}
