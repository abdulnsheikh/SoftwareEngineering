package product;

public class JSONProduct extends Product {
   public void append(String tag, String data) {
      this.data += ("  " + addQuote(tag) + ":" + addQuote(data) + ",\n");
   }

   String addQuote(String s) {
      return "\"" + s + "\"";
   }
}