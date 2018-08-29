package type.management.parkinglot;

import java.time.LocalDateTime;

public class Guest {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2, 3);

        Vehicle camery = new CompactVehicle("camery");
        Vehicle rabbit = new CompactVehicle("rabbit");
        Vehicle corolla = new CompactVehicle("corolla");
        Vehicle prius = new CompactVehicle("prius");

        Vehicle cla = new SUV("cla");
        Vehicle rogue = new SUV("rogue");

        Vehicle bus = new Bus("SchoolBus");

        parkingLot.showAvailableSpot();

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

        parkingLot.park(cla, time1);
        parkingLot.showAvailableSpot();

        parkingLot.park(bus, time2);
        parkingLot.showAvailableSpot();

        parkingLot.park(camery, time3);
        parkingLot.showAvailableSpot();

        parkingLot.leave(camery, time4);
        parkingLot.showAvailableSpot();

        //  No available spot exception
//        parkingLot.park(rogue, time5);
//        parkingLot.showAvailableSpot();

        // No such car exception
//        parkingLot.leave(rogue, time6);

        parkingLot.leave(cla, time5);
        parkingLot.showAvailableSpot();

        parkingLot.park(rabbit, time6);
        parkingLot.park(corolla, time7);
        parkingLot.showAvailableSpot();

        /// Park compact on full size spot
        parkingLot.park(prius, time9);
        parkingLot.showAvailableSpot();
    }
}
