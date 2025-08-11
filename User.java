package parking_system;//package parking_system;

public class User {
    private String userId;
    private String name;
    private String contactInfo;
    private Vehicle vehicle;

    public User(String userId, String name, String contactInfo, Vehicle vehicle) {
        this.userId = userId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
