package type.reservation.hotel.v1.exceptions;

public class InvalidSearchCriteriaException extends RuntimeException {
    public InvalidSearchCriteriaException() {
        this("Input search criteria is invalid!");
    }

    public InvalidSearchCriteriaException(String msg) {
        super(msg);
    }
}
