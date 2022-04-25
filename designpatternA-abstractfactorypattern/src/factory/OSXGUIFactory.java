package factory;

import product.GUIText;
import product.OSXGUIButton;
import product.OSXGUIText;
import product.GUIButton;

//Concrete Factory1
public class OSXGUIFactory extends GUIAbstractFactory {

   public GUIButton createButton() {
      return new OSXGUIButton();
   }

   public GUIText createText() {
      return new OSXGUIText();
   }
}
