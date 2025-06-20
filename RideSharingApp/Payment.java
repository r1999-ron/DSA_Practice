package RideSharingApp;

public class Payment {
    private String paymentId;
    private Trip trip;
    private PaymentStatus status;

    public Payment(String paymentId, Trip trip) {
        this.paymentId = paymentId;
        this.trip = trip;
        this.status = PaymentStatus.PENDING;
    }

    public void processPayment() {
        // Simulate payment processing
        if(Math.random() > 0.1){
            this.status = PaymentStatus.COMPLETED;
        }else{
            this.status = PaymentStatus.FAILED;
        }
    }

    public PaymentStatus getStatus() { return status; }
}
