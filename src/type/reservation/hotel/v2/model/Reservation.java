package type.reservation.hotel.v2.model;

import type.reservation.hotel.v2.Customer;
import type.reservation.hotel.v2.room.RoomType;

import java.time.LocalDate;

public class Reservation {
    private Customer customer;
    private LocalDate checkin, checkout;
    private RoomType roomType;
    private Double price;

    public Reservation(Customer customer,
                       LocalDate checkin,
                       LocalDate checkout,
                       RoomType roomType,
                       Double price) {
        this.customer = customer;
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomType = roomType;
        this.price = price;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public void setRoomType(RoomType roomType) {
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
        sb.append(customer);
        sb.append(" has reserved a ");
        sb.append(this.roomType);
        sb.append(" from ");
        sb.append(this.checkin);
        sb.append(" to ");
        sb.append(this.checkout);
        sb.append(". Total cost is $");
        sb.append(this.price);

        return sb.toString();
    }
}
