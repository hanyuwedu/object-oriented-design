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

    /**
     * 为Ticket设置停车时间
     * @param time 停车时间
     */
    public void setParkTime(LocalDateTime time) {
        this.parkTime = time;
    }

    /**
     * 为Ticket设置离开时间
     * @param time 离开时间
     */
    public void setLeaveTime(LocalDateTime time) {
        this.leaveTime = time;
    }

    /**
     * 为Ticket设置spot
     * @param spot 停车位置
     */
    public void setSpot(List<Spot> spot) {
        this.spot = spot;
    }

    /**
     * 根据不同的停车场收费标准设置（返回）收费
     * 使用strategy design pattern
     *
     * @param strategy 所使用的收费标准
     */
    public void setCost(IChargingStrategy strategy) {
        if (parkTime == null || leaveTime == null) {
            throw new CarNotExistException("This car has not yet leave!");
        }
        this.cost = strategy.getCost(this.vehicle, parkTime, leaveTime);
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
