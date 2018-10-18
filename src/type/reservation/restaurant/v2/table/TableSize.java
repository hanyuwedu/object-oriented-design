package type.reservation.restaurant.v2.table;

public enum TableSize {
    LARGE(6),
    MID(4),
    SMALL(2);

    private int size;

    TableSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
