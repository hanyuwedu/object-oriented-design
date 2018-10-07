package type.management.parkinglot.v1;

public abstract class Spot {
    int column, row;

    public abstract int getRow();
    public abstract int getColumn();
    public abstract Type getType();

    public Spot(int column, int row) {
        this.column = column;
        this.row = row;
    }
}
