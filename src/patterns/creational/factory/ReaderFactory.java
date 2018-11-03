package patterns.factory;

public class ReaderFactory {
    /// Factory should be singleton
    private static ReaderFactory readerFactory;

    private ReaderFactory() {}

    public static ReaderFactory getSingleton() {
        if (readerFactory == null) {
            readerFactory = new ReaderFactory();
        }
        return readerFactory;
    }


    public Reader generateReader(Book book) {
        if (book.getFormat().equals(Format.EPUB)) {
            return new EpubReader();
        } else if (book.getFormat().equals(Format.MOBI)) {
            return new MobiReader();
        } else {
            return null;
        }
    }
}
