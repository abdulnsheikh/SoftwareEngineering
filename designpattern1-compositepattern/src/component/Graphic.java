package component;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

public abstract class Graphic {
   protected Color color = ColorConstants.black;
   protected int lineWidth = 5;

   public abstract void operationChangeStyle1Thick();
   public abstract void operationChangeStyle2Thin();
}
