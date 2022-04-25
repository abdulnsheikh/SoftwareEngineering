package leaf;

import org.eclipse.draw2d.ColorConstants; 
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

import component.Graphic;

public class LeafCircle extends Graphic implements PaintListener {
   public void paintControl(PaintEvent e) {
      Canvas canvas = (Canvas) e.widget;
      int x = canvas.getBounds().width;
      int y = canvas.getBounds().height;
      e.gc.setLineWidth(this.lineWidth);
      e.gc.setForeground(this.color);
      e.gc.drawOval(10, y / 2, x - 20, y / 2);
   }

   @Override
   public void operationChangeStyle1Thick() {
      System.out.println("Circle operationChangeStyle");
      this.color = ColorConstants.red;
      this.lineWidth = this.lineWidth + 2;
   }

   @Override
   public void operationChangeStyle2Thin() {
      System.out.println("Circle operationChangeStyle 2");
      this.color = ColorConstants.red;
      this.lineWidth = this.lineWidth - 2;
   }
}