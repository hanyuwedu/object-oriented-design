package type.reservation.restaurant.v1;

import java.util.List;

public class Customer {
    private String name;
    private Restaurant restaurant;      /// Is this the correct way to put a manager system into the field?

    public Customer(String name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
    }

    public String getName() {
        return this.name;
    }

    public TimeSlot select(List<TimeSlot> timeSlotList) {
        /// Always select the mid one.
        TimeSlot timeSlot = timeSlotList.get(timeSlotList.size() / 2);
        this.restaurant.select(this, timeSlot);

        return timeSlot;
    }

    public void cancel() {
        this.restaurant.cancel(this);
    }

    public List<TimeSlot> search(int from, int to) {
        return this.restaurant.search(new TimeSlot(from, to));
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
