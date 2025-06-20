package RideSharingApp;

class Rider extends User {
    private String paymentMethod;

    public Rider(String userId, String name, String email, String phone,
            String paymentMethod, Location location) {
        super(userId, name, email, phone, location);
        this.paymentMethod = paymentMethod;
    }
    public String getPaymentMethod() { return paymentMethod; }

}
