package jiuzhang.elevatorSystemOODesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    enum Direction {
        UP, DOWN
    }

    enum Status {
        UP, DOWN, IDLE
    }

    class Request {
        private int level;

        public Request(int l)
        {
            level = l;
        }

        public int getLevel()
        {
            return level;
        }
    }

    class ElevatorButton {
        private int level;
        private Elevator elevator;

        public ElevatorButton(int level, Elevator e)
        {
            this.level = level;
            this.elevator = e;
        }

        public void pressButton()
        {
            InternalRequest request = new InternalRequest(level);
            elevator.handleInternalRequest(request);
        }
    }

    class ExternalRequest extends Request{

        private Direction direction;

        public ExternalRequest(int l, Direction d) {
            super(l);
            // TODO Auto-generated constructor stub
            this.direction = d;
        }

        public ExternalRequest(int l, String direction) {
            this(l, Direction.valueOf(direction));
        }

        public Direction getDirection()
        {
            return direction;
        }
    }

    class InternalRequest extends Request{

        public InternalRequest(int l) {
            super(l);
            // TODO Auto-generated constructor stub
        }
    }

    public class Elevator {

        private List<ElevatorButton> buttons;

        private List<Boolean> upStops;
        private List<Boolean> downStops;

        private int currLevel;
        private Status status;

        public Elevator(int n)
        {
            buttons = new ArrayList<ElevatorButton>();
            upStops = new ArrayList<Boolean>();
            downStops = new ArrayList<Boolean>();
            currLevel = 0;
            status = Status.IDLE;

            for(int i = 0; i < n; i++)
            {
                upStops.add(false);
                downStops.add(false);
            }
        }

        public void insertButton(ElevatorButton eb)
        {
            buttons.add(eb);
        }

        public void handleExternalRequest(ExternalRequest r)
        {
            if (r.getLevel() > this.upStops.size()) {
                throw new InvalidRequestException("Level is out of bound!");
            }

            if (r.getDirection().equals(Direction.UP)) {
                upStops.set(r.getLevel() - 1, true);
            } else if (r.getDirection().equals(Direction.DOWN)) {
                downStops.set(r.getLevel() - 1, true);
            }
        }

        public void handleInternalRequest(InternalRequest r)
        {
            if (r.getLevel() > this.currLevel) {
                if (this.status.equals(Status.DOWN)) {
                    throw new InvalidRequestException("Elevator is going down");
                }

                this.upStops.set(r.getLevel() - 1, true);
                if (this.status.equals(Status.IDLE)) {
                    this.status = Status.UP;
                }
            } else if (r.getLevel() < this.currLevel) {
                if (this.status.equals(Status.UP)) {
                    throw new InvalidRequestException("Elevator is going up");
                }

                this.downStops.set(r.getLevel() - 1, true);
                if (this.status.equals(Status.IDLE)) {
                    this.status = Status.DOWN;
                }
            } else {
                throw new InvalidRequestException("Elevator is already at this floor!");
            }
        }

        public void openGate() throws Exception
        {
            boolean fillRequest = false;
            if (this.status.equals(Status.UP)) {
                for (int i = currLevel + 1; i <= upStops.size(); i++) {
                    if (this.upStops.get(i - 1)) {
                        this.currLevel = i;
                        this.upStops.set(i - 1, false);
                        fillRequest = true;
                    }
                }

                if (!fillRequest) {
                    for (int i = 1; i <= currLevel - 1; i++) {
                        if (this.upStops.get(i - 1)) {
                            this.currLevel = i;
                            this.upStops.set(i - 1, false);
                            fillRequest = true;
                        }
                    }
                }
            } else if (this.status.equals(Status.DOWN)) {
                for (int i = currLevel + 1; i <= downStops.size(); i++) {
                    if (this.downStops.get(i - 1)) {
                        this.currLevel = i;
                        this.downStops.set(i - 1, true);
                    }
                }

                if (!fillRequest) {
                    for (int i = 1; i <= currLevel - 1; i++) {
                        if (this.downStops.get(i - 1)) {
                            this.currLevel = i;
                            this.downStops.set(i - 1, false);
                            fillRequest = true;
                        }
                    }
                }
            } else {
                throw new InvalidRequestException("Elevator has not request");
            }
        }

        public void closeGate()
        {
            if (this.noRequests(this.upStops) && this.noRequests(this.downStops)) {
                this.status = Status.IDLE;
            }

            if (this.status.equals(Status.UP)) {
                if (this.noRequests(this.upStops)) {
                    this.status = Status.DOWN;
                }
            } else if (this.status.equals(Status.DOWN)) {
                if (this.noRequests(this.downStops)) {
                    this.status = Status.UP;
                }
            }
        }

        private boolean noRequests(List<Boolean> stops)
        {
            for(int i = 0; i < stops.size(); i++)
            {
                if(stops.get(i))
                {
                    return false;
                }
            }
            return true;
        }

        public String elevatorStatusDescription()
        {
            String description = "Currently elevator status is : " + status
                    + ".\nCurrent level is at: " + (currLevel + 1)
                    + ".\nup stop list looks like: " + upStops
                    + ".\ndown stop list looks like:  " + downStops
                    + ".\n*****************************************\n";
            return description;
        }

        public class InvalidRequestException extends RuntimeException {
            public InvalidRequestException(String message) {
                super(message);
            }
        }
    }
}
