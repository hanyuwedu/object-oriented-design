package type.management.parkinglot.v3.chargingstrategy;
import type.management.parkinglot.v3.vehicle.Vehicle;

import java.time.LocalDateTime;

public interface IChargingStrategy {
    double getCost(Vehicle vehicle, LocalDateTime parkTime, LocalDateTime leaveTime);
}
