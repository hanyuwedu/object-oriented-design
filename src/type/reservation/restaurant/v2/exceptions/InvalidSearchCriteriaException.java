package type.reservation.restaurant.v2.exceptions;

public class InvalidSearchCriteriaException extends RuntimeException {
    public InvalidSearchCriteriaException() {
        this("Search criteria is invalid!");
    }

    public InvalidSearchCriteriaException(String message) {
        super(message);
    }
}
