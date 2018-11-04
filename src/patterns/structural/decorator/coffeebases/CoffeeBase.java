package patterns.structural.decorator.coffeebases;

import patterns.structural.decorator.Coffee;

import java.util.ArrayList;
import java.util.List;

public abstract class CoffeeBase implements Coffee {
    protected Double price;
    protected String name;

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getIngredient() {
        return new ArrayList<>();
    }
}
