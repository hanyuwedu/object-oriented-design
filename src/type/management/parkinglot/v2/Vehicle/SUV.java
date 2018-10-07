package type.management.parkinglot.v2.Vehicle;

import type.management.parkinglot.v2.Spot.SpotSize;

import java.util.ArrayList;
import java.util.List;

public class SUV extends Vehicle {
    public SUV(String plate) {
        super(plate, VehicleSize.SUV, 1);
    }

    @Override
    public List<SpotSize> availableSpots() {
        List<SpotSize> availableSpots = new ArrayList<>();
        availableSpots.add(SpotSize.LARGE);

        return availableSpots;
    }
}
