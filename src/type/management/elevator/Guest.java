package type.management.elevator;

public class Guest {
    public static void main(String[] args) {
        Elevator elevator0 = new Elevator(0);
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);

        ElevatorSystem elevatorSystem = new ElevatorSystem(elevator0, elevator1, elevator2);

        /// Single Elevator operation
        elevator0.handleInternalRequest(new InternalRequest(2));
        elevator0.handleInternalRequest(new InternalRequest(3));
        elevator0.handleInternalRequest(new InternalRequest(5));
        elevator0.move();
        elevator0.move();
        elevator0.move();

        elevator0.handleInternalRequest(new InternalRequest(2));
        elevator0.handleInternalRequest(new InternalRequest(1));
        elevator0.move();
        elevator0.move();
        elevator0.move();   /// Should stop

        /// Multiple Elevator operation
        elevator0.handleInternalRequest(new InternalRequest(2));
        elevator0.handleInternalRequest(new InternalRequest(3));
        elevator0.handleInternalRequest(new InternalRequest(5));
        elevatorSystem.handleExternalRequest(new ExternalRequest(4, Status.DOWN)); /// To elevator1
        elevatorSystem.handleExternalRequest(new ExternalRequest(3, Status.UP)); /// To elevator2

        elevatorSystem.handleExternalRequest(new ExternalRequest(5, Status.UP)); /// To Elevator 1
        elevator1.handleInternalRequest(new InternalRequest(3));

        elevator0.move();

        elevator2.move();

        elevator1.move();
        elevator1.move();
        elevator1.move();
    }
}
