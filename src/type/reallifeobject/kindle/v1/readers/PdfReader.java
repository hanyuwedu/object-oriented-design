package type.reallifeobject.kindle.v1.readers;

import type.reallifeobject.kindle.v1.books.Book;

public class PdfReader implements IReader {

    private static PdfReader pdfReader;

    private PdfReader(){}

    public static PdfReader getSingleton() {
        if (pdfReader == null) {
            pdfReader = new PdfReader();
        }
        return pdfReader;
    }

    @Override
    public void read(Book book) {
        String mobiString = book.getContent();
        String content = mobiString.replace("<pdf>", " ");
        System.out.println(content);
    }
}
