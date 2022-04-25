package product;

public class XMLProduct extends Product {
   public void append(String tag, String data) {
      this.data += ("  " + _L(tag) + data + _R(tag)) + "\n";
   }

   String _L(String s) {
      return "<" + s + ">";
   }

   String _R(String s) {
      return "</" + s + ">";
   }
}