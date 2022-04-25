package compositepattern;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import composite.CompositeGraphic;
import leaf.LeafCircle;
import leaf.LeafRoundRectangle;

public class CompositePatternDemo extends MyShell {
   public static void main(String[] args) {
      CompositePatternDemo demo = new CompositePatternDemo();
      demo.createShell();
      demo.createCompositeGraphic();
      demo.openShell();
   }

   void createCompositeGraphic() {
      LeafRoundRectangle roundRectangle = new LeafRoundRectangle();
      LeafCircle circle = new LeafCircle();

      CompositeGraphic composite = new CompositeGraphic();
      // Compose objects uniformly.
      composite.add(roundRectangle);
      composite.add(circle);

      // Register paint event listener.
      drawingCanvas.addPaintListener(roundRectangle);
      drawingCanvas.addPaintListener(circle);

      buttonThick.addSelectionListener(new SelectionAdapter() {
         public void widgetSelected(SelectionEvent e) {
            // Handle individual objects consistently.
            composite.operationChangeStyle1Thick();
            drawingCanvas.redraw();
         }
      });

      buttonThin.addSelectionListener(new SelectionAdapter() {
         public void widgetSelected(SelectionEvent e) {
            // Handle individual objects consistently.
            composite.operationChangeStyle2Thin();
            drawingCanvas.redraw();
         }
      });
   }
}
