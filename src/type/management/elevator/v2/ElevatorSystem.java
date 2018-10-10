package type.management.elevator.v2;


import type.management.elevator.v2.elevator.Elevator;
import type.management.elevator.v2.handleExternalRequestStrategy.IHandleExternalRequestStrategy;
import type.management.elevator.v2.handleExternalRequestStrategy.LeastBusyStrategy;
import type.management.elevator.v2.request.ExternalRequest;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private IHandleExternalRequestStrategy strategy;

    public ElevatorSystem(Elevator... elevatorArray) {
        this(LeastBusyStrategy.getNearestElevatorStrategy(), elevatorArray);
    }

    public ElevatorSystem(IHandleExternalRequestStrategy strategy, Elevator... elevatorArray) {
        this.strategy = strategy;
        this.elevators = new ArrayList<>();
        for (Elevator elevator : elevatorArray) {
            elevators.add(elevator);
        }
    }

    /**
     * 按照指定算法来为external request安排电梯
     *
     * @param request input external request
     */
    public void handleExternalRequest(ExternalRequest request) {
        Elevator elevator = this.strategy.assignElevator(this.elevators, request);
        elevator.takeExternalRequest(request);
    }
}
