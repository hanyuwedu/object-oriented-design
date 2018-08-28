package type.management.elevator;

import java.util.List;

public interface IStrategy {
    Elevator selectBestElevator(List<Elevator> elevatorList, ExternalRequest request);
}
