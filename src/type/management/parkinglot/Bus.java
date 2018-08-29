package type.management.parkinglot;

public class Bus extends Vehicle {
    String plate;

    public Bus(String plate) {
        this.plate = plate;
    }

    @Override
    public String getPlate() {
        return this.plate;
    }

    @Override
    public Type getType() {
        return Type.BUS;
    }
}
