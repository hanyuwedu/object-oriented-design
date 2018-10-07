package type.reallifeobject.kindle.v1.readers;

import type.reallifeobject.kindle.v1.books.Book;

public class MobiReader implements IReader {
    private static MobiReader mobiReader;

    private MobiReader(){}

    public static MobiReader getSingleton() {
        if (mobiReader == null) {
            mobiReader = new MobiReader();
        }
        return mobiReader;
    }

    @Override
    public void read(Book book) {
        String mobiString = book.getContent();
        String content = mobiString.replace("{mobi}", " ");
        System.out.println(content);
    }
}
