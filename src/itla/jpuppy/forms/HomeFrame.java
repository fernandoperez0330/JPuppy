package itla.jpuppy.forms;

import java.awt.Dimension;
import javax.swing.JFrame;

public class HomeFrame implements FrameOption {
    JFrame frame = null;
    
    @Override
    public void showFrame() {
       frame = new JFrame("JPuppy Sistema de veterinaria");
       frame.setSize(new Dimension(400,400));
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
    }

    @Override
    public void closeFrame() {
       frame.setVisible(false);
       frame.dispose();
    }
    
}
