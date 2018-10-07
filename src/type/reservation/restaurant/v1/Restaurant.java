package type.reservation.restaurant.v1;

import type.reservation.restaurant.v1.exceptions.InvalidSearchCriteriaException;
import type.reservation.restaurant.v1.exceptions.NotAvailableTimeSlotException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    Map<TimeSlot, Integer> leftReservations;
    Map<Customer, Reservation> existReservations;

    public Restaurant(int tables) {
        this.leftReservations = new HashMap<>();
        this.existReservations = new HashMap<>();

        for (int i = 10; i <= 16; i++) {
            TimeSlot timeSlot = new TimeSlot(i, i + 1);
            this.leftReservations.put(timeSlot, tables);
        }
    }

    public List<TimeSlot> search(TimeSlot searchCriteria) {
        if (searchCriteria.from < 10 || searchCriteria.to > 16 || searchCriteria.from > searchCriteria.to) {
            throw new InvalidSearchCriteriaException();
        }

        List<TimeSlot> result = new ArrayList<>();

        for (TimeSlot timeSlot : leftReservations.keySet()) {
            if (timeSlot.from >= searchCriteria.from
                    && timeSlot.to <= searchCriteria.to
                    && leftReservations.get(timeSlot) > 0) {
                result.add(timeSlot);
            }
        }

        if (result.isEmpty()) {
            throw new NotAvailableTimeSlotException();
        }

        return result;
    }

    public void cancel(Customer customer) {
        Reservation reservation = existReservations.get(customer);
        existReservations.remove(customer);
        leftReservations.put(reservation.timeSlot, leftReservations.get(reservation.timeSlot) + 1);
    }

    public void select(Customer customer, TimeSlot timeSlot) {
        this.leftReservations.put(timeSlot, this.leftReservations.get(timeSlot) - 1);
        this.existReservations.put(customer, new Reservation(customer, timeSlot));
    }
}
