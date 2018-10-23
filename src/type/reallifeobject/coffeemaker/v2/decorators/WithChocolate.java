package type.reallifeobject.coffeemaker.v2.decorators;

import type.reallifeobject.coffeemaker.v2.coffee.Coffee;

import java.util.List;

public class WithChocolate extends CoffeeDecorator {
    public WithChocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public Double getCost() {
        return super.coffee.getCost() + 0.33;
    }

    @Override
    public List<String> getCoffeeDecorators() {
        List<String> decorators = super.coffee.getCoffeeDecorators();
        decorators.add("chocolate");
        return decorators;
    }
}
