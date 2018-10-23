package type.reallifeobject.coffeemaker.v2.coffee;

import java.util.ArrayList;
import java.util.List;

public class Decaf implements Coffee {
    public Decaf() {

    }

    @Override
    public Double getCost() {
        return 7.99;
    }

    @Override
    public List<String> getCoffeeDecorators() {
        return new ArrayList<>();
    }

    @Override
    public String getCoffeeBase() {
        return "decaf";
    }

    @Override
    public void printDetail() {
        System.out.println("A cup of decaf, worth $" + this.getCost());
    }
}
