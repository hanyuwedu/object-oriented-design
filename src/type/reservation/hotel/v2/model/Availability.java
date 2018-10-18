package type.reservation.hotel.v2.model;

import type.reservation.hotel.v2.room.RoomType;

import java.time.LocalDate;

public class Availability {
    private LocalDate checkin, checkout;
    private RoomType roomType;
    private Double price;

    public Availability(LocalDate checkin, LocalDate checkout, RoomType roomType) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomType = roomType;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
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
        sb.append(this.checkin);
        sb.append(" to ");
        sb.append(this.checkout);
        sb.append(" on a ");
        sb.append(this.roomType.toString());

        if (this.price != null) {
            sb.append(". Total price is ");
            sb.append(this.price);
        }

        return sb.toString();
    }
}
