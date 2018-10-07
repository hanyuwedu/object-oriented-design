package type.management.parkinglot.v1;

public class SpotFactory {
    private static SpotFactory spotFactory;

    private SpotFactory() {}

    public static SpotFactory getSingleton() {
        if (spotFactory == null) {
            spotFactory = new SpotFactory();
        }

        return spotFactory;
    }

    public Spot getSpot(Type type, int column, int row) {
        if (type.equals(Type.COMPACT)) {
            return getCompactSpot(column, row);
        } else if (type.equals(Type.SUV)) {
            return getFullSizeSpot(column, row);
        } else {
            return null;
        }
    }

    private CompactSpot getCompactSpot(int column, int row) {
        return new CompactSpot(column, row);
    }

    private FullSizeSpot getFullSizeSpot(int column, int row) {
        return new FullSizeSpot(column, row);
    }
}
