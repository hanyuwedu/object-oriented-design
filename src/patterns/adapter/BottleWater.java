package patterns.adapter;

public class BottleWater extends SellItems {
    @Override
    public Double getPrice() {
        return 3.0;
    }

    @Override
    public String getProductName() {
        return "Fiji";
    }
}
