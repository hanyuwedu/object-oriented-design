package patterns.creational.singleton;

public class ElevatorSystem {
    private static ElevatorSystem _elevatorSystem;   /// need to be static

    private ElevatorSystem() { }    /// Privatize constructor

    public static ElevatorSystem getSingleton() {
        if (_elevatorSystem == null) {
            _elevatorSystem = new ElevatorSystem();
        }

        return _elevatorSystem;
    }

    public void move() {
        System.out.println("Let's go!");
    }
}
