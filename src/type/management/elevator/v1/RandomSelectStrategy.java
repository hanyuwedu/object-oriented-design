package type.management.elevator.v1;

import java.util.List;
import java.util.Random;

public class RandomSelectStrategy implements IStrategy {
    @Override
    public Elevator selectBestElevator(List<Elevator> elevatorList, ExternalRequest request) {
        Random random = new Random();
        int select = random.nextInt(elevatorList.size());
        return elevatorList.get(select);
    }
}
