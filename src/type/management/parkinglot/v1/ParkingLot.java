package type.management.parkinglot.v1;

import type.management.parkinglot.v1.exception.CarNotExistException;
import type.management.parkinglot.v1.exception.NoAvailableSpotException;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private Map<Vehicle, Set<Spot>> parkingSpot;
    private Queue<CompactSpot> compactSpots;
    private Queue<FullSizeSpot> fullSizeSpots;
    private Map<Vehicle, Ticket> tickets;

    public ParkingLot(int compactSpots, int fullSizeSpots) {
        if (compactSpots <= 0 || compactSpots > 100 || fullSizeSpots <= 0 || fullSizeSpots > 100) {
            throw new IllegalArgumentException("Invalid parking spot count!");
        }

        this.compactSpots = new LinkedList<>();
        this.fullSizeSpots = new LinkedList<>();
        SpotFactory spotFactory = SpotFactory.getSingleton();

        for (int i = 1; i <= compactSpots; i++) {
            this.compactSpots.add((CompactSpot) spotFactory.getSpot(Type.COMPACT, 1, i));
        }

        for (int j = 1; j <= fullSizeSpots; j++) {
            this.fullSizeSpots.add((FullSizeSpot) spotFactory.getSpot(Type.SUV, 2, j));
        }

        this.tickets = new HashMap<>();
    }

    public void showAvailableSpot() {
        StringBuilder sb = new StringBuilder();
        sb.append("Left compact spots: ");
        sb.append(compactSpots.size());
        sb.append(", left full size spots: ");
        sb.append(fullSizeSpots.size());

        System.out.println(sb.toString());
    }

    public Ticket park(Vehicle vehicle, LocalDateTime park) {
        /// Any ways to condense it?

        Ticket ticket = new Ticket(vehicle);

        if (vehicle.getType().equals(Type.BUS)) {
            if (this.fullSizeSpots.isEmpty()) {
                throw new NoAvailableSpotException("No available full size spot for this car!");
            }

            for (FullSizeSpot spot : fullSizeSpots) {
                int current = spot.getRow();
                for (FullSizeSpot neighbor : fullSizeSpots) {
                    if (neighbor.getRow() == current + 1 || neighbor.getRow() == current - 1) {
                        Set<Spot> parkedSpot = new HashSet<>();
                        parkedSpot.add(neighbor);
                        parkedSpot.add(spot);

                        fullSizeSpots.remove(spot);
                        fullSizeSpots.remove(neighbor);

                        ticket.parkAt(parkedSpot, park);

                        this.tickets.put(vehicle, ticket);
                        return ticket;
                    }
                }
            }

            throw new NoAvailableSpotException("No available full size spot for this car!");
        } else if (vehicle.getType().equals(Type.SUV)) {
            if (this.fullSizeSpots.isEmpty()) {
                throw new NoAvailableSpotException("No available full size spot for this car!");
            }

            FullSizeSpot next = fullSizeSpots.remove();
            Set<Spot> parkedSpot = new HashSet<>();
            parkedSpot.add(next);

            ticket.parkAt(parkedSpot, park);

        } else if (vehicle.getType().equals(Type.COMPACT)) {
            if (this.fullSizeSpots.isEmpty() && this.compactSpots.isEmpty()) {
                throw new NoAvailableSpotException("No available spot for this car!");
            }

            Spot next = this.compactSpots.isEmpty() ? this.fullSizeSpots.remove() : this.compactSpots.remove();

            Set<Spot> parkedSpot = new HashSet<>();
            parkedSpot.add(next);

            ticket.parkAt(parkedSpot, park);
        }

        if (ticket.getSpots() == null) {
            throw new RuntimeException("Car was not successfully parked, please contact customer service!");
        }

        this.tickets.put(vehicle, ticket);
        return ticket;
    }

    public Ticket leave(Vehicle vehicle, LocalDateTime leave) {
        if (vehicle == null || !tickets.containsKey(vehicle)) {
            throw new CarNotExistException("This car is not in the parking lot, Please contact customer service!");
        }

        Ticket ticket = tickets.get(vehicle);
        Set<Spot> spots = ticket.leave(leave);

        if (vehicle.getType().equals(Type.COMPACT)) {
            Spot spot = spots.iterator().next();
            if (spot.getType().equals(Type.SUV)) {
                this.fullSizeSpots.add((FullSizeSpot) spot);
            } else {
                this.compactSpots.add((CompactSpot) spot);
            }
        } else if (vehicle.getType().equals(Type.SUV)){
            fullSizeSpots.add((FullSizeSpot) spots.iterator().next());
        } else {
            for (Spot spot : spots) {
                fullSizeSpots.add((FullSizeSpot) spot);
            }
        }

        this.tickets.remove(vehicle);
        System.out.println(ticket.ticketDetail());

        return ticket;
    }
}
