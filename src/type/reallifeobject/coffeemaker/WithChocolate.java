package type.reallifeobject.coffeemaker;

public class WithChocolate extends Coffee {
    public WithChocolate(Coffee base) {
        super(base);
        super.ingredient.add("chocolate");
        super.price += 0.33;
    }
}
