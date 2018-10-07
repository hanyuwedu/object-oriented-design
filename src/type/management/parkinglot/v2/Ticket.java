package type.management.parkinglot.v2;

import type.management.parkinglot.v2.Spot.Spot;
import type.management.parkinglot.v2.Vehicle.Vehicle;
import type.management.parkinglot.v2.chargeingStrategy.IChargingStrategy;
import type.management.parkinglot.v2.exceptions.CarNotExistException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Ticket {
    private Vehicle vehicle;
    private List<Spot> spot;
    private LocalDateTime parkTime, leaveTime;
    private Double cost;

    public Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkTime(LocalDateTime time) {
        this.parkTime = time;
    }

    public void setLeaveTime(LocalDateTime time) {
        this.leaveTime = time;
    }

    public void setSpot(List<Spot> spot) {
        this.spot = spot;
    }

    public void setCost(IChargingStrategy strategy) {
        if (parkTime == null || leaveTime == null) {
            throw new CarNotExistException("This car has not yet leave!");
        }
        this.cost = strategy.getCost(parkTime, leaveTime);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<Spot> getSpot() {
        return spot;
    }

    public LocalDateTime getLeaveTime() {
        return leaveTime;
    }

    public LocalDateTime getParkTime() {
        return parkTime;
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car: " + this.vehicle.getPlate());
        sb.append(". Park time: " + this.parkTime);

        if (this.leaveTime != null) {
            sb.append(". Leave time: " + this.leaveTime);
            sb.append(". Has been parked for: " + parkTime.until(leaveTime, ChronoUnit.HOURS) + " hours");
        }

        if (this.cost != null) {
            sb.append(". Cost: " + this.cost);
        }

        sb.append(".");

        return sb.toString();
    }
}
