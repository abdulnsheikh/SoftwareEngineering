package director;

import builder.Builder;
import product.Product;

// Director - responsible for constructing a Product.
public class DocumentReader {
   private final String ENTITY_NAME = "NAME:";
   private final String ENTITY_ADDRESS = "ADDRESS:";
   private final String ENTITY_PHONE = "PHONE:";
   Builder builder;

   public DocumentReader(Builder builder) {
      this.builder = builder;
   }

   // Constructs a product using the Builder interface to a Concrete Builder.
   public void build(String text) {
      String[] splitedData = text.split(",");
      String name = null, address = null, phone = null;
      for (String data : splitedData) {
         if (data.startsWith(ENTITY_NAME)) {
            name = data.substring(ENTITY_NAME.length());
         } else if (data.startsWith(ENTITY_ADDRESS)) {
            address = data.substring(ENTITY_ADDRESS.length());
         } else if (data.startsWith(ENTITY_PHONE)) {
            phone = data.substring(ENTITY_PHONE.length());
         }
      }
      // The increase of object constructor parameter combination
      // leads to an exponential list of constructors. Instead of
      // using numerous constructors, the builder pattern uses
      // another object, a builder, that receives each initialization
      // parameter step by step and then returns the resulting constructed
      // object at once.
      builder.setName(name).setAddress(address).setPhone(phone).build();
   }

   public Product getResult() {
      return builder.getProduct();
   }
}