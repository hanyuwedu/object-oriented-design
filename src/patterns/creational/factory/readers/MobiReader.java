package patterns.creational.factory.readers;

import patterns.creational.factory.books.Book;
import patterns.creational.factory.readers.Reader;

public class MobiReader implements Reader {
    @Override
    public void display(Book book) {
        String mobiString = book.getContent();
        String content = mobiString.replace("{mobi}", " ");
        System.out.println(content);
    }
}
