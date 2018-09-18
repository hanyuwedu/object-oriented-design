package type.reallifeobject.kindle;

import type.reallifeobject.kindle.books.Book;
import type.reallifeobject.kindle.exceptions.BookAlreadyExistException;
import type.reallifeobject.kindle.exceptions.BookDoesNotExistException;
import type.reallifeobject.kindle.readers.IReader;
import type.reallifeobject.kindle.readers.ReaderFactory;

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
