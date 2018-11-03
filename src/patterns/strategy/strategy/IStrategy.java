package patterns.strategy.strategy;

import patterns.strategy.elevator.Elevator;
import patterns.strategy.elevator.Request;

import java.util.List;

public interface IStrategy {
    Elevator assignElevator(List<Elevator> elevatorList, Request request);
}
