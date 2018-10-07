package type.management.parkinglot.v2;

import type.management.parkinglot.v2.Vehicle.Bus;
import type.management.parkinglot.v2.Vehicle.Car;
import type.management.parkinglot.v2.Vehicle.SUV;
import type.management.parkinglot.v2.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Guest {
    public static void main(String[] args) {
        Parkinglot parkingLot = new Parkinglot(2, 4);

        Vehicle camery = new Car("camery");
        Vehicle rabbit = new Car("rabbit");
        Vehicle corolla = new Car("corolla");
        Vehicle prius = new Car("prius");

        Vehicle cla = new SUV("cla");
        Vehicle rogue = new SUV("rogue");

        Vehicle bus = new Bus("SchoolBus");

        parkingLot.showLeftSpots();
        System.out.println();

        LocalDateTime time1 = LocalDateTime.of(2018, 8, 28, 1, 1, 1);
        LocalDateTime time2 = LocalDateTime.of(2018, 8, 28, 2, 2, 2);
        LocalDateTime time3 = LocalDateTime.of(2018, 8, 28, 3, 3, 3);
        LocalDateTime time4 = LocalDateTime.of(2018, 8, 28, 4, 4, 4);
        LocalDateTime time5 = LocalDateTime.of(2018, 8, 28, 5, 5, 5);
        LocalDateTime time6 = LocalDateTime.of(2018, 8, 28, 6, 6, 6);
        LocalDateTime time7 = LocalDateTime.of(2018, 8, 28, 7, 7, 7);
        LocalDateTime time8 = LocalDateTime.of(2018, 8, 28, 8, 8, 8);
        LocalDateTime time9 = LocalDateTime.of(2018, 8, 28, 9, 9, 9);
        LocalDateTime time10 = LocalDateTime.of(2018, 8, 28, 10, 10, 10);
        LocalDateTime time11 = LocalDateTime.of(2018, 8, 28, 11, 11, 11);

        Ticket ticket1 = parkingLot.park(cla, time1);
        System.out.println(ticket1);
        parkingLot.showLeftSpots();
        System.out.println();

        parkingLot.park(bus, time2);
        parkingLot.showLeftSpots();
        System.out.println();

        Ticket ticket2 = parkingLot.park(camery, time3);
        System.out.println(ticket2);
        parkingLot.showLeftSpots();
        System.out.println();

        ticket2 = parkingLot.leave(camery, time4);
        System.out.println(ticket2);
        parkingLot.showLeftSpots();

        //  No available spot exception
        parkingLot.park(rogue, time5);
        parkingLot.showLeftSpots();
        System.out.println();

        // No such car exception
//        parkingLot.leave(rogue, time6);

        ticket1 = parkingLot.leave(cla, time5);
        System.out.println(ticket1);
        parkingLot.showLeftSpots();
        System.out.println();

        parkingLot.park(rabbit, time6);
        parkingLot.park(corolla, time7);
        parkingLot.showLeftSpots();
        System.out.println();

        /// Park compact on full size spot
        parkingLot.park(prius, time9);
        parkingLot.showLeftSpots();
    }
}
