package parking_system;//package parking_system;

//import ParkingLot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a parking lot with a capacity of 5 spots
        ParkingLot parkingLot = new ParkingLot("City Parking", "Downtown", 5);
        Scanner scanner = new Scanner(System.in);

        // Get vehicle details from the user
        System.out.print("Enter your license plate: ");
        String licensePlate = scanner.nextLine();

        System.out.print("Enter your vehicle type (Car/Bike/Truck): ");
        String vehicleType = scanner.nextLine();

        // Create the vehicle object
        Vehicle vehicle = new Vehicle(licensePlate, vehicleType);

        // Get user details (optional)
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your contact info: ");
        String contactInfo = scanner.nextLine();

        User user = new User("U" + licensePlate, name, contactInfo, vehicle);

        // Park the vehicle and issue a ticket
        Ticket ticket = parkingLot.parkVehicle(vehicle);
        if (ticket != null) {
            System.out.println("\nparking_system.Vehicle Parked Successfully.");
            System.out.println("parking_system.Ticket ID: " + ticket.getTicketNumber());
            System.out.println("Entry Time: " + ticket.getEntryTime());

            // Wait for the user to simulate exit (press Enter)
            System.out.println("\nPress Enter when you want to exit the parking lot...");
            scanner.nextLine();

            // Remove the vehicle and calculate the fee
            parkingLot.removeVehicle(ticket);
            double fee = ticket.calculateFee();
            System.out.println("Total parking fee: $" + fee);

            // Process the payment
            System.out.print("\nEnter payment method (Cash/Card/Online): ");
            String paymentMethod = scanner.nextLine();
            Payment payment = new Payment("P" + licensePlate, fee, paymentMethod);
            if (payment.processPayment()) {
                System.out.println("parking_system.Payment Successful!");
            } else {
                System.out.println("parking_system.Payment Failed!");
            }
        } else {
            System.out.println("Parking Lot Full. Please try again later.");
        }
        scanner.close();
    }
}
