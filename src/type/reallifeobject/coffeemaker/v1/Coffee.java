package type.reallifeobject.coffeemaker.v1;

import java.util.ArrayList;
import java.util.List;

public abstract class Coffee {
    protected String name;
    protected Double price;

    protected Coffee base;
    protected List<String> ingredient;

    public Coffee(String name, Double price) {
        this.name = name;
        this.price = price;
        this.ingredient = new ArrayList<>();
    }

    public Coffee(Coffee base) {
        this.name = base.name;
        this.ingredient = base.ingredient;
        this.base = base;
        this.price = base.price;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
       return  "This coffee is " + this.name + ", with ingredients: " + this.ingredient.toString() + ". Its price is " + this.price;
    }
}
