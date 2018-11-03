package patterns.behavioral.strategy.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    List<Request> requestList;
    Status status;
    int currentFloor;

    public Elevator() {
        this.requestList = new ArrayList<>();
        this.status = Status.IDLE;
        this.currentFloor = 1;
    }

    public void addRequest(Request request) {
        this.requestList.add(request);
    }

    public List<Request> getRequestList() {
        return this.requestList;
    }
}
