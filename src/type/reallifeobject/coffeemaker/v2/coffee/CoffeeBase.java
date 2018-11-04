package type.reallifeobject.coffeemaker.v2.coffee;

import type.reallifeobject.coffeemaker.v2.Coffee;

import java.util.ArrayList;
import java.util.List;

public abstract class CoffeeBase implements Coffee {
    protected Double cost;
    protected String coffeeBase;

    @Override
    public Double getCost() {
        return this.cost;
    }

    @Override
    public List<String> getCoffeeDecorators() {
        return new ArrayList<>();
    }

    @Override
    public String getCoffeeBase() {
        return this.coffeeBase;
    }

    @Override
    public void printDetail() {
        System.out.println("A cup of " + this.coffeeBase + ", worth $" + this.getCost());
    }
}
