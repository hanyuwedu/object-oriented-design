package jiuzhang.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotSystem {
//    public class InvalidVehicleException extends RuntimeException {
//        public InvalidVehicleException(String message) {
//            super(message);
//        }
//    }

    // enum type for Vehicle
    enum VehicleSize {
        Motorcycle,
        Compact,
        Large,
    }

    abstract class Vehicle {
        public abstract VehicleSize getVehicleSize();
        public abstract int getRequiredSpots();
    }

    class Motorcycle extends Vehicle {
        @Override
        public VehicleSize getVehicleSize() {
            return VehicleSize.Motorcycle;
        }

        @Override
        public int getRequiredSpots() {
            return 1;
        }
    }

    class Car extends Vehicle {
        @Override
        public VehicleSize getVehicleSize() {
            return VehicleSize.Compact;
        }

        @Override
        public int getRequiredSpots() {
            return 1;
        }
    }

    class Bus extends Vehicle {
        @Override
        public VehicleSize getVehicleSize() {
            return VehicleSize.Large;
        }

        @Override
        public int getRequiredSpots() {
            return 5;
        }
    }

    interface IParkingStrategy {
        boolean park(Vehicle vehicle);
        boolean leave(Vehicle vehicle);
    }

    class SpotStrategy implements IParkingStrategy {
        Level level;

        public SpotStrategy(Level level) {
            this.level = level;
        }

        @Override
        public boolean park(Vehicle vehicle) {
            if (vehicle.getVehicleSize().equals(VehicleSize.Large)) {
                for (int i = 0; i <= level.r - 1; i++) {
                    for (int start = level.k / 4 * 3; start < level.k; start++) {
                        int end = start + 4;
                        if (end >= level.k) {
                            break;
                        }

                        boolean available = true;
                        for (int c = start; c <= end; c++) {
                            if (level.spots[i][c]) {
                                available = false;
                                break;
                            }
                        }

                        if (available) {
                            List<List<Integer>> parkedSpot = new ArrayList<>();
                            for (int c = start; c <= end; c++) {
                                level.spots[i][c] = true;
                                List<Integer> spot = new ArrayList<>();
                                spot.add(i);
                                spot.add(c);
                                parkedSpot.add(spot);
                            }

                            level.parkingInfo.put(vehicle, parkedSpot);
                            return true;
                        }
                    }
                }

                return false;
            } else if (vehicle.getVehicleSize().equals(VehicleSize.Compact)) {
                for (int i = 0; i <= level.r - 1; i++) {
                    for (int c = level.k / 4; c < level.k; c++) {
                        if (!level.spots[i][c]) {
                            List<List<Integer>> parkedSpot = new ArrayList<>();
                            List<Integer> spot = new ArrayList<>();
                            spot.add(i);
                            spot.add(c);
                            parkedSpot.add(spot);
                            level.spots[i][c] = true;
                            level.parkingInfo.put(vehicle, parkedSpot);
                            return true;
                        }
                    }
                    return false;
                }
            } else if (vehicle.getVehicleSize().equals(VehicleSize.Motorcycle)) {
                for (int i = 0; i <= level.r - 1; i++) {
                    for (int c = 0; c < level.k; c++) {
                        if (!level.spots[i][c]) {
                            List<List<Integer>> parkedSpot = new ArrayList<>();
                            List<Integer> spot = new ArrayList<>();
                            spot.add(i);
                            spot.add(c);
                            parkedSpot.add(spot);
                            level.spots[i][c] = true;
                            level.parkingInfo.put(vehicle, parkedSpot);
                            return true;
                        }
                    }
                    return false;
                }
            } else {
//                throw new InvalidVehicleException("Unkown vehicle size!");
                return false;
            }
            return false;
        }

        @Override
        public boolean leave(Vehicle vehicle) {
            if (!level.parkingInfo.containsKey(vehicle)) {
//                throw new InvalidVehicleException("This vehicle does not park in this level!");
                return false;
            }

            List<List<Integer>> parkedSpot = level.parkingInfo.get(vehicle);
            for (List<Integer> spot : parkedSpot) {
                level.spots[spot.get(0)][spot.get(1)] = false;
            }

            level.parkingInfo.remove(vehicle);
            return true;
        }
    }

    class CountSpotStrategy implements IParkingStrategy {
        Level level;
        int motorCycleSpots, carSpots, largeSpots;
        private Map<Vehicle, VehicleSize> parkedSpots;

        public CountSpotStrategy(Level level) {
            this.level = level;
            this.parkedSpots = new HashMap<>();
            this.motorCycleSpots = level.k / 2;
            this.carSpots = level.k / 4 * 3 - level.k / 4;
            this.largeSpots = level.k - level.k / 4 * 3;
        }

        @Override
        public boolean park(Vehicle vehicle) {
            if (vehicle.getVehicleSize().equals(VehicleSize.Large)) {
                if (this.largeSpots >= 5) {
                    this.largeSpots--;
                    this.parkedSpots.put(vehicle, VehicleSize.Large);
                    return true;
                }
            } else if (vehicle.getVehicleSize().equals(VehicleSize.Compact)) {
                if (this.carSpots > 0) {
                    this.carSpots--;
                    this.parkedSpots.put(vehicle, VehicleSize.Compact);
                    return true;
                } else if (this.largeSpots > 0) {
                    this.largeSpots--;
                    this.parkedSpots.put(vehicle, VehicleSize.Large);
                    return true;
                }
            } else if (vehicle.getVehicleSize().equals(VehicleSize.Motorcycle)) {
                if (this.motorCycleSpots > 0) {
                    this.motorCycleSpots--;
                    this.parkedSpots.put(vehicle, VehicleSize.Motorcycle);
                    return true;
                } else if (this.carSpots > 0) {
                    this.carSpots--;
                    this.parkedSpots.put(vehicle, VehicleSize.Compact);
                    return true;
                } else if (this.largeSpots > 0) {
                    this.largeSpots--;
                    this.parkedSpots.put(vehicle, VehicleSize.Large);
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean leave(Vehicle vehicle) {
            if (!this.parkedSpots.containsKey(vehicle)) {
                return false;
            }

            int spots = vehicle.getRequiredSpots();
            switch (this.parkedSpots.get(vehicle)) {
                case Large: this.largeSpots += spots;
                case Compact: this.carSpots += spots;
                case Motorcycle: this.motorCycleSpots += spots;
            }
            this.parkedSpots.remove(vehicle);

            return true;
        }
    }


    /* Represents a level in a parking garage */
    class Level {
        private boolean[][] spots;
        private int r, k;
        private Map<Vehicle, List<List<Integer>>> parkingInfo;

        private IParkingStrategy parkingStrategy;

        public Level(int rows, int spots) {
            this.spots = new boolean[rows][spots];
            this.r = rows;
            this.k = spots;
            this.parkingInfo = new HashMap<>();
            this.parkingStrategy = new SpotStrategy(this);
        }

        public boolean park(Vehicle vehicle) {
            return this.parkingStrategy.park(vehicle);
        }

        public void leave(Vehicle vehicle) {
            this.parkingStrategy.leave(vehicle);
        }
    }

    public class ParkingLot {

        private List<Level> levels;
        private Map<Vehicle, Level> parkingInfo;

        // @param n number of leves
        // @param num_rows  each level has num_rows rows of spots
        // @param spots_per_row each row has spots_per_row spots
        public ParkingLot(int n, int num_rows, int spots_per_row) {
            this.levels = new ArrayList<>();
            this.parkingInfo = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                levels.add(new Level(num_rows, spots_per_row));
            }
        }

        // Park the vehicle in a spot (or multiple spots)
        // Return false if failed
        public boolean parkVehicle(Vehicle vehicle) {
            for (Level level : levels) {
                if (level.park(vehicle)) {
                    this.parkingInfo.put(vehicle, level);
                    return true;
                }
            }

            return false;
        }

        // unPark the vehicle
        public void unParkVehicle(Vehicle vehicle) {
            if (!this.parkingInfo.containsKey(vehicle)) {
//                throw new InvalidVehicleException("This vehicle does not park in this parking lot");
                return;
            }

            this.parkingInfo.get(vehicle).leave(vehicle);
            this.parkingInfo.remove(vehicle);
        }
    }
}
