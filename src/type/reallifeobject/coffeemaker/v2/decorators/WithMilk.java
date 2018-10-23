package type.reallifeobject.coffeemaker.v2.decorators;

import type.reallifeobject.coffeemaker.v2.coffee.Coffee;

import java.util.List;

public class WithMilk extends CoffeeDecorator {
    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public Double getCost() {
        return super.coffee.getCost() + 0.25;
    }

    @Override
    public List<String> getCoffeeDecorators() {
        List<String> decorators = coffee.getCoffeeDecorators();
        decorators.add("milk");
        return decorators;
    }
}
