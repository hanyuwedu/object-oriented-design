package type.management.elevator.v1;

public class ExternalRequest extends Request {
    int level;
    Status status;

    public ExternalRequest(int level, Status status) {
        this.level = level;
        this.status = status;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    public Status getStatus() {
        return this.status;
    }
}
