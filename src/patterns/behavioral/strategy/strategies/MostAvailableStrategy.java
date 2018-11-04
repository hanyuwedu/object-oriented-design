package patterns.behavioral.strategy.strategies;

import patterns.behavioral.strategy.elevator.Elevator;
import patterns.behavioral.strategy.elevator.Request;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MostAvailableStrategy implements IStrategy {
    @Override
    public Elevator assignElevator(List<Elevator> elevatorList, Request request) {
        Collections.sort(elevatorList, Comparator.comparingInt(elevator -> elevator.getRequestList().size()));
        return elevatorList.get(0);
    }
}
