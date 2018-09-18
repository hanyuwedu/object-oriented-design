package type.reallifeobject.kindle.books;

public abstract class Book {
    protected String name;
    protected String content;
    protected Format format;

    public Book(String name, String content, Format format) {
        this.name = name;
        this.content = content;
        this.format = format;
    }

    public String getName() {
        return this.name;
    }

    public String getContent() {
        return this.content;
    }

    public Format getFormat() {
        return this.format;
    }
}
