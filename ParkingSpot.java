package parking_system;//package parking_system;

public class ParkingSpot {
    private int spotNumber;
    private String spotType;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber, String spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }
}
