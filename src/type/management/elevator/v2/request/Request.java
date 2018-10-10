package type.management.elevator.v2.request;

public abstract class Request {
    protected int floor;

    public Request(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

}
