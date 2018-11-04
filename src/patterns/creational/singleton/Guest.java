package patterns.creational.singleton;

public class Guest {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem1 = ElevatorSystem.getSingleton();
        ElevatorSystem elevatorSystem2 = ElevatorSystem.getSingleton();

        elevatorSystem1.move();
        elevatorSystem2.move();

        System.out.println(elevatorSystem1 == elevatorSystem2);
    }
}
