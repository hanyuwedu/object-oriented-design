package type.management.parkinglot.v3.chargingstrategy;


import type.management.parkinglot.v3.vehicle.Vehicle;
import java.time.LocalDateTime;

public class WeekendPolicy implements IChargingStrategy {
    public WeekendPolicy() { }

    @Override
    public double getCost(Vehicle vehicle, LocalDateTime parkTime, LocalDateTime leaveTime) {
        return 0;
    }
}
