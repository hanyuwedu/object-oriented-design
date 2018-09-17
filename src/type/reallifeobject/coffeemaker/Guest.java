package type.reallifeobject.coffeemaker;

public class Guest {
    public static void main(String[] args) {
        CoffeeMaker keurig = new CoffeeMaker();

        keurig.selectBase(new Decaf());
        keurig.checkout();

        keurig.selectBase(new Espresso());
        keurig.addMilk();
        keurig.addChocolate();
        keurig.addMilk();
        keurig.checkout();
    }
}
