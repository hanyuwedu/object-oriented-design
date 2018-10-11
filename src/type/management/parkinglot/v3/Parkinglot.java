package type.management.parkinglot.v3;

import type.management.parkinglot.v3.chargingstrategy.IChargingStrategy;
import type.management.parkinglot.v3.chargingstrategy.WeekdayPolicy;
import type.management.parkinglot.v3.exceptions.CarNotExistException;
import type.management.parkinglot.v3.exceptions.NoAvailableSpotException;
import type.management.parkinglot.v3.spot.LargeSpot;
import type.management.parkinglot.v3.spot.SmallSpot;
import type.management.parkinglot.v3.spot.Spot;
import type.management.parkinglot.v3.spot.SpotSize;
import type.management.parkinglot.v3.ticket.Ticket;
import type.management.parkinglot.v3.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parkinglot {
    private List<Spot> spots;
    private IChargingStrategy policy;

    /**
     * 默认为工作日收费标准
     *
     * @param smallSpots 停车场的小号停车位
     * @param largeSpots 停车场的大号停车位
     */
    public Parkinglot(int smallSpots, int largeSpots) {
        this(smallSpots, largeSpots, new WeekdayPolicy(0.1));
    }

    /**
     * @param smallSpots 停车场的小号停车位
     * @param largeSpots
     * @param policy 停车场的收费标准
     */
    public Parkinglot(int smallSpots, int largeSpots, IChargingStrategy policy) {
        this.spots = new ArrayList<>();
        this.policy = policy;

        for (int i = 1; i <= smallSpots; i++) {
            this.spots.add(new SmallSpot(i));
        }

        for (int j = 1; j <= largeSpots; j++) {
            this.spots.add(new LargeSpot(j + smallSpots));
        }
    }


    /**
     * 为目标车找到车位，并且返回ticket
     * 若没有合适车位，会抛出NoAvailableSpotException，并且返回null
     *
     * @param vehicle 目标车
     * @param time 停车时间
     * @return 停车保留的ticket
     */
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

        return ticket;
    }



    /**
     * 目标车离开停车场，并且释放相应停车位
     *
     * @param ticket 目标车的车票
     * @param time 离开时间
     * @return 离开更新后的ticket
     */
    public Ticket leave(Ticket ticket, LocalDateTime time) {
        if (ticket == null || ticket.getVehicle() == null) {
            throw new CarNotExistException("Vehicle is not parked in this parkinglot");
        }

        ticket.setLeaveTime(time);
        List<Spot> spots = ticket.getSpot();

        ticket.setLeaveTime(time);
        ticket.setCost(this.policy);

        for (Spot spot : spots) {
            spot.markAsAvailable();
        }

        return ticket;
    }

    /**
     * 显示当前所剩车位
     */
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

    /**
     * 显示停车场车位示意图
     */
    public void showSpots() {
        System.out.println(this.spots.toString());
    }

    /**
     * 根据车的大小找到合适的停车位
     *
     * @param vehicle 目标车
     * @return 目标停车位
     */
    private List<Spot> findSpots(Vehicle vehicle) {
        List<Spot> spots = new ArrayList<>();
        int spotNeeded = vehicle.getNeededSpot();

        /**
         * vehicle.availableSpots()会储存一个有序的（从小到大）的停车位列表，
         * 对于其中的每种车位，需要找到连续的车位
         * 过程是：记录所需要的车位，如果下一个车位符合条件则继续放入结果集合，如果不符合条件则清空集合并重新计数。
         */
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
