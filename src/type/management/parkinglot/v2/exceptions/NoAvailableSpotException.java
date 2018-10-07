package type.management.parkinglot.v2.exceptions;

public class NoAvailableSpotException extends RuntimeException {
    public NoAvailableSpotException(String message) {
        super(message);
    }
}
