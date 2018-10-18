package type.reservation.hotel.v2.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        this("Request in invalid!");
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
