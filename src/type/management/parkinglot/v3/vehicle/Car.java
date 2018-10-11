package type.management.parkinglot.v3.vehicle;


import type.management.parkinglot.v3.spot.SpotSize;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle {
    public Car(String plate) {
        super(plate, VehicleSize.COMPACT, 1);
    }

    @Override
    public List<SpotSize> availableSpots() {
        List<SpotSize> availableSpots = new ArrayList<>();
        availableSpots.add(SpotSize.SMALL);
        availableSpots.add(SpotSize.LARGE);

        return availableSpots;
    }
}
