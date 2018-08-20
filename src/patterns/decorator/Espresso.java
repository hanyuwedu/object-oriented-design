package patterns.decorator;

import java.util.ArrayList;
import java.util.List;

public class Espresso extends Coffee {
    @Override
    public Double getPrice() {
        return 4.15;
    }

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public List<String> getIngredient() {
        List<String> espressoCoffeeIngredient = new ArrayList();
        return espressoCoffeeIngredient;
    }
}
