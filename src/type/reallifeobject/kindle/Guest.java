package type.reallifeobject.kindle;

import type.reallifeobject.kindle.books.Book;
import type.reallifeobject.kindle.books.HeadFirstDesignPattern;
import type.reallifeobject.kindle.books.Power;
import type.reallifeobject.kindle.books.TestDrivenDevelopment;

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
