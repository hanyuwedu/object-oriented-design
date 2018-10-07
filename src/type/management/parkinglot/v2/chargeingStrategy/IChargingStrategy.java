package type.management.parkinglot.v2.chargeingStrategy;

import type.management.parkinglot.v2.Vehicle.Vehicle;

import java.time.LocalDateTime;

public interface IChargingStrategy {
    double getCost(Vehicle vehicle, LocalDateTime parkTime, LocalDateTime leaveTime);
}
