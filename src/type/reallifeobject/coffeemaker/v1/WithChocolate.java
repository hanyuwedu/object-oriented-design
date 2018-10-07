package type.reallifeobject.coffeemaker.v1;

public class WithChocolate extends Coffee {
    public WithChocolate(Coffee base) {
        super(base);
        super.ingredient.add("chocolate");
        super.price += 0.33;
    }
}
