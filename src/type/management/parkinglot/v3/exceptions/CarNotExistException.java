package type.management.parkinglot.v3.exceptions;

public class CarNotExistException extends RuntimeException {
    public CarNotExistException(String message) {
        super(message);
    }
}
