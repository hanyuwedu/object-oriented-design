package patterns.decorator;

import java.util.List;

public class WithMilk extends CoffeeDecorator {
    public WithMilk(Coffee baseCoffee) {
        super(baseCoffee);
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 0.25;
    }

    @Override
    public List<String> getIngredient() {
        List<String> ingredients = super.getIngredient();
        ingredients.add("Milk");

        return ingredients;
    }

    public Coffee getCoffee() {
        return super.baseCoffee;
    }
}
