package type.reservation.hotel;

import type.reservation.hotel.exceptions.InvalidSearchCriteriaException;
import type.reservation.hotel.exceptions.NoSuchCustomerException;
import type.reservation.restaurant.exceptions.NotAvailableTimeSlotException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    Map<Customer, List<Stay>> existReservations;
    Map<Stay, Integer> leftStays;

    public Hotel(int singleRoom, int doubleRoom) {
        this.existReservations = new HashMap<>();
        this.leftStays = new HashMap<>();

        for (int date = 11; date <= 20; date++) {
            Stay singleRoomStay = new Stay(RoomType.SINGLE, date);
            Stay doubleRoomStay = new Stay(RoomType.DOUBLE, date);

            this.leftStays.put(singleRoomStay, singleRoom);
            this.leftStays.put(doubleRoomStay, doubleRoom);
        }
    }

    public List<List<Stay>> search(SearchCriteria searchCriteria) {
        if (searchCriteria.getNum() <= 0 || searchCriteria.getNum() > 2) {
            throw new InvalidSearchCriteriaException();
        }

        if (searchCriteria.getStart() > searchCriteria.getEnd()) {
            throw new InvalidSearchCriteriaException();
        }

        if (searchCriteria.getStart() < 10) {
            throw new InvalidSearchCriteriaException();
        }

        if (searchCriteria.getEnd() > 21) {
            throw new InvalidSearchCriteriaException();
        }

        List<List<Stay>> result = new ArrayList<>();
        List<Stay> reservation = new ArrayList<>();

        for (int date = searchCriteria.getStart(); date <= searchCriteria.getEnd(); date++) {
            boolean found = false;
            for (Stay stay : leftStays.keySet()) {
                if (stay.date == date && stay.roomType.getVolumn() == searchCriteria.getNum()) {
                    if (this.leftStays.get(stay) > 0) {
                        reservation.add(stay);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                throw new NotAvailableTimeSlotException("Cannot found available room at date " + date);
            }
        }

        result.add(reservation);
        return result;
    }


    public void cancel(Customer customer) {
        if (!this.existReservations.containsKey(customer)) {
            throw new NoSuchCustomerException();
        }

        List<Stay> stays = this.existReservations.get(customer);
        existReservations.remove(customer);
        for (Stay stay : stays) {
            leftStays.put(stay, leftStays.get(stay) + 1);
        }

        System.out.println(customer.toString() + " has cancelled his/her reservation!");
    }

    public void select(Customer customer, List<Stay> selectedReservation) {
        this.existReservations.put(customer, selectedReservation);
        for (Stay stay : selectedReservation) {
            this.leftStays.put(stay, this.leftStays.get(stay) - 1);
        }
    }
}
