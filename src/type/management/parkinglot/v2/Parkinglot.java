package type.management.parkinglot.v2;

import type.management.parkinglot.v2.Spot.LargeSpot;
import type.management.parkinglot.v2.Spot.SmallSpot;
import type.management.parkinglot.v2.Spot.Spot;
import type.management.parkinglot.v2.Spot.SpotSize;
import type.management.parkinglot.v2.Vehicle.Vehicle;
import type.management.parkinglot.v2.chargeingStrategy.IChargingStrategy;
import type.management.parkinglot.v2.chargeingStrategy.WeekdayPolicy;
import type.management.parkinglot.v2.exceptions.CarNotExistException;
import type.management.parkinglot.v2.exceptions.NoAvailableSpotException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parkinglot {
    List<Spot> spots;
    Map<Vehicle, Ticket> parkingInfo;
    IChargingStrategy policy;

    public Parkinglot(int smallSpots, int largeSpots) {
        this(smallSpots, largeSpots, new WeekdayPolicy(0.1));
    }

    public Parkinglot(int smallSpots, int largeSpots, IChargingStrategy policy) {
        this.spots = new ArrayList<>();
        this.parkingInfo = new HashMap<>();
        this.policy = policy;

        for (int i = 1; i <= smallSpots; i++) {
            this.spots.add(new SmallSpot(i));
        }

        for (int j = 1; j <= largeSpots; j++) {
            this.spots.add(new LargeSpot(j + smallSpots));
        }
    }

    public Ticket park(Vehicle vehicle, LocalDateTime time) {
        Ticket ticket = new Ticket(vehicle);
        List<Spot> spots;

        try {
            spots = this.findSpots(vehicle);
        } catch (NoAvailableSpotException e) {
            System.out.println("Parking lot is full!");
            return null;
        }

        for (Spot spot : spots) {
            spot.markAsUnavailable();
        }

        ticket.setParkTime(time);
        ticket.setSpot(spots);
        this.parkingInfo.put(vehicle, ticket);

        return ticket;
    }

    public Ticket leave(Vehicle vehicle, LocalDateTime time) {
        if (!this.parkingInfo.containsKey(vehicle)) {
            throw new CarNotExistException("Vehicle is not parked in this parkinglot");
        }

        Ticket ticket = this.parkingInfo.get(vehicle);
        ticket.setLeaveTime(time);
        List<Spot> spots = ticket.getSpot();

        ticket.setLeaveTime(time);
        ticket.setCost(this.policy);

        for (Spot spot : spots) {
            spot.markAsAvailable();
        }

        this.parkingInfo.remove(vehicle);
        return ticket;
    }

    public void showLeftSpots() {
        int smallSpots = 0, largetSpots = 0;
        for (Spot spot : spots) {
            if (spot.isAvailable()) {
                if (spot.getSpotSize().equals(SpotSize.SMALL)) {
                    smallSpots++;
                } else if (spot.getSpotSize().equals(SpotSize.LARGE)) {
                    largetSpots++;
                }
            }
        }

        if (smallSpots == 0) {
            System.out.println("No small spots is available!");
        } else {
            System.out.println("There are " + smallSpots + " small spots");
        }

        if (largetSpots == 0) {
            System.out.println("No large spots is available!");
        } else {
            System.out.println("There are " + largetSpots + " large spots");
        }
    }

    private List<Spot> findSpots(Vehicle vehicle) {
        List<Spot> spots = new ArrayList<>();
        int spotNeeded = vehicle.getNeededSpot();

        for (SpotSize spotSize : vehicle.availableSpots()) {
            int leftSpots = spotNeeded;

            for (Spot spot : this.spots) {
                if (spot.getSpotSize().equals(spotSize) && spot.isAvailable()) {
                    spots.add(spot);
                    leftSpots--;
                } else {
                    leftSpots = spotNeeded;
                    spots.clear();
                }

                if (leftSpots == 0) {
                    return spots;
                }
            }
        }

        throw new NoAvailableSpotException("Can't find spot for " + vehicle.getPlate());
    }
}
