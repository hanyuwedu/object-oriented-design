package type.management.elevator.v1;

import java.util.List;

public interface IStrategy {
    Elevator selectBestElevator(List<Elevator> elevatorList, ExternalRequest request);
}
