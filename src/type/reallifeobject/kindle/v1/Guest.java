package type.reallifeobject.kindle.v1;

import type.reallifeobject.kindle.v1.books.Book;
import type.reallifeobject.kindle.v1.books.HeadFirstDesignPattern;
import type.reallifeobject.kindle.v1.books.Power;
import type.reallifeobject.kindle.v1.books.TestDrivenDevelopment;

public class Guest {
    public static void main(String[] args) {
        Kindle kindle = new Kindle();
        Book hfdp = new HeadFirstDesignPattern();
        Book power = new Power();
        Book tdd = new TestDrivenDevelopment();

        kindle.download(hfdp);

        kindle.read(hfdp);

        /// Exception
//        kindle.read(power);
        kindle.download(power);
        kindle.read(power);

        /// Exception
//        kindle.download(power);
        kindle.delete(power);

        /// Excepttion
//        kindle.read(power);

        kindle.download(tdd);
        kindle.read(tdd);
    }
}
