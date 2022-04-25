package proxypattern;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ProxyPatternDemo implements ActionCommand {
   private String fileName;
   private JFrame frame = new JFrame();

   public ProxyPatternDemo(String filename) {
      this.fileName = filename;
      frame.setTitle("Proxy Pattern Demo");
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setSize(800, 600);

      Container container = frame.getContentPane();
      container.setLayout(new BorderLayout());
      container.add(createControls(), BorderLayout.CENTER);
   }

   private JPanel createControls() {
      JButton showButton = new JButton("Show");
      showButton.setActionCommand(SHOW_ACTION);

      JButton sizeButton = new JButton("File Size");
      sizeButton.setActionCommand(SIZE_ACTION);

      JLabel imageLabel = new JLabel();
      imageLabel.setFont(new Font(imageLabel.getName(), Font.PLAIN, 32));

      EventHandler controller = new EventHandler(this.fileName, imageLabel);
      showButton.addActionListener(controller);
      sizeButton.addActionListener(controller);

      JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(showButton);
      buttonPanel.add(sizeButton);

      panel.add(buttonPanel, BorderLayout.PAGE_START);
      panel.add(imageLabel, BorderLayout.CENTER);
      return panel;
   }

   /**
   */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            ProxyPatternDemo prog = new ProxyPatternDemo("image1.jpg");
            prog.frame.setVisible(true);
         }
      });
   }
}
