package patterns.factory;

public class Guest {
    public static void main(String[] args) {
        Book tdd = new TestDrivenDevelopment();
        Reader epubReader = new EpubReader();
        epubReader.display(tdd);

        Book hfdp = new HeadFirstDesignPattern();
        Reader mobiReader = new MobiReader();
        mobiReader.display(hfdp);

        /// By using factory design pattern:
        ReaderFactory readerFactory = ReaderFactory.getSingleton();
        Reader reader1 = readerFactory.generateReader(tdd);
        reader1.display(tdd);

        Reader reader2 = readerFactory.generateReader(hfdp);
        reader2.display(hfdp);
    }
}
