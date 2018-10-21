package type.reallifeobject.vendingmachine.v2.products;

public abstract class Product {
    private String name;
    private Double price;

    protected Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
