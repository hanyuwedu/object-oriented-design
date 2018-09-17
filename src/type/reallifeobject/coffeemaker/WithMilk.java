package type.reallifeobject.coffeemaker;

public class WithMilk extends Coffee {
    public WithMilk(Coffee base) {
        super(base);
        super.ingredient.add("milk");
        super.price += 0.25;
    }
}
