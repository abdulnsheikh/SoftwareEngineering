package factory;

import product.GUIText; 
import product.GUIButton;
import product.WinGUIButton;
import product.WinGUIText;

//Concrete Factory2
public class WinGUIFactory extends GUIAbstractFactory {
   public GUIButton createButton() {
      return new WinGUIButton();
   }
   
   public GUIText createText() {
      return new WinGUIText();
   }
}
