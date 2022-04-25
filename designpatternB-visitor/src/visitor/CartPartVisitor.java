package visitor;

import part.Body;
import part.Engine;
import part.Wheel;

public abstract class CartPartVisitor {
   public abstract void visit(Wheel wheel);

   public abstract void visit(Engine engine);

   public abstract void visit(Body body);
}