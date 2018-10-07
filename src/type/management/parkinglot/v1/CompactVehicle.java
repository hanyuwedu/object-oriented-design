package type.management.parkinglot.v1;

public class CompactVehicle extends Vehicle {
    private String plate;

    public CompactVehicle(String plate) {
        this.plate = plate;
    }

    @Override
    public String getPlate() {
        return this.plate;
    }

    @Override
    public Type getType() {
        return Type.COMPACT;
    }
}
