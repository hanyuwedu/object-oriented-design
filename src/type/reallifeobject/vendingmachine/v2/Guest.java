package type.reallifeobject.vendingmachine.v2;

import type.reallifeobject.vendingmachine.v2.products.*;

public class Guest {
    public static void main(String[] args) throws Exception {
//        inventoryTest();
        vendingmachingTest();
    }

    public static void vendingmachingTest() throws Exception {
        VendingMachine vs = new VendingMachine(BottleWater.class, Coke.class, Sprite.class);
        vs.printInfo();
        System.out.println();

        vs.refill(Coke.class, 3);
        vs.refill(BottleWater.class, 2);
        vs.refill(Sprite.class, 1);
        vs.printInfo();
        System.out.println();

        vs.select(Coke.class);
        vs.printInfo();
        System.out.println();

        vs.pay(0.5);
        vs.printInfo();
        System.out.println();

        /// should throw exception
//        vs.get();

        vs.pay(2.00);
        vs.printInfo();
        System.out.println();

        Product coke = vs.get();
        vs.printInfo();
        System.out.println(coke);
        System.out.println();

        /// should throw exception
//        vs.pay(3.00);

        vs.select(Sprite.class);
        vs.printInfo();
        vs.select(BottleWater.class);
        vs.printInfo();
        System.out.println();

        vs.pay(2.75);
        vs.printInfo();
        System.out.println();

        vs.cancel();
        vs.printInfo();
        System.out.println();

        vs.select(Sprite.class);
        vs.pay(2.0);
        Product sprite = vs.get();
        System.out.println(sprite);
        vs.printInfo();
        System.out.println();

        /// throw exception
//        vs.select(Sprite.class);
        vs.refill(Sprite.class, 2);
        vs.printInfo();
        vs.select(Sprite.class);
        vs.printInfo();
    }

    public static void inventoryTest() throws Exception {
        Inventory inventory = new Inventory(BottleWater.class, Coke.class, Sprite.class);
        System.out.println(inventory);
        System.out.println();

        inventory.refill(Coke.class, 3);
        inventory.refill(BottleWater.class, 2);
        inventory.refill(Sprite.class, 1);
        System.out.println(inventory.contains(Sprite.class));
        System.out.println(inventory);

        Product sprite = inventory.get(Sprite.class);
        System.out.println(sprite);
        System.out.println(inventory);
        System.out.println(inventory.contains(Sprite.class));
        System.out.println();

        /// Should throw exception
//        sprite = inventory.get(Sprite.class);

        Product coke1 = inventory.get(Coke.class);
        Product coke2 = inventory.get(Coke.class);
        System.out.println(coke1 == coke2);
        System.out.println(inventory);
    }
}
