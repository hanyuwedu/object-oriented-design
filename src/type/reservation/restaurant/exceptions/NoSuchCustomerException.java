package type.reservation.restaurant.exceptions;

public class NoSuchCustomerException extends RuntimeException {
    public NoSuchCustomerException() {
        this("This customer does not existed in the system");
    }

    public NoSuchCustomerException(String message) {
        super(message);
    }
}
