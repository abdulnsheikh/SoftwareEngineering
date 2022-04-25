package proxypattern.image;

import java.io.File;
import javax.swing.JLabel;

public class ProxyImage implements ImageInterface {
   private RealImage realImage;
   private String fileName;

   public ProxyImage(String fileName) {
      this.fileName = fileName;
   }

   public void paint(JLabel imageLabel) {
      if (realImage == null) {
         realImage = new RealImage(fileName);
      }
      realImage.paint(imageLabel);
   }

   public void getImageSize(JLabel imageLabel) {
      imageLabel.setIcon(null);
      imageLabel.setText("File Size: " + new File(fileName).length()/1024);
      imageLabel.setHorizontalAlignment(JLabel.CENTER);
   }
}