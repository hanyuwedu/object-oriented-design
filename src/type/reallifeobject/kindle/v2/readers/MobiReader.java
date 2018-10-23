package type.reallifeobject.kindle.v2.readers;

import type.reallifeobject.kindle.v2.books.Book;

public class MobiReader implements Reader {
    private static MobiReader mobiReader;
    private MobiReader(){}

    public static MobiReader getMobiReader() {
        if (mobiReader == null) {
            mobiReader = new MobiReader();
        }
        return mobiReader;
    }

    @Override
    public String read(Book book) {
        String mobiString = book.getContent();
        String content = mobiString.replace("{mobi}", " ");
        return content;
    }
}
