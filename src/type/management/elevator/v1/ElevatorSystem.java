package type.management.elevator.v1;

import type.management.elevator.v1.exceptions.InvalidRequestException;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    List<Elevator> elevatorList;
    IStrategy strategy;

    public ElevatorSystem(Elevator... elevators) {
        this.elevatorList = new ArrayList();
        for (Elevator elevator : elevators) {
            elevatorList.add(elevator);
        }

        this.strategy = new LeastBusyStrategy();
    }

    public void handleExternalRequest(ExternalRequest externalRequest) {
        if (externalRequest.getLevel() > 10) {
            throw new InvalidRequestException("Request Level is out of bound!");
        }

        Elevator selectElevator = this.strategy.selectBestElevator(this.elevatorList, externalRequest);
        selectElevator.handleExternalRequest(externalRequest);
    }
}
