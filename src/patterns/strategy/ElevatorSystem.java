package patterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    List<Elevator> elevatorList;
    IStrategy strategy;

    public ElevatorSystem(Elevator... elevators) {
        this.elevatorList = new ArrayList<>();
        for (Elevator elevator : elevators) {
            elevatorList.add(elevator);
        }
    }

    public void handleRequest(Request request) {
        Elevator elevator = assignElevator(request);
        elevator.addRequest(request);
    }

    private Elevator assignElevator(Request request) {
        return this.strategy.assignElevator(elevatorList, request);
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }
}
