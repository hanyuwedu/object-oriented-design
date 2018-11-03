package patterns.behavioral.strategy.strategy;

import patterns.behavioral.strategy.elevator.Elevator;
import patterns.behavioral.strategy.elevator.Request;

import java.util.List;

public interface IStrategy {
    Elevator assignElevator(List<Elevator> elevatorList, Request request);
}
