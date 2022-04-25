package product;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

//Abstract Product A
public abstract class GUIText {
   public Text item;
   public String osStyle;

   public abstract void paint(Composite widgetComp);
}
