package type.management.elevator.v2.elevator;

import type.management.elevator.v2.exceptions.InvalidRequestException;
import type.management.elevator.v2.request.Direction;
import type.management.elevator.v2.request.ExternalRequest;
import type.management.elevator.v2.request.InternalRequest;

import java.util.Arrays;

public class Elevator {
    private static final int FLOOR = 10;

    private boolean[] up, down;
    private int id;
    private Status status;
    private int currentFloor;

    public Elevator(int id) {
        this(FLOOR, id);
    }

    public Elevator(int floor, int id) {
        this.up = new boolean[floor + 1];
        this.down = new boolean[floor + 1];
        this.id = id;
        this.status = Status.IDLE;
        this.currentFloor = 1;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean[] getUp() {
        return up;
    }

    public boolean[] getDown() {
        return down;
    }

    /**
     * 移动到下一个站点，并且改变/打印状态
     *
     * 依次执行：
     * 同向同请求（顺），同向反请求（逆），反向反请求（顺），反向同请求（逆）
     *
     * 举例：
     * 电梯停在三楼，方向是向上，按照优先级执行：
     * 4,5的up request(从小到大)
     * 5,4,3,2,1的down request(从大到小)
     * 1,2的up request(从小到大)
     * 返回1楼，更新为IDLE
     *
     * IDLE按照UP情况执行
     */
    public void move() {
        if (this.status.equals(Status.DOWN)) {
            int next = this.getNext(this.currentFloor, 1, this.down);

            if (next != -1) {
                this.closeGate(next, this.down, Status.DOWN);
                return;
            } else {
                next = this.getNext(1, this.up.length - 1, this.up);
            }

            if (next != -1) {
                this.closeGate(next, this.up, Status.UP);
                return;
            } else {
                next = this.getNext(this.down.length - 1, this.currentFloor, this.down);
            }

            if (next != -1) {
                this.closeGate(next, this.down, Status.DOWN);
                return;
            } else {
                this.closeGate(1, this.down, Status.IDLE);
                return;
            }
        } else {
            int next = this.getNext(this.currentFloor, this.up.length - 1, this.up);

            if (next != -1) {
                this.closeGate(next, this.up, Status.UP);
                return;
            } else {
                next = this.getNext(this.down.length - 1, 1, this.down);
            }

            if (next != -1) {
                this.closeGate(next, this.down, Status.DOWN);
                return;
            } else {
                next = this.getNext(1, this.currentFloor, this.up);
            }

            if (next != -1) {
                this.closeGate(next, this.up, Status.UP);
                return;
            } else {
                this.closeGate(1, this.down, Status.IDLE);
                return;
            }
        }
    }


    /**
     * 根据要求寻找下一个停靠楼层。如果当前方向没有，则返回-1
     *
     * @param start 请求楼层集合的起始点
     * @param end 请求楼层集合的终点
     * @param request 请求楼层集合
     * @return 下一个停靠楼层，如果没有则返回-1
     */
    private int getNext(int start, int end, boolean[] request) {
        /**
         * 这里不同的情况实现不同的循环（结构）以及不同的赋值的写作方式，
         * 可以让赋值写在一个方法，然后循环写作另一个方法，由前者来invoke后者。
         */
        int inc = start < end ? 1 : -1;
        for (int i = start; i != end; i += inc) {
            if (request[i]) {
                return i;
            }
        }

        if (request[end]) {
            return end;
        } else {
            return -1;
        }
    }

    /**
     * 更改电梯状态
     *
     * @param floor 移动到的楼层
     * @param request 更改的请求列表
     * @param status 更改后的状态
     */
    private void closeGate(int floor, boolean[] request, Status status) {
        this.currentFloor = floor;
        request[floor] = false;
        this.status = status;

        System.out.println(this.toString());
    }

    /**
     * 将internal request放入列表，并且在异向请求时抛出异常
     * @param request input internal request
     */
    public void takeInternalRequest(InternalRequest request) {
        if (request.getFloor() > this.FLOOR || request.getFloor() <= 0) {
            throw new InvalidRequestException("Internal Request out of bound!");
        }

        if (this.status.equals(Status.UP) || this.status.equals(Status.IDLE)) {
            if (request.getFloor() <= this.currentFloor) {
                throw new InvalidRequestException("Invalid Internal Request! Elevator is moving up.");
            } else {
                this.up[request.getFloor()] = true;
            }
        }

        if (this.status.equals(Status.DOWN)) {
            if (request.getFloor() >= this.currentFloor) {
                throw new InvalidRequestException("Invalid Internal Request! Elevator is moving down.");
            } else {
                this.down[request.getFloor()] = true;
            }
        }
    }

    /**
     * external request放入列表
     * @param request input external request
     */
    public void takeExternalRequest(ExternalRequest request) {
        if (request.getDirection().equals(Direction.DOWN)) {
            this.down[request.getFloor()] = true;
        } else if (request.getDirection().equals(Direction.UP)) {
            this.up[request.getFloor()] = true;
        } else {
            throw new InvalidRequestException("Invalid External request!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Elevator " + this.id);
        sb.append(" is at floor " + this.currentFloor);
        if (this.status.equals(Status.IDLE)) {
            sb.append(". It is currently idle");
        } else {
            sb.append(". It is currently moving " + this.status.toString().toLowerCase());
        }

        return sb.toString();
    }

    /**
     * @return 所有请求的个数
     */
    public int getRequestNumber() {
        int requests = 0;
        for (boolean level : this.up) {
            if (level) {
                requests++;
            }
        }

        for (boolean level : this.down) {
            if (level) {
                requests++;
            }
        }

        return requests;
    }

    public void printRequest() {
        System.out.println("up: " + Arrays.toString(this.up));
        System.out.println("down: " + Arrays.toString(this.down));

    }
}
