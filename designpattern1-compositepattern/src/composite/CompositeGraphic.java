package composite;

import java.util.ArrayList;
import java.util.List;

import component.Graphic;

public class CompositeGraphic extends Graphic {
   // Collection of child graphics.
   private List<Graphic> childGraphics = new ArrayList<Graphic>();

   public void operationChangeStyle1Thick() {
      for (Graphic graphic : childGraphics) {
         graphic.operationChangeStyle1Thick();
      }
   }

   public void operationChangeStyle2Thin() {
      for (Graphic graphic : childGraphics) {
         graphic.operationChangeStyle2Thin();
      }
   }

   public void add(Graphic graphic) {
      childGraphics.add(graphic);
   }

   public void remove(Graphic graphic) {
      childGraphics.remove(graphic);
   }
}
