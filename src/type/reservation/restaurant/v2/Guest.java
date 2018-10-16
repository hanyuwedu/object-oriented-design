package type.reservation.restaurant.v2;

import type.reservation.restaurant.v2.module.Reservation;
import type.reservation.restaurant.v2.module.SearchCriteria;
import type.reservation.restaurant.v2.module.Availability;
import type.reservation.restaurant.v2.slot.Inventory;
import type.reservation.restaurant.v2.slot.TableSize;

import java.util.List;

public class Guest {
    public static void main(String[] args) {
        restaurantTest();
//        inventoryTest();
    }

    public static void restaurantTest() {
        Customer chris = new Customer("chris");
        Customer jeffery = new Customer("jeffery");
        Customer eric = new Customer("eric");
        Restaurant alinea = new Restaurant(17, 21, 1, 2, 3);

        alinea.getInventory().print();
        System.out.println();

        List<Availability> jeffereysearchResult = alinea.search(new SearchCriteria(19, 21, 5));
        System.out.println(jeffereysearchResult);
        Reservation jeffereyReservation = alinea.reserve(jeffery, jeffereysearchResult.get(0));
        System.out.println(jeffereyReservation);
        System.out.println();

        List<Availability> chrisAvailability = alinea.search(new SearchCriteria(18, 21, 2));
        System.out.println(chrisAvailability);
        System.out.println(alinea.reserve(chris, chrisAvailability.get(4)));
        System.out.println();

        SearchCriteria ericSearchCriteria = new SearchCriteria(19, 20, 3);
        List<Availability> ericAvailability = alinea.search(ericSearchCriteria);
        System.out.println(ericAvailability);
        alinea.cancel(jeffereyReservation);

        System.out.println(alinea.search(ericSearchCriteria));

    }

    public static void inventoryTest() {
        Inventory inventory = new Inventory(1, 3, 1, 2, 3);
        inventory.print();
        System.out.println();

        System.out.println(inventory.search(1, 2, TableSize.LARGE));
        System.out.println(inventory.search(1, 2, TableSize.SMALL));
        System.out.println(inventory.search(1, 2, TableSize.MID));
        System.out.println();

        System.out.println(inventory.searchRange(1, 3, 5));
        System.out.println(inventory.searchRange(1, 2, 3));
        System.out.println(inventory.searchRange(2, 4, 2));
        System.out.println();

        inventory.decreaseSlot(1, 2, TableSize.MID);
        inventory.decreaseSlot(1, 2, TableSize.MID);
        inventory.print();

        /// Should Throw exception
//        inventory.decreaseSlot(1, 2, TableSize.MID);

        /// Should only return large tables
        System.out.println(inventory.searchRange(1, 2, 3));

        inventory.increaseSlot(1, 2, TableSize.MID);
        /// Should return large and mid tables
        System.out.println(inventory.searchRange(1, 2, 3));
    }
}
