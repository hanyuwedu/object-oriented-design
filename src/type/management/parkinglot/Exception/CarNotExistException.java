package type.management.parkinglot.Exception;

public class CarNotExistException extends RuntimeException {
    public CarNotExistException(String message) {
        super(message);
    }
}
