package type.management.parkinglot.v1;

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
