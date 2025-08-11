package parking_system;//package parking_system;

import java.time.LocalDateTime;
import java.time.Duration;

public class Ticket {
    private String ticketNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    ParkingSpot parkingSpot; // package-private for access from ParkingLot

    public Ticket(String ticketNumber, ParkingSpot parkingSpot) {
        this.ticketNumber = ticketNumber;
        this.entryTime = LocalDateTime.now();
        this.parkingSpot = parkingSpot;
    }

    public void exit() {
        this.exitTime = LocalDateTime.now();
    }

    // Get duration in seconds for a more precise fee calculation
    public long getDurationInSeconds() {
        if (exitTime == null) {
            return Duration.between(entryTime, LocalDateTime.now()).getSeconds();
        }
        return Duration.between(entryTime, exitTime).getSeconds();
    }

    // Calculate fee based on seconds; $2 per minute means $2/60 per second.
    public double calculateFee() {
        long seconds = getDurationInSeconds();
        return (seconds / 60.0) * 2.0;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
