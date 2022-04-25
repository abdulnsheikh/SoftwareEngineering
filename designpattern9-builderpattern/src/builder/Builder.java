package builder;

import product.Product;

// Abstract Builder for creating objects (product).
public abstract class Builder {
   public abstract Builder setName(String name);

   public abstract Builder setAddress(String address);

   public abstract Builder setPhone(String phone);

   public abstract void build();

   public abstract Product getProduct();
}