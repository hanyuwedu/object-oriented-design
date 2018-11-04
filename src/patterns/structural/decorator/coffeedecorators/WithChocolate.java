package patterns.structural.decorator.coffeedecorators;

import patterns.structural.decorator.Coffee;

import java.util.List;

public class WithChocolate extends CoffeeDecorator {
    public WithChocolate(Coffee baseCoffee) {
        super(baseCoffee);
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 0.33;
    }

    @Override
    public List<String> getIngredient() {
        List<String> ingredients = super.getIngredient();
        ingredients.add("Chocolate");

        return ingredients;
    }
}
