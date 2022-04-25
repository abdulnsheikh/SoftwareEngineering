package product;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

//Concrete Product
public class WinGUIButton extends GUIButton {
   @Override
   public void paint(Composite widgetComp) {
      System.out.println("[DBG] paint WinGUIButton");
      osStyle = "Windows GUI Style";

      item = new Button(widgetComp, SWT.NONE);
      item.setForeground(ColorConstants.red);
      item.setBounds(10, 10, 414, 25);
      item.setText("Windows GUI Style Button");
   }
}