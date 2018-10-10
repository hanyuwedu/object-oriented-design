package type.management.elevator.v2;

import type.management.elevator.v2.elevator.Elevator;
import type.management.elevator.v2.handleExternalRequestStrategy.NearestElevatorStrategy;
import type.management.elevator.v2.request.Direction;
import type.management.elevator.v2.request.ExternalRequest;
import type.management.elevator.v2.request.InternalRequest;

public class Guest {
    public static void main(String[] args) {
        //        singleElevatorTest1();
//        singleElevatorTest2();

//        multipleElevatorTest_leastBusyStrategy();
        multipleElevatorTest_nearestElevatorStrategy();
    }

    public static void singleElevatorTest1() {
        Elevator elevator0 = new Elevator(5, 0);

        elevator0.takeInternalRequest(new InternalRequest(2));
        elevator0.takeInternalRequest(new InternalRequest(3));
        elevator0.takeInternalRequest(new InternalRequest(5));
        elevator0.move();
        elevator0.move();
        elevator0.move();
        elevator0.move();
        elevator0.move();

        elevator0.takeInternalRequest(new InternalRequest(2));
        elevator0.move();
        elevator0.takeExternalRequest(new ExternalRequest(4, Direction.UP));
        elevator0.takeExternalRequest(new ExternalRequest(5, Direction.DOWN));

        /// exception
//        elevator0.takeInternalRequest(new InternalRequest(1));
        elevator0.move();
        elevator0.move();
        elevator0.printRequest();

    }

    public static void singleElevatorTest2() {
        Elevator elevator1 = new Elevator(5, 1);

        elevator1.takeInternalRequest(new InternalRequest(3));
        elevator1.move();
        elevator1.takeExternalRequest(new ExternalRequest(1, Direction.UP));
        elevator1.takeExternalRequest(new ExternalRequest(2, Direction.UP));
        elevator1.takeExternalRequest(new ExternalRequest(2, Direction.DOWN));
        elevator1.takeExternalRequest(new ExternalRequest(5, Direction.DOWN));
        elevator1.takeInternalRequest(new InternalRequest(4));

        elevator1.printRequest();

        elevator1.move();
        elevator1.move();
        elevator1.printRequest();
        System.out.println();

        elevator1.move();
        elevator1.printRequest();
        System.out.println();

        elevator1.move();
        elevator1.printRequest();
        System.out.println();

        elevator1.move();
        elevator1.printRequest();
        elevator1.move();

        System.out.println();
    }

    public static void multipleElevatorTest_leastBusyStrategy() {
        Elevator elevator2 = new Elevator(5, 2);
        Elevator elevator3 = new Elevator(5, 3);

        ElevatorSystem elevatorSystem = new ElevatorSystem(elevator2, elevator3);


        elevator2.takeInternalRequest(new InternalRequest(2));
        elevator2.takeInternalRequest(new InternalRequest(3));
        elevator3.takeInternalRequest(new InternalRequest(5));

        System.out.println("Elevator 2:");
        elevator2.printRequest();
        System.out.println("Elevator 3:");
        elevator3.printRequest();
        System.out.println();

        elevatorSystem.handleExternalRequest(new ExternalRequest(4, Direction.DOWN)); /// To elevator3
        elevatorSystem.handleExternalRequest(new ExternalRequest(4, Direction.UP)); /// To elevator2

        System.out.println("Elevator 2:");
        elevator2.printRequest();
        System.out.println("Elevator 3:");
        elevator3.printRequest();
        System.out.println();
    }

    public static void multipleElevatorTest_nearestElevatorStrategy() {
        Elevator elevator2 = new Elevator(5, 2);
        Elevator elevator3 = new Elevator(5, 3);

        ElevatorSystem elevatorSystem = new ElevatorSystem(NearestElevatorStrategy.getNearestElevatorStrategy(), elevator2, elevator3);


        elevator3.takeInternalRequest(new InternalRequest(2));
        elevator3.takeInternalRequest(new InternalRequest(3));
        elevator2.takeInternalRequest(new InternalRequest(4));

        System.out.println("Elevator 2:");
        elevator2.printRequest();
        System.out.println("Elevator 3:");
        elevator3.printRequest();
        System.out.println();

        elevatorSystem.handleExternalRequest(new ExternalRequest(3, Direction.UP)); /// To elevator3

        System.out.println("Elevator 2:");
        elevator2.printRequest();
        System.out.println("Elevator 3:");
        elevator3.printRequest();
        System.out.println();

        elevator3.move();
        elevator3.move();
        elevator2.move();

        elevator2.takeExternalRequest(new ExternalRequest(1, Direction.UP));
        elevator2.takeExternalRequest(new ExternalRequest(2, Direction.DOWN));

        System.out.println();

        System.out.println("Elevator 2:");
        elevator2.printRequest();
        System.out.println("Elevator 3:");
        elevator3.printRequest();
        System.out.println();

        elevatorSystem.handleExternalRequest(new ExternalRequest(5, Direction.DOWN));   /// To elevator 2
        System.out.println("Elevator 2:");
        elevator2.printRequest();
        System.out.println("Elevator 3:");
        elevator3.printRequest();
        System.out.println();
    }
}
