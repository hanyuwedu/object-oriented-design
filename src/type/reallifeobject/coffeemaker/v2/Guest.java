package type.reallifeobject.coffeemaker.v2;

import type.reallifeobject.coffeemaker.v2.coffee.Decaf;
import type.reallifeobject.coffeemaker.v2.coffee.Espresso;
import type.reallifeobject.coffeemaker.v2.decorators.WithChocolate;
import type.reallifeobject.coffeemaker.v2.decorators.WithMilk;

import java.lang.reflect.InvocationTargetException;

public class Guest {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        coffeeTest();
//        coffeeMakerTest();
        coffeeMakerTestWithCoffeePack();
    }

    public static void coffeeTest() {
        Coffee decaf = new Decaf();
        decaf.printDetail();
        System.out.println();

        Coffee espresso = new Espresso();
        espresso = new WithMilk(espresso);
        espresso = new WithChocolate(espresso);
        espresso = new WithChocolate(espresso);
        espresso = new WithMilk(espresso);

        espresso.printDetail();
    }

    private static void coffeeMakerTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CoffeeMaker keurig = new CoffeeMaker();
        keurig.setCoffee(Espresso.class);
        keurig.addChocolate();
        keurig.addMilk();
        keurig.addChocolate();

        Coffee espresso = keurig.makeCoffee();
        espresso.printDetail();

        /// Throw exception
//        Coffee nullCoffee = keurig.getCoffee();
//        keurig.addMilk();
    }

    private static void coffeeMakerTestWithCoffeePack() {
        CoffeeMaker keurig = new CoffeeMaker();
        CoffeePack pureMilk = new CoffeePack(new Espresso(), 0, 2);
        keurig.importCoffeePack(pureMilk);
        Coffee espresso = keurig.makeCoffee();
        espresso.printDetail();

        CoffeePack mixedCoffeePack = new CoffeePack(new Decaf(), 2, 3);
        keurig.importCoffeePack(mixedCoffeePack);
        Coffee decaf = keurig.makeCoffee();
        decaf.printDetail();

        keurig.importCoffeePack(mixedCoffeePack);
        keurig.addChocolate();
        keurig.addChocolate();
        Coffee heavyChocolateDecaf = keurig.makeCoffee();

        heavyChocolateDecaf.printDetail();

        /// Throw exception
        CoffeePack baseNotSelectedCoffeePack = new CoffeePack(null, 1, 1);
//        keurig.importCoffeePack(baseNotSelectedCoffeePack);
    }
}
