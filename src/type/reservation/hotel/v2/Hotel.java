package type.reservation.hotel.v2;

import type.reservation.hotel.v2.model.Availability;
import type.reservation.hotel.v2.model.Reservation;
import type.reservation.hotel.v2.model.SearchCriteria;
import type.reservation.hotel.v2.module.HotelConfigModule;
import type.reservation.hotel.v2.room.Inventory;
import type.reservation.hotel.v2.room.RoomType;

import java.time.LocalDate;
import java.util.List;

public class Hotel {
    private Inventory inventory;

    public Hotel() {
        this.inventory = new Inventory();
        HotelConfigModule.initializeInventory(inventory);
    }

    /**
     * Search with given criteria condition
     *
     * @param searchCriteria given search criteria from client
     * @return collection of all search result
     */
    public List<Availability> search(SearchCriteria searchCriteria) {
        return this.inventory.search(searchCriteria.getCheckin(),
                searchCriteria.getCheckout().minusDays(1),
                searchCriteria.getPartySize());
    }

    /**
     * Reserve from a selected search result, after success payment decrease from inventory
     *
     * @param customer customer who makes the reservation
     * @param availability selected search result that would make into a reservation
     * @return a reservation made by customer
     */
    public Reservation reserve(Customer customer, Availability availability) {
        this.inventory.decreaseRoom(availability.getFrom(),
                availability.getTo(),
                availability.getRoomType());

        Reservation reservation = new Reservation(customer,
                availability.getFrom(),
                availability.getTo().plusDays(1),
                availability.getRoomType(),
                availability.getPrice());

        System.out.println("A payment of $" + availability.getPrice() + " has been paid.");
        System.out.println(reservation.toString() + " has been issued.");

        return reservation;
    }

    /**
     * cancel the input reservation, increase inventory accordingly
     *
     * @param reservation target reservation to be cancelled
     */
    public void cancel(Reservation reservation) {
        LocalDate from = reservation.getCheckin();
        LocalDate to = reservation.getCheckout().minusDays(1);
        RoomType roomType = reservation.getRoomType();

        this.inventory.increaseRoom(from, to, roomType);
        System.out.println(reservation.toString() + " has been cancelled. " +
                "Amount of " + reservation.getPrice() +  "will be refund.");
    }

    /**
     * Set price for a given roomtype on a specific date
     *
     * @param date given date to be changed
     * @param roomType given room type to be changed
     * @param price price at which it will be changed
     */
    public void setPrice(LocalDate date, RoomType roomType, Double price) {
        this.inventory.setPrice(date, roomType, price);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
