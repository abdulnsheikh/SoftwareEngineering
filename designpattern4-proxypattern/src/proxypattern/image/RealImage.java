package proxypattern.image;
import java.awt.image.BufferedImage; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;

public class RealImage implements ImageInterface {
   private String fileName;
   private ImageIcon imageicon;

   public RealImage(String fileName) {
      this.fileName = fileName;
      loadFromDisk();
   }

   public void loadFromDisk() {
      BufferedImage bufferedImage = null;
      try {
         bufferedImage = ImageIO.read(new File(fileName));
      } catch (IOException e) {
         e.printStackTrace();
      }
      imageicon = new ImageIcon(bufferedImage);
      Image scaledInstance = imageicon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
      imageicon = new ImageIcon(scaledInstance);
   }
   
   public void paint(JLabel imageLabel) {
      imageLabel.setText("");
      imageLabel.setIcon(imageicon);
  }
}

