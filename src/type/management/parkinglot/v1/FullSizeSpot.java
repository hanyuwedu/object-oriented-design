package type.management.parkinglot.v1;

public class FullSizeSpot extends Spot {
    public FullSizeSpot(int column, int row) {
        super(column, row);
    }

    @Override
    public int getRow() {
        return super.row;
    }

    @Override
    public int getColumn() {
        return super.column;
    }

    @Override
    public Type getType() {
        return Type.SUV;
    }
}
