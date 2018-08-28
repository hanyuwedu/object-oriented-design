package type.management.elevator;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {
    private int num;
    private Queue<Request> upwardRequest;
    private Queue<Request> downwardRequest;
    private int currentFloor;
    private Status status;

    public Elevator(int num) {
        this.num = num;
        this.upwardRequest = new PriorityQueue<>(Comparator.comparingInt(Request::getLevel));
        this.downwardRequest = new PriorityQueue<>((request1, request2) ->
                request2.getLevel() - request1.getLevel());
        this.currentFloor = 1;
        this.status = Status.IDLE;
    }

    public void handleInternalRequest(InternalRequest request) {
        if ((this.status.equals(Status.DOWN) && request.getLevel() > this.currentFloor) ||
                (this.status.equals(Status.UP) && request.getLevel() < this.currentFloor) ||
                request.getLevel() == this.currentFloor) {
            throw new IllegalReceiveException("Invalid request!");
        }

        if (this.status.equals(Status.UP)) {
            upwardRequest.add(request);
        } else if (this.status.equals(Status.DOWN)) {
            downwardRequest.add(request);
        } else {
            if (request.getLevel() > this.currentFloor) {
                upwardRequest.add(request);
            } else {
                downwardRequest.add(request);
            }
        }
    }

    public void handleExternalRequest(ExternalRequest request) {
        /*
         * Here external request should be called from user interface,
         * but should be called from Elevator System, any proper way to handle this situation?
         */
        if (request.getStatus().equals(Status.DOWN)) {
            downwardRequest.add(request);
        } else {
            upwardRequest.add(request);
        }
    }

    public void move() {
        if (this.status.equals(Status.UP)) {
            if (!this.upwardRequest.isEmpty()) {
                this.move(upwardRequest.remove());
            } else if (!this.downwardRequest.isEmpty()) {
                this.move(downwardRequest.remove());
            } else {
                setToIdle();
            }
        } else if (this.status.equals(Status.DOWN)) {
            if (!this.downwardRequest.isEmpty()) {
                this.move(downwardRequest.remove());
            } else if (!this.upwardRequest.isEmpty()) {
                this.move(upwardRequest.remove());
            } else {
                setToIdle();
            }
        } else {
            Request next = null;
            if (!this.upwardRequest.isEmpty()) {
                next = upwardRequest.remove();
            } else if (!this.downwardRequest.isEmpty()) {
                next = downwardRequest.remove();
            }

            if (next == null) {
                this.setToIdle();
            } else {
                this.move(next);
            }
        }

        if (this.upwardRequest.isEmpty() && this.downwardRequest.isEmpty()) {
            this.status = Status.IDLE;
        }
    }

    private void move(Request next) {
        System.out.println("Elevator" + this.num + " is moving from " + this.currentFloor + " to " + next.getLevel());
        this.currentFloor = next.getLevel();
    }

    private void setToIdle() {
        System.out.println("No more request is on the queue. Elevator is stopping");
        this.status = Status.IDLE;
    }

    public int getNum() {
        return this.num;
    }

    public int getRequestNumber() {
        return upwardRequest.size() + downwardRequest.size();
    }
}
