package proxypattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import proxypattern.image.ProxyImage;

public class EventHandler implements ActionListener, ActionCommand {
   private ProxyImage proxyImage = null;
   private JLabel imageLabel;

   public EventHandler(String fileName, JLabel label) {
      proxyImage = new ProxyImage(fileName);
      imageLabel = label;
   }

   public void actionPerformed(ActionEvent event) {
      String actionCommand = event.getActionCommand();

      if (SHOW_ACTION.equals(actionCommand)) {
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               proxyImage.paint(imageLabel);
            }
         });
      } else if (SIZE_ACTION.equals(actionCommand)) {
         proxyImage.getImageSize(imageLabel);
      }
   }
}
