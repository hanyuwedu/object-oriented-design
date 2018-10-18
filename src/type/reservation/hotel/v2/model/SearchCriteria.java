package type.reservation.hotel.v2.model;

import type.reservation.hotel.v2.exceptions.InvalidRequestException;

import java.time.LocalDate;

public class SearchCriteria {
    private LocalDate checkin, checkout;
    private int partySize;

    public SearchCriteria(LocalDate checkin, LocalDate checkout, int partySize) {
        if (!checkout.isAfter(checkin)) {
            throw new InvalidRequestException("Starting date is after end date!");
        }

        this.checkin = checkin;
        this.checkout = checkout;
        this.partySize = partySize;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public int getPartySize() {
        return partySize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Search request ");
        sb.append(this.checkin);
        sb.append(" to ");
        sb.append(this.checkout);
        sb.append(" with a party of ");
        sb.append(this.partySize);

        return sb.toString();
    }
}
