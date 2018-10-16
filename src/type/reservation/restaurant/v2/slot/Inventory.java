package type.reservation.restaurant.v2.slot;

import type.reservation.restaurant.v2.exceptions.InvalidSearchCriteriaException;
import type.reservation.restaurant.v2.exceptions.NotAvailableTimeSlotException;
import type.reservation.restaurant.v2.module.Availability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private static final int RESERVATION_PERIOD = 1;
    private Map<Integer, Map<Integer, Map<TableSize, Integer>>> slots;

    /**
     * @param openTime starting time to accept reservation
     * @param closeTime ending time to finish reservation
     * @param largeTables count of large tables
     * @param midTables count of mid tables
     * @param smallTables count of small tables
     */
    public Inventory(int openTime, int closeTime, int largeTables, int midTables, int smallTables) {
        if (openTime < 0 || closeTime <= openTime || closeTime > 24) {
            throw new InvalidSearchCriteriaException("Time range is invalid!");
        }

        if (largeTables < 0 || midTables < 0 || smallTables < 0) {
            throw new InvalidSearchCriteriaException("table count is invalid!");
        }

        this.slots = new HashMap<>();

        for (int i = openTime; i <= closeTime - RESERVATION_PERIOD; i+=RESERVATION_PERIOD) {
            slots.put(i, new HashMap<>());
            slots.get(i).put(i + RESERVATION_PERIOD, new HashMap<>());

            slots.get(i).get(i + RESERVATION_PERIOD).put(TableSize.LARGE, largeTables);
            slots.get(i).get(i + RESERVATION_PERIOD).put(TableSize.MID, midTables);
            slots.get(i).get(i + RESERVATION_PERIOD).put(TableSize.SMALL, smallTables);
        }
    }

    /**
     * Search whether there are tables at given criteria left, has to be matched perfectly
     *
     * @param fromTime reservation start time
     * @param toTime reservation end time
     * @param tableSize reservation tableSize
     * @return whether there are tables left accordingly
     */
    public boolean search(int fromTime, int toTime, TableSize tableSize) {
        if (this.slots.get(fromTime) == null ||
                this.slots.get(fromTime).get(toTime) == null ||
                this.slots.get(fromTime).get(toTime).get(tableSize) == null) {
            throw new InvalidSearchCriteriaException("Input search request is invalid!");
        }

        return this.slots.get(fromTime).get(toTime).get(tableSize) > 0;
    }

    /**
     * Search for all candidates on given search range
     *
     * @param startTime starting time in a search range
     * @param endTime end time in a search range
     * @param partySize party size of given search
     * @return all candidates that meets search request
     */
    public List<Availability> searchRange(int startTime, int endTime, int partySize) {
        List<Availability> results = new ArrayList<>();

        for (Integer fromTime : this.slots.keySet()) {
            if (fromTime >= startTime) {
                for (Integer toTime : this.slots.get(fromTime).keySet()) {
                    if (toTime <= endTime) {
                        Map<TableSize, Integer> availableTables = slots.get(fromTime).get(toTime);
                        for (TableSize tableSize : availableTables.keySet()) {
                            if (tableSize.getSize() >= partySize && availableTables.get(tableSize) > 0) {
                                results.add(new Availability(fromTime, toTime, tableSize));
                            }
                        }
                    }
                }
            }
        }

        return results;
    }

    /**
     * increase target reservation by 1
     *
     * @param fromTime reservation's start time
     * @param toTime resercation's end time
     * @param tableSize reservations's table size
     */
    public void increaseSlot(int fromTime, int toTime, TableSize tableSize) {
        this.update(fromTime, toTime, tableSize, 1);
    }

    /**
     * decrease target reservation by 1
     *
     * @param fromTime reservation's start time
     * @param toTime resercation's end time
     * @param tableSize reservations's table size
     */
    public void decreaseSlot(int fromTime, int toTime, TableSize tableSize) {
        this.update(fromTime, toTime, tableSize, -1);
    }

    /**
     * update given inventory with certain amount, usually +1 or -1;
     * @param fromTime reservation's starting time
     * @param toTime reservatioon's end time
     * @param tableSize reservation's table size
     * @param count count to update inventory
     */
    private void update(int fromTime, int toTime, TableSize tableSize, int count) {
        if (this.slots.get(fromTime) == null ||
                this.slots.get(fromTime).get(toTime) == null ||
                this.slots.get(fromTime).get(toTime).get(tableSize) == null) {
            throw new InvalidSearchCriteriaException("Input update request is invalid!");
        }

        if (this.slots.get(fromTime).get(toTime).get(tableSize) + count < 0) {
            throw new NotAvailableTimeSlotException("Current request has no spots left!");
        }

        this.slots.get(fromTime).get(toTime).put(tableSize,
                this.slots.get(fromTime).get(toTime).get(tableSize) + count);
    }

    public void print() {
        for (int fromTime : this.slots.keySet()) {
            for (int toTime : this.slots.get(fromTime).keySet()) {
                for (TableSize tableSize : this.slots.get(fromTime).get(toTime).keySet()) {
                    int count = this.slots.get(fromTime).get(toTime).get(tableSize);

                    System.out.println("From " + fromTime + " to " + toTime +
                            ", there are " + count + " " + tableSize.toString() + " tables left.");
                }
            }
        }
    }
}
