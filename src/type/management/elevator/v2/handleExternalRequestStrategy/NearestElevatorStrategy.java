package type.management.elevator.v2.handleExternalRequestStrategy;

import type.management.elevator.v2.elevator.Elevator;
import type.management.elevator.v2.request.Direction;
import type.management.elevator.v2.request.ExternalRequest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NearestElevatorStrategy implements IHandleExternalRequestStrategy {
    private static NearestElevatorStrategy nearestElevatorStrategy;

    private NearestElevatorStrategy(){}

    public static NearestElevatorStrategy getNearestElevatorStrategy() {
        if (nearestElevatorStrategy == null) {
            nearestElevatorStrategy = new NearestElevatorStrategy();
        }

        return nearestElevatorStrategy;
    }

    @Override
    public Elevator assignElevator(List<Elevator> elevators, ExternalRequest request) {
        for (Elevator elevator : elevators) {
            if (request.getDirection().equals(Direction.UP)) {
                if (elevator.getUp()[request.getFloor()]) {
                    return elevator;
                }
            } else if (request.getDirection().equals(Direction.DOWN)) {
                if (elevator.getDown()[request.getFloor()]) {
                    return elevator;
                }
            }
        }

        Collections.sort(elevators, Comparator.comparingInt(elevator ->
                Math.abs(elevator.getCurrentFloor() - request.getFloor())));

        return elevators.get(0);
    }
}
