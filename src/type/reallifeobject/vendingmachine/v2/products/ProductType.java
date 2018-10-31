package type.reallifeobject.vendingmachine.v2.products;

import java.util.function.Supplier;

public enum  ProductType {
    BOTTLEWATER("Bottle Water", 1.00, () -> new BottleWater()),
    COKE("Coke", 1.25, () -> new Coke()),
    SPRITE("Sprite", 1.25, () -> new Sprite());

    private String name;
    private double price;
    private Supplier<Product> productSupplier;

    ProductType(String name, double price, Supplier<Product> productSupplier) {
        this.name = name;
        this.price = price;
        this.productSupplier = productSupplier;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * @return a product object based on product type
     */
    public Product getProduct() {
        return productSupplier.get();
    }
}
