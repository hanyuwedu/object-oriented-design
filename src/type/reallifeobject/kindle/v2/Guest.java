package type.reallifeobject.kindle.v2;

import type.reallifeobject.kindle.v2.samples.HeadFirstDesignPattern;
import type.reallifeobject.kindle.v2.samples.Power;
import type.reallifeobject.kindle.v2.samples.TestDrivenDevelopment;

public class Guest {
    public static void main(String[] args) {
//        shelfTest();
        kindleTest();
    }

    public static void shelfTest() {
        Power power = new Power();
        TestDrivenDevelopment tdd = new TestDrivenDevelopment();
        HeadFirstDesignPattern hfdp = new HeadFirstDesignPattern();

        Shelf shelf = new Shelf();
        shelf.add(power);
        shelf.add(tdd);

        System.out.println(shelf.toString());

        /// Throw exception
//        shelf.remove(hfdp);
//        shelf.add(power);
    }

    public static void kindleTest() {
        Power power = new Power();
        TestDrivenDevelopment tdd = new TestDrivenDevelopment();
        HeadFirstDesignPattern hfdp = new HeadFirstDesignPattern();

        Kindle kindle = new Kindle();

        kindle.download(hfdp);
        System.out.println(kindle.read(hfdp));

        // Throw exception
//        kindle.read(power);

        kindle.download(power);
        System.out.println(kindle.read(power));
        System.out.println(kindle);

        // Throw excpetion
//        kindle.download(power);
        kindle.delete(power);

        kindle.download(tdd);
        System.out.println(kindle.read(tdd));
        System.out.println(kindle);
    }
}
