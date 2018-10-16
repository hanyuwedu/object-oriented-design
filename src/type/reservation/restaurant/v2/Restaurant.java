package type.reservation.restaurant.v2;

import type.reservation.restaurant.v2.module.Reservation;
import type.reservation.restaurant.v2.module.SearchCriteria;
import type.reservation.restaurant.v2.module.Availability;
import type.reservation.restaurant.v2.slot.Inventory;

import java.util.List;

public class Restaurant {
    private Inventory inventory;

    public Restaurant() {
        this(8, 20, 2, 2, 2);
    }

    public Restaurant(int openTime, int closeTime, int largeTables, int midTables, int smallTables) {
        this.inventory = new Inventory(openTime, closeTime, largeTables, midTables, smallTables);
    }

    /**
     * Search with given criteria condition
     *
     * @param searchCriteria given search criteria from client
     * @return collection of all search result
     */
    public List<Availability> search(SearchCriteria searchCriteria) {
        return this.inventory.searchRange(searchCriteria.getStartTime(),
                searchCriteria.getEndTime(),
                searchCriteria.getPartySize());
    }

    /**
     * Reserve from a selected search result, decrease from inventory
     *
     * @param customer customer who makes the reservation
     * @param availability selected search result that would make into a reservation
     * @return a reservation made by customer
     */
    public Reservation reserve(Customer customer, Availability availability) {
        this.inventory.decreaseSlot(availability.getFromTime(), availability.getToTime(), availability.getTableSize());
        return new Reservation(customer, availability.getFromTime(), availability.getToTime(), availability.getTableSize());
    }

    /**
     * cancel the input reservation, increase inventory accordingly
     *
     * @param reservation target reservation to be cancelled
     */
    public void cancel(Reservation reservation) {
        this.inventory.increaseSlot(reservation.getFromTime(), reservation.getToTime(), reservation.getTableSize());
        System.out.println(reservation.toString() + " has been cancelled.");
    }

    public Inventory getInventory() {
        return inventory;
    }
}
