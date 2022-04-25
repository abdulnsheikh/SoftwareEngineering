package builder;

import product.JSONProduct;
import product.Product;

// Concrete Builder 2
public class JSONBuilder extends Builder {
   JSONProduct product = new JSONProduct();
   String name;
   String address;
   String phone;

   // Receives each initialization parameter and
   // returns the resulting constructed object.
   public JSONBuilder setName(String name) {
      this.name = name;
      return this;
   }

   public JSONBuilder setAddress(String address) {
      this.address = address;
      return this;
   }

   public JSONBuilder setPhone(String phone) {
      this.phone = phone;
      return this;
   }

   // Constructs and assembles parts to build the objects, resulting product
   public void build() {
      product.append("NAME", this.name);
      product.append("ADDRESS" , this.address);
      product.append("PHONE" , this.phone);
      product.setData("{CUSTOMER: {\n" + product.getData() + "}}");
   }

   public Product getProduct() {
      return this.product;
   }
}