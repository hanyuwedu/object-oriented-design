package patterns.decorator;

import java.util.ArrayList;
import java.util.List;

public class AmericanoCoffee extends Coffee {
    @Override
    public Double getPrice() {
        return 2.15;
    }

    @Override
    public String getName() {
        return "Americano Coffee";
    }

    @Override
    public List<String> getIngredient() {
        List<String> americanoCoffeeIngredient = new ArrayList();
        return americanoCoffeeIngredient;
    }
}
