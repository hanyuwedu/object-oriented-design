package type.reallifeobject.coffeemaker;

import type.reallifeobject.coffeemaker.exceptions.BaseNotSelectedException;

public class CoffeeMaker {
    private Coffee coffee;

    public void selectBase(Coffee coffeeBase) {
        this.coffee = coffeeBase;
        this.coffee.base = coffeeBase;
    }

    public void addMilk() {     /// Any ways to generalize ingredients? 9/17/2018
        if (this.coffee == null || this.coffee.base == null) {
            throw new BaseNotSelectedException();
        }
        this.coffee = new WithMilk(coffee);
    }

    public void addChocolate() {
        if (this.coffee == null || this.coffee.base == null) {
            throw new BaseNotSelectedException();
        }
        this.coffee = new WithChocolate(coffee);
    }

    public Double checkout() {
        if (this.coffee == null || this.coffee.base == null) {
            throw new BaseNotSelectedException();
        }

        System.out.println(this.coffee.toString());
        Coffee result = this.coffee;
        this.coffee = null;

        return result.price;
    }
}
