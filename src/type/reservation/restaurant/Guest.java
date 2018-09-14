package type.reservation.restaurant;

import java.util.List;

public class Guest {
    public static void main(String[] args) {
        Restaurant jeanGeorges = new Restaurant(5);
        System.out.println(jeanGeorges.leftReservations.toString());

        Restaurant elevenMadisonPark = new Restaurant(2);
        Customer chris = new Customer("chris", elevenMadisonPark);
        Customer jeffery = new Customer("jeffery", elevenMadisonPark);
        Customer eric = new Customer("eric", elevenMadisonPark);

        List<TimeSlot> chrisResult = chris.search(11, 13);
        System.out.println(chrisResult.toString());

        chris.select(chrisResult);
        System.out.println(elevenMadisonPark.leftReservations.toString());
        System.out.println(elevenMadisonPark.existReservations.toString());

        List<TimeSlot> jefferyResult = jeffery.search(11, 12);
        jeffery.select(jefferyResult);

        System.out.println(elevenMadisonPark.existReservations);

        // Would throw an error
//        List<TimeSlot> ericResult = eric.search(11, 12);

        jeffery.cancel();
        System.out.println(elevenMadisonPark.existReservations);

        List<TimeSlot> ericResult = eric.search(11, 12);
        eric.select(ericResult);

        System.out.println(elevenMadisonPark.leftReservations);
        System.out.println(elevenMadisonPark.existReservations);
    }
}
