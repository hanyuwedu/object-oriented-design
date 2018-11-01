package patterns.adapter.Items;

public class Coke extends Product {
    @Override
    public Double getPrice() {
        return 1.25;
    }

    @Override
    public String getProductName() {
        return "coca-cola";
    }
}
