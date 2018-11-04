package patterns.creational.factory.books;

public class HeadFirstDesignPattern extends Book {
    @Override
    public Format getFormat() {
        return Format.MOBI;
    }

    @Override
    public String getContent() {
        return "Head{mobi}First{mobi}Design{mobi}Pattern";
    }
}
