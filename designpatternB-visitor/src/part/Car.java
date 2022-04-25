package part;

import visitor.CartPartVisitor;

public class Car {
   Wheel wheel = new Wheel("Wheel Part");
   Body body = new Body("Body Part");
   Engine engine = new Engine("Engine Part");

   public void accept(CartPartVisitor visitor) {
      wheel.accept(visitor);
      engine.accept(visitor);
      body.accept(visitor);
   }
}