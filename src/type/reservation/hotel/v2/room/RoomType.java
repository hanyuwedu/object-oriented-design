package type.reservation.hotel.v2.room;

public enum RoomType {
    EXECUTIVE_SUITE(4),
    PRESIDENTIAL_SUITE(4),
    DELUX_DOUBLE(2),
    STANDARD_DOUBLE(2),
    SINGLE(1);

    private int capacity;

    RoomType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", " ");
    }
}
