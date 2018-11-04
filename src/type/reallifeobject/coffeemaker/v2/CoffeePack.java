package type.reallifeobject.coffeemaker.v2;

public class CoffeePack {
    Coffee coffeeBase;
    int neededChocolate;
    int neededMilk;

    public CoffeePack(Coffee coffeeBase, int neededChocolate, int neededMilk) {
        this.coffeeBase = coffeeBase;
        this.neededChocolate = neededChocolate;
        this.neededMilk = neededMilk;
    }

    public Coffee getCoffeeBase() {
        return coffeeBase;
    }

    public int getNeededChocolate() {
        return neededChocolate;
    }

    public int getNeededMilk() {
        return neededMilk;
    }
}
