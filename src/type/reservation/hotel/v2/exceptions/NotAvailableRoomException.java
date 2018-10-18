package type.reservation.hotel.v2.exceptions;

public class NotAvailableRoomException extends RuntimeException {
    public NotAvailableRoomException() {
        this("Not available room by this searching criteria");
    }

    public NotAvailableRoomException(String message) {
        super(message);
    }
}
