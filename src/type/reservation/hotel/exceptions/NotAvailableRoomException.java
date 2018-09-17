package type.reservation.hotel.exceptions;

public class NotAvailableRoomException extends RuntimeException {
    public NotAvailableRoomException() {
        this("Not available rooms can be found for this search request");
    }

    public NotAvailableRoomException(String msg) {
        super(msg);
    }
}
