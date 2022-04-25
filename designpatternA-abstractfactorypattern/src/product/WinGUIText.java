package product;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

//Concrete Product
public class WinGUIText extends GUIText {
   @Override
   public void paint(Composite widgetComp) {
      System.out.println("[DBG] paint WinGUIText");
      osStyle = "Windows GUI Style";
      
      item = new Text(widgetComp, SWT.BORDER);
      item.setForeground(ColorConstants.red);
      item.setBounds(10, 37, 414, 25);
   }
}