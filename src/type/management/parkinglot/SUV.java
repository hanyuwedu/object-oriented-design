package type.management.parkinglot;

public class SUV extends Vehicle {
    private String plate;

    public SUV(String plate) {
        this.plate = plate;
    }

    @Override
    public String getPlate() {
        return this.plate;
    }

    @Override
    public Type getType() {
        return Type.SUV;
    }
}
