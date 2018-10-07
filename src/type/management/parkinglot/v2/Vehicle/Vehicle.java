package type.management.parkinglot.v2.Vehicle;

import type.management.parkinglot.v2.Spot.SpotSize;

import java.util.List;

public abstract class Vehicle {
    protected String plate;
    protected VehicleSize vehicleSize;
    protected int neededSpot;

    protected Vehicle(String plate, VehicleSize vehicleSize, int neededSpot) {
        this.plate = plate;
        this.vehicleSize = vehicleSize;
        this.neededSpot = neededSpot;
    }

    abstract public List<SpotSize> availableSpots();

    public int getNeededSpot() {
        return this.neededSpot;
    }

    public String getPlate() {
        return plate;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    @Override
    public String toString() {
        return "<" + this.getPlate() + ", " + this.getVehicleSize() + ">";
    }
}
