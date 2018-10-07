package type.management.parkinglot.v2.chargeingStrategy;

import java.time.LocalDateTime;

public class WeekendPolicy implements IChargingStrategy {
    public WeekendPolicy() { }

    @Override
    public double getCost(LocalDateTime parkTime, LocalDateTime leaveTime) {
        return 0;
    }
}
