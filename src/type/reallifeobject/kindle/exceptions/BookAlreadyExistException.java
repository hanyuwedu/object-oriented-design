package type.reallifeobject.kindle.exceptions;

public class BookAlreadyExistException extends RuntimeException {
    public BookAlreadyExistException() {
        this("This book is already in this kindle.");
    }

    public BookAlreadyExistException(String message) {
        super(message);
    }
}
