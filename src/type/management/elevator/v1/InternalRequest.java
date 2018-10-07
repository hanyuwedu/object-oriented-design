package type.management.elevator.v1;

public class InternalRequest extends Request {
    int level;

    public InternalRequest(int level) {
        this.level = level;
    }


    @Override
    public int getLevel() {
        return this.level;
    }
}
