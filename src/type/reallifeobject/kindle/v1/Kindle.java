package type.reallifeobject.kindle.v1;

import type.reallifeobject.kindle.v1.books.Book;
import type.reallifeobject.kindle.v1.exceptions.BookAlreadyExistException;
import type.reallifeobject.kindle.v1.exceptions.BookDoesNotExistException;
import type.reallifeobject.kindle.v1.readers.IReader;
import type.reallifeobject.kindle.v1.readers.ReaderFactory;

import java.util.HashSet;
import java.util.Set;

public class Kindle {
    private Set<Book> shelf;

    public Kindle() {
        this.shelf = new HashSet<>();
    }

    public void download(Book book) {
        if (this.shelf.contains(book)) {
            throw new BookAlreadyExistException();
        }
        this.shelf.add(book);
    }

    public void delete(Book book) {
        if (this.shelf.contains(book)) {
            this.shelf.remove(book);
        } else {
            throw new BookDoesNotExistException();
        }
    }

    public void read(Book book) {
        if (!this.shelf.contains(book)) {
            throw new BookDoesNotExistException();
        }
        IReader reader = ReaderFactory.getSingleton().getReader(book);
        reader.read(book);
    }
}
