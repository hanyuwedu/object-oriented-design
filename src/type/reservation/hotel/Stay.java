package type.reservation.hotel;

import java.time.LocalDate;

public class Stay {
    RoomType roomType;
    int date;

    public Stay(RoomType roomType, int date) {
        this.roomType = roomType;
        this.date = date;
    }

    @Override
    public String toString() {
        return "[" + this.roomType.name().toLowerCase() + ", " + this.date + "]";
    }
}
