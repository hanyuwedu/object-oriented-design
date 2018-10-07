package type.management.parkinglot.v2.chargeingStrategy;

import type.management.parkinglot.v2.Vehicle.Vehicle;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class WeekdayPolicy implements IChargingStrategy {
    private double rate;

    public WeekdayPolicy(double rate) {
        this.rate = rate;
    }

    @Override
    public double getCost(Vehicle vehicle, LocalDateTime parkTime, LocalDateTime leaveTime) {
        return parkTime.until(leaveTime, ChronoUnit.MINUTES) * this.rate;
    }
}
