package type.reservation.restaurant.v2.module;

public class SearchCriteria {
    private int startTime, endTime, partySize;

    public SearchCriteria(int startTime, int endTime, int partySize) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.partySize = partySize;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getPartySize() {
        return partySize;
    }

    @Override
    public String toString() {
        return "Search request from " + startTime + " to " + endTime
                + " with a party of " + this.partySize;
    }
}
