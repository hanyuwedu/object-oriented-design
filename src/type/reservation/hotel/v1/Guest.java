package type.reservation.hotel.v1;

import java.util.List;

public class Guest {
    public static void main(String[] args) {
        Hotel ritzCarlton = new Hotel(3, 2);
        System.out.println(ritzCarlton.leftStays.toString());

        Hotel hilton = new Hotel(2, 1);
        Customer chris = new Customer("chris", hilton);
        Customer jeffery = new Customer("jeffery", hilton);
        Customer eric = new Customer("eric", hilton);
        Customer victor = new Customer("victor", hilton);

        System.out.println(hilton.leftStays.toString());

        List<List<Stay>> chrisSearchResult = chris.search(new SearchCriteria(1, 15, 17));
        System.out.println(chrisSearchResult.toString());
        chris.select(chrisSearchResult, 0);
        System.out.println(hilton.leftStays.toString());
        System.out.println(hilton.existReservations.toString());
        System.out.println();

        List<List<Stay>> jeffereySearchResult = jeffery.search(new SearchCriteria(2, 13, 16));
        System.out.println(jeffereySearchResult.toString());
        jeffery.select(jeffereySearchResult, 0);
        System.out.println(hilton.leftStays.toString());
        System.out.println(hilton.existReservations.toString());
        System.out.println();

        /// Should throw a NotAvailableRoomException
//        List<List<Stay>> ericSearchResult = eric.search(new SearchCriteria(2, 12 ,15));
        List<List<Stay>> ericSearchResult = eric.search(new SearchCriteria(1, 12 ,16));
        eric.select(ericSearchResult, 0);
        System.out.println(hilton.leftStays.toString());
        System.out.println(hilton.existReservations.toString());
        System.out.println();

        /// Should throw a NotAvailableRoomException
//        List<List<Stay>> victorSearchResult = victor.search(new SearchCriteria(1, 14 ,16));
        chris.cancel();
        List<List<Stay>> victorSearchResult = victor.search(new SearchCriteria(1, 14 ,16));
        victor.select(victorSearchResult, 0);
        System.out.println(hilton.leftStays.toString());
        System.out.println(hilton.existReservations.toString());
    }
}
