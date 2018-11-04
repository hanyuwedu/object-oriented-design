package patterns.structural.decorator.coffeedecorators;

import patterns.structural.decorator.Coffee;

import java.util.List;

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee baseCoffee;

    protected CoffeeDecorator(Coffee baseCoffee) {  /// Constructor to be protected to be extended
        this.baseCoffee = baseCoffee;
    }

    @Override
    public Double getPrice() {
        return baseCoffee.getPrice();
    }

    @Override
    public String getName() {
        return baseCoffee.getName();
    }

    @Override
    public List<String> getIngredient() {
        return baseCoffee.getIngredient();
    }
}
