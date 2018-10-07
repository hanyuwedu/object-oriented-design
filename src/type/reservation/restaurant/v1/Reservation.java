package type.reservation.restaurant.v1;

public class Reservation {
    Customer customer;
    TimeSlot timeSlot;

    public Reservation(Customer customer, TimeSlot timeSlot) {
        this.customer = customer;
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return customer + " has made the reservation " + timeSlot.toString();
    }
}
