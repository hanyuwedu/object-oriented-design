package type.reallifeobject.vendingmachine.v2.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        this("Request in invalid!");
    }

    public InvalidRequestException(String msg) {
        super(msg);
    }
}
