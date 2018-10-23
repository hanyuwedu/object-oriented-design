package type.reallifeobject.kindle.v2.readers;

import type.reallifeobject.kindle.v1.exceptions.FormatUnrecognizedException;
import type.reallifeobject.kindle.v2.books.Format;

public class ReaderFactory {
    public static Reader getReader(Format format) {
        if (format.equals(Format.EPUB)) {
            return EpubReader.getEpubReader();
        } else if (format.equals(Format.MOBI)) {
            return MobiReader.getMobiReader();
        } else if (format.equals(Format.PDF)) {
            return PdfReader.getPdfReader();
        } else {
            throw new FormatUnrecognizedException();
        }
    }
}
