package type.management.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

public class Ticket {
    Vehicle vehicle;
    Set<Spot> spots;

    LocalDateTime park, leave;

    public Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void parkAt(Set<Spot> spots, LocalDateTime park) {
        this.spots = spots;
        this.park = park;
    }

    public Set<Spot> leave(LocalDateTime leave) {
        this.leave = leave;
        return this.spots;
    }

    public String ticketDetail() {
        StringBuilder detail = new StringBuilder();
        detail.append("Car ");
        detail.append(this.vehicle.getPlate());
        detail.append(" has been parked from ");
        detail.append(this.park);
        detail.append(" to ");
        detail.append(this.leave);
        detail.append(". Last for ");
        detail.append(Duration.between(park, leave).toMinutes());
        detail.append(" minutes.");

        return detail.toString();
    }

    public Set<Spot> getSpots() {
        return this.spots;
    }
}
