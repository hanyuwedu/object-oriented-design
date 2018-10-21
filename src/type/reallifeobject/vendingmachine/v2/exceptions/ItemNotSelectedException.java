package type.reallifeobject.vendingmachine.v2.exceptions;

public class ItemNotSelectedException extends RuntimeException {
    public ItemNotSelectedException(String message) {
        super(message);
    }

    public ItemNotSelectedException() {
        this("Item is not selected!");
    }
}
