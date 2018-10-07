package type.management.elevator.v1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeastBusyStrategy implements IStrategy {

    @Override
    public Elevator selectBestElevator(List<Elevator> elevatorList, ExternalRequest request) {
        Collections.sort(elevatorList,
                Comparator.comparingInt(Elevator::getRequestNumber).thenComparing(Elevator::getNum));
        return elevatorList.get(0);
    }
}
