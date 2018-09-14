package type.reservation.restaurant.exceptions;

public class InvalidSearchCriteriaException extends RuntimeException {
    public InvalidSearchCriteriaException() {
        this("Search criteria is invalid!");
    }

    public InvalidSearchCriteriaException(String message) {
        super(message);
    }
}
