package type.reallifeobject.coffeemaker.v2.coffee;

import java.util.ArrayList;
import java.util.List;

public class Espresso implements Coffee {
    public Espresso() {

    }

    @Override
    public Double getCost() {
        return 4.15;
    }

    @Override
    public List<String> getCoffeeDecorators() {
        return new ArrayList<>();
    }

    @Override
    public String getCoffeeBase() {
        return "espresso";
    }

    @Override
    public void printDetail() {
        System.out.println("A cup of espresso, worth $" + this.getCost());
    }
}
