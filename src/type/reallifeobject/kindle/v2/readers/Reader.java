package type.reallifeobject.kindle.v2.readers;

import type.reallifeobject.kindle.v2.books.Book;

public interface Reader {

    /**
     * 返回目标书中的内容，以格式区分
     *
     * @param book 目标数目
     * @return 以格式区分的内容
     */
    String read(Book book);
}
