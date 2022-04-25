package product;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

//Abstract Product B
public abstract class GUIButton {
   public Button item;
   public String osStyle;
   
   public abstract void paint(Composite widgetComp);
} 
