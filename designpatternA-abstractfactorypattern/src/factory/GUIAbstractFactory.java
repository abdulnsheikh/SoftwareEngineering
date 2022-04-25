package factory;

import product.GUIText;
import product.GUIButton;

//Abstract Factory
public abstract class GUIAbstractFactory {
   // Abstract Factory class declares the operations
   // for creating each individual product.
   abstract public GUIButton createButton();

   abstract public GUIText createText();
}
