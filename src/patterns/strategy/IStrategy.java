package patterns.strategy;

import java.util.List;

public interface IStrategy {
    Elevator assignElevator(List<Elevator> elevatorList, Request request);
}
