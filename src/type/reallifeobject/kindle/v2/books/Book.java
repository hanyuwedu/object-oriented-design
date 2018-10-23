package type.reallifeobject.kindle.v2.books;

public abstract class Book {
    protected String name;
    protected Format format;
    protected String content;

    protected Book(String name, Format format, String content) {
        this.name = name;
        this.format = format;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public Format getFormat() {
        return format;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return this.name + " is in the format of " + this.format + ".";
    }
}
