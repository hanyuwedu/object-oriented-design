package patterns.adapter.Items;

public class BottleWater extends Product {
    @Override
    public Double getPrice() {
        return 3.0;
    }

    @Override
    public String getProductName() {
        return "Fiji";
    }
}
