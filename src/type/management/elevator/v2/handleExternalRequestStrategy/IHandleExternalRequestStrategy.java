package type.management.elevator.v2.handleExternalRequestStrategy;

import type.management.elevator.v2.elevator.Elevator;
import type.management.elevator.v2.request.ExternalRequest;

import java.util.List;

public interface IHandleExternalRequestStrategy {
    /**
     * 为外部请求返回对应的电梯
     *
     * @param elevators 所有的电梯
     * @param request input external request
     * @return 指定的电梯
     */
    Elevator assignElevator(List<Elevator> elevators, ExternalRequest request);
}
