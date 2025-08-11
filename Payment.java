package parking_system;//package parking_system;

public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private boolean status;

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = false;
    }

    public boolean processPayment() {
        this.status = true;
        return status;
    }
}
