package itla.jpuppy.models;

import itla.jpuppy.forms.EditConsultations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlEditConsultations implements ActionListener {

    private EditConsultations ec = null;

    public ControlEditConsultations(EditConsultations ec) {
        this.ec = ec;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String comando = ae.getActionCommand();
        if (comando.equals(ec.getActionCommandSv())) {
            System.out.println("Funciona");
        } else if (comando.equals(ec.getActionCommandCn())) {
            int respond = JOptionPane.showConfirmDialog(null, "¿Desea Cancelar esta modificacion?", "Cancelar", JOptionPane.OK_CANCEL_OPTION);
            if (respond == 0) {
                ec.closeFrame();
            }
        }
    }
}
