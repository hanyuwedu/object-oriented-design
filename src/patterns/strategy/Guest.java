package patterns.strategy;

import patterns.strategy.*;

public class Guest {
    public static void main(String[] args) {
        Elevator elevator1 = new Elevator();
        Elevator elevator2 = new Elevator();

        ElevatorSystem elevatorSystem = new ElevatorSystem(elevator1, elevator2);
        StrategyFactory factory = StrategyFactory.getSingleton();


//        elevatorSystem.setStrategy(factory.getStrategy(MostAvailableStrategy.class));
        elevatorSystem.setStrategy(factory.getStrategy(RandomStrategy.class));
        System.out.println(elevatorSystem.strategy.toString());

        elevatorSystem.handleRequest(new Request(3, Status.UP));
        elevatorSystem.handleRequest(new Request(5, Status.DOWN));
        elevatorSystem.handleRequest(new Request(10, Status.DOWN));
        elevatorSystem.handleRequest(new Request(15, Status.DOWN));
        elevatorSystem.handleRequest(new Request(20, Status.DOWN));
        elevatorSystem.handleRequest(new Request(6, Status.DOWN));

        System.out.println(elevator1.getRequestList());
        System.out.println(elevator2.getRequestList());
    }
}
