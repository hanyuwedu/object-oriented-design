package type.reservation.hotel.v1;

import java.util.List;

public class Customer {
    private String name;
    private Hotel hotel;

    public Customer(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;
    }

    public List<List<Stay>> search(SearchCriteria searchCriteria) {
        return this.hotel.search(searchCriteria);
    }

    public List<Stay> select(List<List<Stay>> reservations, int index) {
        this.hotel.select(this, reservations.get(index));
        return reservations.get(index);
    }

    public void cancel() {
        this.hotel.cancel(this);
    }

    @Override
    public String toString() {
        return "<" + this.name + ">";
    }
}
