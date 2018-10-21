package type.reallifeobject.vendingmachine.v2.exceptions;

public class NotEnoughItemException extends RuntimeException {
    public NotEnoughItemException(String message) {
        super(message);
    }

    public NotEnoughItemException() {
        this("Selected item is running out");
    }
}
