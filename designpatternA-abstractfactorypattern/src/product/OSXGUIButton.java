package product;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

//Concrete Product
public class OSXGUIButton extends GUIButton {

   @Override
   public void paint(Composite widgetComp) {
      System.out.println("[DBG] paint OSXGUIButton");
      osStyle = "OSX GUI Style";

      item = new Button(widgetComp, SWT.NONE);
      item.setForeground(ColorConstants.blue);
      item.setBounds(10, 10, 414, 25);
      item.setText("OSX GUI Style Button");
   }
}