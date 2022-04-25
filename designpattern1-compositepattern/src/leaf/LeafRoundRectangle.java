package leaf;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

import component.Graphic;

public class LeafRoundRectangle extends Graphic implements PaintListener {
   public void paintControl(PaintEvent e) {
      Canvas canvas = (Canvas) e.widget;
      int x = canvas.getBounds().width;
      int y = canvas.getBounds().height;
      e.gc.setLineWidth(this.lineWidth);
      e.gc.setForeground(this.color);
      e.gc.drawRoundRectangle(10, 10, x - 20, y / 2, 50, 50);
   }

   @Override
   public void operationChangeStyle1Thick() {
      System.out.println("RoundRectangle operationChangeStyle");
      this.color = ColorConstants.blue;
      this.lineWidth = this.lineWidth + 1;
   }

   @Override
   public void operationChangeStyle2Thin() {
      System.out.println("RoundRectangle operationChangeStyle");
      this.color = ColorConstants.blue;
      this.lineWidth = this.lineWidth - 1;
   }
}