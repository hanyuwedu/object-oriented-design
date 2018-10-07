package type.management.parkinglot.v2.exceptions;

public class CarNotExistException extends RuntimeException {
    public CarNotExistException(String message) {
        super(message);
    }
}
