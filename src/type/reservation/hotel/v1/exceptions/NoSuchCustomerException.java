package type.reservation.hotel.v1.exceptions;

public class NoSuchCustomerException extends RuntimeException {
    public NoSuchCustomerException() {
        this("This customer does not exist in the system");
    }

    public NoSuchCustomerException(String msg) {
        super(msg);
    }
}
