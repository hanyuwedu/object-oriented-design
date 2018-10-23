package type.reallifeobject.kindle.v2;

import type.reallifeobject.kindle.v2.books.Book;
import type.reallifeobject.kindle.v2.exceptions.BookDoesNotExistException;
import type.reallifeobject.kindle.v2.readers.Reader;
import type.reallifeobject.kindle.v2.readers.ReaderFactory;

public class Kindle {
    private Shelf shelf;

    public Kindle() {
        this.shelf = new Shelf();
    }

    /**
     * 添加新书至Kindle的书库
     *
     * @param book 目标书
     */
    public void download(Book book) {
        this.shelf.add(book);
    }

    /**
     * 从Kindle书库中移除旧书
     *
     * @param book 目标书
     */
    public void delete(Book book) {
        this.shelf.remove(book);
    }

    /**
     * 返回书中的内容，以格式区分
     *
     * @param book 目标书
     * @return 以格式区分的内容
     */
    public String read(Book book) {
        if (!this.shelf.contains(book)) {
            throw new BookDoesNotExistException();
        }

        Reader reader = ReaderFactory.getReader(book.getFormat());
        return reader.read(book);
    }

    @Override
    public String toString() {
        return this.shelf.toString();
    }
}
