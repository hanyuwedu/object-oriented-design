package type.reservation.hotel.v2.model;

import type.reservation.hotel.v2.room.RoomType;

import java.time.LocalDate;

public class Availability {
    private LocalDate from, to;
    private RoomType roomType;
    private Double price;

    public Availability(LocalDate from, LocalDate to, RoomType roomType) {
        this.from = from;
        this.to = to;
        this.roomType = roomType;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Booking from ");
        sb.append(this.from);
        sb.append(" to ");
        sb.append(this.to);
        sb.append(" on a ");
        sb.append(this.roomType.toString());

        if (this.price != null) {
            sb.append(". Total price is ");
            sb.append(this.price);
        }

        return sb.toString();
    }
}
