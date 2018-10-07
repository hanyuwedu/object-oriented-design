package type.reservation.hotel.v1;

public enum RoomType {
    SINGLE(1),
    DOUBLE(2);

    int volumn;

    RoomType(int volumn) {
        this.volumn = volumn;
    }

    public int getVolumn() {
        return this.volumn;
    }
}
