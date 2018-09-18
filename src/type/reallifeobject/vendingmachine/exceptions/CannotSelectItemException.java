package type.reallifeobject.vendingmachine.exceptions;

public class CannotSelectItemException extends RuntimeException {
    public CannotSelectItemException() {
        this("Cannot select this item.");
    }

    public CannotSelectItemException(String message) {
        super(message);
    }
}
