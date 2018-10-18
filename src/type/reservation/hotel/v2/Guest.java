package type.reservation.hotel.v2;

import type.reservation.hotel.v2.model.Availability;
import type.reservation.hotel.v2.model.Reservation;
import type.reservation.hotel.v2.model.SearchCriteria;
import type.reservation.hotel.v2.module.HotelConfigModule;
import type.reservation.hotel.v2.room.Inventory;
import type.reservation.hotel.v2.room.RoomType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guest {
    public static void main(String[] args) {
//        inventoryTest();
        hotelTest();
    }

    public static void inventoryTest() {
        Inventory inventory = new Inventory();
        HotelConfigModule.initializeInventory(inventory);

        inventory.printPrices();
        inventory.printRoom();

        System.out.println(inventory.getPrice(date().get("d3"), RoomType.EXECUTIVE_SUITE));
        inventory.setPrice(date().get("d3"), RoomType.EXECUTIVE_SUITE, 420.0);
        System.out.println(inventory.getPrice(date().get("d3"), RoomType.EXECUTIVE_SUITE));
        System.out.println();

        List<Availability> availabilities = inventory.search(date().get("d2"), date().get("d4"), 2);
        System.out.println(availabilities);

        inventory.decreaseRoom(date().get("d2"), date().get("d4"), RoomType.EXECUTIVE_SUITE);

        System.out.println(inventory.isAvailable(date().get("d3"), RoomType.EXECUTIVE_SUITE));

        /// Throw exception
        //  inventory.decreaseRoom(date().get("d1"), date().get("d2"), RoomType.EXECUTIVE_SUITE);

        inventory.increaseRoom(date().get("d2"), date().get("d4"), RoomType.EXECUTIVE_SUITE);
        System.out.println(inventory.isAvailable(date().get("d3"), RoomType.EXECUTIVE_SUITE));
    }

    public static void hotelTest() {
        Customer chris = new Customer("chris");
        Customer jeffery = new Customer("jeffery");
        Customer eric = new Customer("eric");

        Hotel hilton = new Hotel();
        hilton.setPrice(date().get("d3"), RoomType.EXECUTIVE_SUITE, 420.0);

        List<Availability> chrisAvailabilities = hilton.search(new SearchCriteria(date().get("d2"), date().get("d4"), 3));
        System.out.println(chrisAvailabilities);
        Reservation chrisReservation = hilton.reserve(chris, chrisAvailabilities.get(0));
        System.out.println();

        List<Availability> jeffAvailabilities = hilton.search(new SearchCriteria(date().get("d3"), date().get("d5"), 2));
        System.out.println(jeffAvailabilities);
        Reservation jeffReservation = hilton.reserve(jeffery, jeffAvailabilities.get(1));
        System.out.println();

        hilton.getInventory().printRoom();
        System.out.println();

        System.out.println(hilton.getInventory().isAvailable(date().get("d3"), RoomType.EXECUTIVE_SUITE));
        hilton.cancel(chrisReservation);
        System.out.println(hilton.getInventory().isAvailable(date().get("d3"), RoomType.EXECUTIVE_SUITE));
    }

    private static Map<String, LocalDate> date() {
        Map<String, LocalDate> dateMap = new HashMap<>();

        for (LocalDate date = LocalDate.of(2018, 11, 1);
             !date.isAfter(LocalDate.of(2018, 11, 7));
             date = date.plusDays(1)) {
            int i = date.getDayOfMonth();
            dateMap.put("d" + i, date);
        }

        return dateMap;
    }
}
