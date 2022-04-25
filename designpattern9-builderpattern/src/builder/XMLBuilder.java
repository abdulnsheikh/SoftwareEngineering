package builder;

import product.Product;
import product.XMLProduct;

// Concrete Builder 1
public class XMLBuilder extends Builder {
   XMLProduct product = new XMLProduct();
   String name;
   String address;
   String phone;

   // Receives each initialization parameter and
   // returns the resulting constructed object.
   public XMLBuilder setName(String name) {
      this.name = name;
      return this;
   }

   public XMLBuilder setAddress(String address) {
      this.address = address;
      return this;
   }

   public XMLBuilder setPhone(String phone) {
      this.phone = phone;
      return this;
   }

   // Constructs and assembles parts to build the objects, resulting product
   public void build() {
      product.append("NAME", this.name);
      product.append("ADDRESS", this.address);
      product.append("PHONE", this.phone);
      product.setData("<CUSTOMER>\n" + product.getData() + "</CUSTOMER>");
   }

   public Product getProduct() {
      return this.product;
   }
}