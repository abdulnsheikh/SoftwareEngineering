package visitor;

import part.Body;
import part.Engine;
import part.Wheel;

public class MyAccessVisitor extends CartPartVisitor {
   public void visit(Wheel part) {
      System.out.println("[DBG] Accessing the name property: " + part.getName());
   }

   public void visit(Engine part) {
      System.out.println("[DBG] Accessing the name property: " + part.getName());
   }

   public void visit(Body part) {
      System.out.println("[DBG] Accessing the name property: " + part.getName());
   }
}