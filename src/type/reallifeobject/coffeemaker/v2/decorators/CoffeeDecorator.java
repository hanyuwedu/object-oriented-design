package type.reallifeobject.coffeemaker.v2.decorators;

import type.reallifeobject.coffeemaker.v2.exceptions.BaseNotSelectedException;
import type.reallifeobject.coffeemaker.v2.Coffee;

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee coffee;

    protected CoffeeDecorator(Coffee coffee) {
        if (coffee.getCoffeeBase() == null || coffee.getCoffeeBase().isEmpty()) {
            throw new BaseNotSelectedException();
        }
        this.coffee = coffee;
    }

    @Override
    public String getCoffeeBase() {
        return coffee.getCoffeeBase();
    }

    @Override
    public void printDetail() {
        System.out.println("A cup of " + this.getCoffeeBase() + ", with " + this.getCoffeeDecorators() + ", worth $" + this.getCost());
    }
}
