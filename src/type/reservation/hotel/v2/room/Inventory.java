package type.reservation.hotel.v2.room;


import type.reservation.hotel.v2.exceptions.InvalidRequestException;
import type.reservation.hotel.v2.model.Availability;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<LocalDate, Map<RoomType, Integer>> rooms;
    private Map<LocalDate, Map<RoomType, Double>> prices;

    public Inventory() {
        this.rooms = new HashMap<>();
        this.prices = new HashMap<>();
    }

    /**
     * check if given room on a specified date is available
     *
     * @param date input date
     * @param roomType input room type
     * @return whether this room is available on input date
     */
    public boolean isAvailable(LocalDate date, RoomType roomType) {
        if (!this.rooms.containsKey(date)
                || !this.rooms.get(date).containsKey(roomType)) {
            throw new InvalidRequestException("Given date or room type is invalid!");
        }

        return this.rooms.get(date).get(roomType) > 0;
    }

    /**
     * Search for all candidates on given search range
     *
     * @param from start of a date range(included)
     * @param to end of a date range(included)
     * @param partySize amount of people to sttay
     * @return all candidates that meets the search request
     */
    public List<Availability> search(LocalDate from, LocalDate to, int partySize) {
        List<Availability> availabilities = new ArrayList<>();

        for (RoomType roomType : RoomType.values()) {
            if (roomType.getCapacity() < partySize) {
                continue;
            }

            boolean notFull = true;
            for (LocalDate date = from; !date.isAfter(to); date = date.plusDays(1)) {
                if (!this.isAvailable(date, roomType)) {
                    notFull = false;
                    break;
                }
            }

            if (notFull) {
                Availability availability = new Availability(from, to, roomType);
                availability.setPrice(this.getPrice(from, to, roomType));

                availabilities.add(availability);
            }
        }

        return availabilities;
    }

    /**
     * increase inventory room by 1, on a given date range
     *
     * @param from give date range start(included)
     * @param to given date range end(included)
     * @param roomType given room type to be increased (by 1)
     */
    public void increaseRoom(LocalDate from, LocalDate to, RoomType roomType) {
        this.update(from, to, roomType, 1);
    }

    /**
     * Decrease inventory room by 1, on a given date range
     *
     * @param from give date range start(included)
     * @param to given date range end(included)
     * @param roomType given room type to be decreased (by 1)
     */
    public void decreaseRoom(LocalDate from, LocalDate to, RoomType roomType) {
        for (LocalDate date = from; !date.isAfter(to); date = date.plusDays(1)) {
            if (!this.isAvailable(date, roomType)) {
                throw new InvalidRequestException(date.toString() + " is running out of room for " + roomType.toString());
            }
        }

        this.update(from, to, roomType, -1);
    }

    /**
     * update room amount on a given range
     *
     * @param from give date range start(included)
     * @param to given date range end(included)
     * @param roomType given room type to be updated
     * @param count amount of rooms to be updated, can be positive or negative
     */
    private void update(LocalDate from, LocalDate to, RoomType roomType, int count) {
        if (from.isAfter(to)) {
            throw new InvalidRequestException("Starting date is after end date!");
        }

        for (LocalDate date = from; !date.isAfter(to); date = date.plusDays(1)) {
            this.update(date, roomType, count);
        }
    }

    /**
     * update room amount on a given date
     *
     * @param date given date to be updated
     * @param roomType given room type to be updated
     * @param count amount of rooms to be updated, can be positive or negative
     */
    private void update(LocalDate date, RoomType roomType, int count) {
        if (!this.rooms.containsKey(date) || !this.rooms.get(date).containsKey(roomType)) {
            throw new InvalidRequestException("Date or roomtype is invalid!");
        }

        this.rooms.get(date).put(roomType, this.rooms.get(date).get(roomType) + count);
    }

    /**
     * @param date date on specified
     * @param roomType input room type
     * @return price for this room type at the date range
     */
    public double getPrice(LocalDate date, RoomType roomType) {
        if (!this.prices.containsKey(date) || !this.prices.get(date).containsKey(roomType)) {
            throw new InvalidRequestException("Given date or room type is invalid!");
        }

        return this.prices.get(date).get(roomType);
    }

    /**
     * @param from date range start(included)
     * @param to date range end(included)
     * @param roomType input room type
     * @return price for this room type at the date range
     */
    public double getPrice(LocalDate from, LocalDate to, RoomType roomType) {
        if (from.isAfter(to)) {
            throw new InvalidRequestException("Starting date is after end date!");
        }

        double price = 0;
        for (LocalDate date = from; !date.isAfter(to); date = date.plusDays(1)) {
            price += this.prices.get(date).get(roomType);
        }

        return price;
    }

    /**
     * @param date input date
     * @param roomType input room type
     * @return rooms left at a specific date
     */
    public int getRoomsLeft(LocalDate date, RoomType roomType) {
        return this.rooms.get(date).get(roomType);
    }

    /**
     * Set price for a given roomtype on a specific date
     *
     * @param date given date to be changed
     * @param roomType given room type to be changed
     * @param price price at which it will be changed
     */
    public void setPrice(LocalDate date, RoomType roomType, Double price) {
        if (!this.prices.containsKey(date) || !this.prices.get(date).containsKey(roomType)) {
            throw new InvalidRequestException("Given date or room type is invalid!");
        }

        this.prices.get(date).put(roomType, price);
    }

    public void setPrices(Map<LocalDate, Map<RoomType, Double>> prices) {
        this.prices = prices;
    }

    public void setRooms(Map<LocalDate, Map<RoomType, Integer>> rooms) {
        this.rooms = rooms;
    }

    public void printRoom() {
        System.out.println(this.rooms.toString());
    }

    public void printPrices() {
        System.out.println(this.prices.toString());
    }
}
