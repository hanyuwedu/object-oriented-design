package jiuzhang.kindleOODesign;

import java.util.HashSet;
import java.util.Set;

public class KindleOODesign {
    public class Kindle {
        private Set<Book> shelf;
        private EBookReaderFactory eBookReaderFactory;

        public Kindle() {
            this.shelf = new HashSet<>();
            this.eBookReaderFactory = new EBookReaderFactory();
        }

        public String readBook(Book book) throws Exception {
            EBookReader reader = this.eBookReaderFactory.createReader(book);
            if (reader == null) {
                throw new Exception("Unknown book type");
            }

            String content = reader.displayReaderType();
            content += ", book content is: ";
            content += reader.readBook();
            return content;
        }

        public void downloadBook(Book b) {
            this.shelf.add(b);
        }

        public void uploadBook(Book b) {
            //write your code here
        }

        public void deleteBook(Book b) {
            this.shelf.remove(b);
        }
    }

    enum Format {
        EPUB("epub"), PDF("pdf"), MOBI("mobi");

        private String content;

        Format(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    class Book {
        private Format format;

        public Book(Format format) {
            this.format = format;
        }

        public Format getFormat() {
            return format;
        }
    }

    abstract class EBookReader {

        protected Book book;

        public EBookReader(Book b){
            this.book = b;
        }

        public abstract String readBook();
        public abstract String displayReaderType();
    }

    class EBookReaderFactory {

        public EBookReader createReader(Book b) {
            switch (b.getFormat()) {
                case EPUB:
                    return new EpubReader(b);
                case PDF:
                    return new PdfReader(b);
                case MOBI:
                    return new MobiReader(b);
            }

            return null;
        }
    }

    class EpubReader extends EBookReader{

        public EpubReader(Book b) {
            super(b);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String readBook() {
            return Format.EPUB.getContent();
        }

        @Override
        public String displayReaderType() {
            // TODO Auto-generated method stub
            return "Using EPUB reader";
        }
    }

    class MobiReader extends EBookReader {

        public MobiReader(Book b) {
            super(b);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String readBook() {
            return Format.MOBI.getContent();
        }

        @Override
        public String displayReaderType() {
            // TODO Auto-generated method stub
            return "Using MOBI reader";
        }

    }
    class PdfReader extends EBookReader{

        public PdfReader(Book b) {
            super(b);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String readBook() {
            return Format.PDF.getContent();
        }

        @Override
        public String displayReaderType() {
            // TODO Auto-generated method stub
            return "Using PDF reader";
        }
    }
}
