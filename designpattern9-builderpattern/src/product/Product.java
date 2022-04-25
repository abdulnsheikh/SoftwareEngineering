package product;

public abstract class Product {
   String data = "";

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public String toString() {
      return this.data;
   }

   public abstract void append(String tag, String data);
}