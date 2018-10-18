package type.reservation.hotel.v2.module;

import type.reservation.hotel.v2.exceptions.InvalidRequestException;
import type.reservation.hotel.v2.room.Inventory;
import type.reservation.hotel.v2.room.RoomType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HotelConfigModule {
    private static final double EXECUTIVE_SUITE_PRIICE = 450.0;
    private static final double PRESIDENTIAL_SUITE_PRIICE = 400.0;
    private static final double DELUX_DOUBLE_PRIICE = 250.0;
    private static final double STANDARD_DOUBLE_PRIICE = 200.0;
    private static final double SINGLE_PRIICE = 100.0;

    private static final int EXECUTIVE_SUITE_COUNT = 1;
    private static final int PRESIDENTIAL_SUITE_COUNT = 1;
    private static final int DELUX_DOUBLE_COUNT = 2;
    private static final int STANDARD_DOUBLE_COUNT = 2;
    private static final int SINGLE_COUNT = 3;

    private static final LocalDate start = LocalDate.of(2018, 11, 1);
    private static final LocalDate end = LocalDate.of(2018, 11, 7);

    public static void initializeInventory(Inventory inventory) {
        Map<LocalDate, Map<RoomType, Integer>> rooms = new HashMap<>();
        Map<LocalDate, Map<RoomType, Double>> prices = new HashMap<>();

        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            prices.put(date, new HashMap<>());
            for (RoomType roomType : RoomType.values()) {
                prices.get(date).put(roomType, getPrice(roomType));
            }

            rooms.put(date, new HashMap<>());
            for (RoomType roomType : RoomType.values()) {
                rooms.get(date).put(roomType, getCount(roomType));
            }
        }

        inventory.setPrices(prices);
        inventory.setRooms(rooms);
    }

    private static double getPrice(RoomType roomType) {
        if (roomType.equals(RoomType.SINGLE)) {
            return SINGLE_PRIICE;
        } else if (roomType.equals(RoomType.STANDARD_DOUBLE)) {
            return STANDARD_DOUBLE_PRIICE;
        } else if (roomType.equals(RoomType.DELUX_DOUBLE)) {
            return DELUX_DOUBLE_PRIICE;
        } else if (roomType.equals(RoomType.PRESIDENTIAL_SUITE)) {
            return PRESIDENTIAL_SUITE_PRIICE;
        } else if (roomType.equals(RoomType.EXECUTIVE_SUITE)) {
            return EXECUTIVE_SUITE_PRIICE;
        } else {
            throw new InvalidRequestException("Room type is not valid!");
        }
    }

    private static int getCount(RoomType roomType) {
        if (roomType.equals(RoomType.SINGLE)) {
            return SINGLE_COUNT;
        } else if (roomType.equals(RoomType.STANDARD_DOUBLE)) {
            return STANDARD_DOUBLE_COUNT;
        } else if (roomType.equals(RoomType.DELUX_DOUBLE)) {
            return DELUX_DOUBLE_COUNT;
        } else if (roomType.equals(RoomType.PRESIDENTIAL_SUITE)) {
            return PRESIDENTIAL_SUITE_COUNT;
        } else if (roomType.equals(RoomType.EXECUTIVE_SUITE)) {
            return EXECUTIVE_SUITE_COUNT;
        } else {
            throw new InvalidRequestException("Room type is not valid!");
        }
    }
}
