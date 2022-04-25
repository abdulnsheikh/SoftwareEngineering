package product;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

//Concrete Product
public class OSXGUIText extends GUIText {

   @Override
   public void paint(Composite widgetComp) {
      System.out.println("[DBG] paint OSXGUIText");
      osStyle = "OSX GUI Style";
      
      item = new Text(widgetComp, SWT.BORDER);
      item.setForeground(ColorConstants.blue);
      item.setBounds(10, 37, 414, 25);
   }
}