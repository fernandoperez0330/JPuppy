
package itla.jpuppy.forms;

import javax.swing.ImageIcon;


public interface FrameOption {
    public static final String dirResources = "src/itla/jpuppy/resources/";
    public static final ImageIcon icon = new ImageIcon(FrameOption.dirResources + "logoJPuppy.png");
    public void showFrame();
    public void closeFrame();

}
