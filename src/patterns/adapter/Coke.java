package patterns.adapter;

public class Coke extends SellItems {
    @Override
    public Double getPrice() {
        return 1.25;
    }

    @Override
    public String getProductName() {
        return "coca-cola";
    }
}
