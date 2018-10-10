package type.management.elevator.v2.handleExternalRequestStrategy;


import type.management.elevator.v2.elevator.Elevator;
import type.management.elevator.v2.request.ExternalRequest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeastBusyStrategy implements IHandleExternalRequestStrategy {
    private static LeastBusyStrategy leastBusyStrategy;

    private LeastBusyStrategy(){}

    public static LeastBusyStrategy getNearestElevatorStrategy() {
        if (leastBusyStrategy == null) {
            leastBusyStrategy = new LeastBusyStrategy();
        }

        return leastBusyStrategy;
    }
    @Override
    public Elevator assignElevator(List<Elevator> elevators, ExternalRequest request) {
        Collections.sort(elevators, Comparator.comparingInt(Elevator::getRequestNumber).thenComparing(Elevator::getId));

        return elevators.get(0);
    }
}
