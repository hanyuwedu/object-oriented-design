package type.management.parkinglot.v2.chargeingStrategy;

import type.management.parkinglot.v2.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class WeekendPolicy implements IChargingStrategy {
    public WeekendPolicy() { }

    @Override
    public double getCost(Vehicle vehicle, LocalDateTime parkTime, LocalDateTime leaveTime) {
        return 0;
    }
}
