package parking_system;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private String location;
    private int capacity;
    private List<ParkingSpot> parkingSpots;

    public ParkingLot(String name, String location, int capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.parkingSpots = new ArrayList<>();

        for (int i = 1; i <= capacity; i++) {
            parkingSpots.add(new ParkingSpot(i, "Compact"));
        }
    }

    public ParkingSpot findAvailableSpot() {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot availableSpot = findAvailableSpot();
        if (availableSpot == null) {
            System.out.println("Parking Lot Full!");
            return null;
        }
        availableSpot.assignVehicle(vehicle);
        return new Ticket("T" + vehicle.getLicensePlate(), availableSpot);
    }

    public void removeVehicle(Ticket ticket) {
        ticket.exit();
        ticket.parkingSpot.removeVehicle();
        System.out.println("Vehicle Removed. Fee: $" + ticket.calculateFee());
    }
}
