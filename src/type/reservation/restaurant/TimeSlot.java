package type.reservation.restaurant;

public class TimeSlot implements Comparable<TimeSlot> {
    int from, to;

    public TimeSlot(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "from " + from + ", to: " + to;
    }

    @Override
    public int compareTo(TimeSlot another) {
        return this.from - another.from;
    }
}
