package client;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import factory.GUIAbstractFactory;
import product.GUIButton;
import product.GUIText;

//A client program is shielded from concrete product classes.
public class Application extends MyShell {
   // Abstract Product A and B.
   GUIButton button;
   GUIText text;
   boolean flag = true;

   public Application(GUIAbstractFactory factory) {
      createShell();

      // Abstract Factory creates Abstract Products A and B.
      // Abstract Factory class declares the operations
      // for creating each individual product.
      button = factory.createButton();
      text = factory.createText();
   }

   public void paint() {
      button.paint(widgetComp);
      text.paint(widgetComp);

      Listener listener = new Listener() {
         public void handleEvent(Event event) {
            if (event.widget == button.item) {
               if (flag) {
                  text.item.setText(button.osStyle);
               } else {
                  text.item.setText("");
               }
               flag = !flag;
            }
         }
      };
      button.item.addListener(SWT.Selection, listener);
   }
}
