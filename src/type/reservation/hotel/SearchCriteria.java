package type.reservation.hotel;

import java.time.LocalDate;

public class SearchCriteria {
    private int num;
    private int start, end;

    public SearchCriteria(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    public int getNum() {
        return this.num;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}
