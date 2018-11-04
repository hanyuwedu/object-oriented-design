package patterns.creational.factory.books;

public class TestDrivenDevelopment extends Book {
    @Override
    public Format getFormat() {
        return Format.EPUB;
    }

    @Override
    public String getContent() {
        return "Test[epub]Driven[epub]Development";
    }
}
