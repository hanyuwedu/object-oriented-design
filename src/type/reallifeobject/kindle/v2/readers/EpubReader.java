package type.reallifeobject.kindle.v2.readers;

import type.reallifeobject.kindle.v2.books.Book;

public class EpubReader implements Reader {
    private static EpubReader epubReader;
    private EpubReader() {}

    public static EpubReader getEpubReader() {
        if (epubReader == null) {
            epubReader = new EpubReader();
        }
        return epubReader;
    }


    @Override
    public String read(Book book) {
        String mobiString = book.getContent();
        String content = mobiString.replace("[epub]", " ");
        return content;
    }
}
