package type.reservation.restaurant.v2.module;

import type.reservation.restaurant.v2.slot.TableSize;

public class Availability {
    private int fromTime, toTime;
    private TableSize tableSize;

    public Availability(int startTime, int endTime, TableSize tableSize) {
        this.fromTime = startTime;
        this.toTime = endTime;
        this.tableSize = tableSize;
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
        return "Availability from " + fromTime + " to " + toTime + " with a " + this.tableSize.toString() + " table.";
    }
}
