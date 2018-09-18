package type.reallifeobject.kindle.readers;

import type.reallifeobject.kindle.books.Book;
import type.reallifeobject.kindle.books.Format;
import type.reallifeobject.kindle.exceptions.FormatUnrecognizedException;

public class ReaderFactory {
    private static ReaderFactory readerFactory;

    private ReaderFactory(){}

    public static ReaderFactory getSingleton() {
        if (readerFactory == null) {
            readerFactory = new ReaderFactory();
        }
        return readerFactory;
    }

    public IReader getReader(Book book) {
        if (book.getFormat().equals(Format.PDF)) {
            return PdfReader.getSingleton();
        } else if (book.getFormat().equals(Format.MOBI)) {
            return MobiReader.getSingleton();
        } else if (book.getFormat().equals(Format.EPUB)) {
            return EpubReader.getSingleton();
        }

        throw new FormatUnrecognizedException();
    }
}
