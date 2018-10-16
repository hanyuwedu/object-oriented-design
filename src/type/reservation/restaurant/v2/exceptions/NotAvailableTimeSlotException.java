package type.reservation.restaurant.v2.exceptions;

public class NotAvailableTimeSlotException extends RuntimeException {
    public NotAvailableTimeSlotException() {
        this("Not available Time Slot by this searching criteria");
    }

    public NotAvailableTimeSlotException(String message) {
        super(message);
    }
}
