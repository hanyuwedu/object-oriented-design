package patterns.creational.singleton;

public class ElevatorSystem {
    private static ElevatorSystem elevatorSystem;   /// need to be static

    private ElevatorSystem() { }    /// Privatize constructor

    public static ElevatorSystem getSingleton() {
        if (elevatorSystem == null) {
            elevatorSystem = new ElevatorSystem();
        }

        return elevatorSystem;
    }

    public void move() {
        System.out.println("Let's go!");
    }
}
