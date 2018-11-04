package patterns.creational.factory.readers;

import patterns.creational.factory.books.Book;

public class EpubReader implements Reader {
    @Override
    public void display(Book book) {
        String epubString = book.getContent();
        String content = epubString.replace("[epub]", " ");
        System.out.println(content);
    }
}
