package type.reallifeobject.vendingmachine.v2;

import type.reallifeobject.vendingmachine.v2.products.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guest {
    public static void main(String[] args) throws Exception {
//        inventoryTest();
        vendingmachingTest();
    }

    public static void vendingmachingTest() throws Exception {
        List<ProductType> productTypeList = new ArrayList<>();
        productTypeList.addAll(Arrays.asList(ProductType.values()));

        VendingMachine vs = new VendingMachine(productTypeList);
        vs.printInfo();
        System.out.println();

        vs.refill(ProductType.COKE, 3);
        vs.refill(ProductType.BOTTLEWATER, 2);
        vs.refill(ProductType.SPRITE, 1);
        vs.printInfo();
        System.out.println();

        vs.select(ProductType.COKE);
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

        vs.select(ProductType.SPRITE);
        vs.printInfo();
        vs.select(ProductType.BOTTLEWATER);
        vs.printInfo();
        System.out.println();

        vs.pay(2.75);
        vs.printInfo();
        System.out.println();

        vs.cancel();
        vs.printInfo();
        System.out.println();

        vs.select(ProductType.SPRITE);
        vs.pay(2.0);
        Product sprite = vs.get();
        System.out.println(sprite);
        vs.printInfo();
        System.out.println();

        /// throw exception
//        vs.select(ProductType.SPRITE);
        vs.refill(ProductType.SPRITE, 2);
        vs.printInfo();
        vs.select(ProductType.SPRITE);
        vs.printInfo();
    }

    public static void inventoryTest() throws Exception {
        List<ProductType> productTypeList = new ArrayList<>();
        productTypeList.addAll(Arrays.asList(ProductType.values()));

        Inventory inventory = new Inventory(productTypeList);
        System.out.println(inventory);
        System.out.println();

        inventory.refill(ProductType.COKE, 3);
        inventory.refill(ProductType.BOTTLEWATER, 2);
        inventory.refill(ProductType.SPRITE, 1);
        System.out.println(inventory.contains(ProductType.SPRITE));
        System.out.println(inventory);

        Product sprite = inventory.get(ProductType.SPRITE);
        System.out.println(sprite);
        System.out.println(inventory);
        System.out.println(inventory.contains(ProductType.SPRITE));
        System.out.println();

        /// Should throw exception
//        sprite = inventory.get(ProductType.SPRITE);

        Product coke1 = inventory.get(ProductType.COKE);
        Product coke2 = inventory.get(ProductType.COKE);
        System.out.println(coke1 == coke2);
        System.out.println(inventory);
    }
}
