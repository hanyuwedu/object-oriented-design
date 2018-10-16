package type.reservation.restaurant.v2.module;

import type.reservation.restaurant.v2.Customer;
import type.reservation.restaurant.v2.slot.TableSize;

public class Reservation {
    private Customer customer;
    private int fromTime, toTime;
    private TableSize tableSize;

    public Reservation(Customer customer, int startTime, int endTime, TableSize tableSize) {
        this.customer = customer;
        this.fromTime = startTime;
        this.toTime = endTime;
        this.tableSize = tableSize;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getFromTime() {
        return fromTime;
    }

    public int getToTime() {
        return toTime;
    }

    public TableSize getTableSize() {
        return tableSize;
    }

    @Override
    public String toString() {
        return "Reservation from " + fromTime + " to " + toTime
                + " with a " + this.tableSize.toString() + " table, reserved by " + this.customer.toString();
    }
}
