package type.management.parkinglot.v2.chargeingStrategy;

import java.time.LocalDateTime;

public interface IChargingStrategy {
    double getCost(LocalDateTime parkTime, LocalDateTime leaveTime);
}
