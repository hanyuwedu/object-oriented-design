package type.reallifeobject.kindle.v2;

import type.reallifeobject.kindle.v2.books.Book;
import type.reallifeobject.kindle.v2.exceptions.BookAlreadyExistException;
import type.reallifeobject.kindle.v2.exceptions.BookDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private List<Book> shelf;

    public Shelf() {
        this.shelf = new ArrayList<>();
    }

    /**
     * 为书库添加新书。如果已存在则抛出异常
     *
     * @param book 被添加的书
     */
    public void add(Book book) {
        if (this.shelf.contains(book)) {
            throw new BookAlreadyExistException();
        }

        this.shelf.add(book);
    }

    /**
     * 为书库删除旧书，如果不存在则抛出异常
     *
     * @param book 被移除的书
     */
    public void remove(Book book) {
        if (!this.shelf.contains(book)) {
            throw new BookDoesNotExistException();
        }

        this.shelf.remove(book);
    }

    /**
     * 书库是否存在指定书籍
     *
     * @param book 指定书
     * @return 是否存在
     */
    public boolean contains(Book book) {
        return this.shelf.contains(book);
    }

    @Override
    public String toString() {
        return this.shelf.toString();
    }
}
