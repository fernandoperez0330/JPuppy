package itla.jpuppy.utils;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel{
    private Image picture;


public Background(String url){
   this(new ImageIcon(url).getImage());
 }
public Background(Image pictu) {
  this.picture = pictu;
 }

    @Override
 public void paintComponent(Graphics graf) {
  super.paintComponent(graf);
graf.drawImage(picture, 0,0,this.getWidth(),this.getHeight(),this);
}


}
