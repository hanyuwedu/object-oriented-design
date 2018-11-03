package patterns.behavioral.strategy.elevator;

public class Request {
    int floor;
    Status direction;

    public Request(int floor, Status direction) {
        this.floor = floor;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "[To: " + floor + ", Direction: " + direction + "]";
    }
}
