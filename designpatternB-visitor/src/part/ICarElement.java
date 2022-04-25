package part;

import visitor.CartPartVisitor;

public interface ICarElement {
   void accept(CartPartVisitor visitor);
}
