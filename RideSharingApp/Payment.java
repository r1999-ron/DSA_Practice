package RideSharingApp;

public class Payment {
    private String paymentId;
    private Trip trip;
    private double amount;
    private PaymentStatus status;

    public Payment(String paymentId, Trip trip) {
        this.paymentId = paymentId;
        this.trip = trip;
        this.amount = trip.getFare();
        this.status = PaymentStatus.PENDING;
    }

    public void processPayment() {
        // Simulate payment processing
        boolean paymentSuccess = Math.random() > 0.1; // 90% success rate
        this.status = paymentSuccess ? PaymentStatus.COMPLETED : PaymentStatus.FAILED;
    }

    public PaymentStatus getStatus() { return status; }
}
