package type.reallifeobject.kindle.v2.readers;

import type.reallifeobject.kindle.v2.books.Book;

public class PdfReader implements Reader {
    private static PdfReader pdfReader;
    private PdfReader(){}

    public static PdfReader getPdfReader() {
        if (pdfReader == null) {
            pdfReader = new PdfReader();
        }
        return pdfReader;
    }

    @Override
    public String read(Book book) {
        String mobiString = book.getContent();
        String content = mobiString.replace("<pdf>", " ");
        return content;
    }
}
