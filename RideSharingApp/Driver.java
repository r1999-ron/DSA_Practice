package RideSharingApp;

class Driver extends User {
    private String vehicleDetails;
    private String licenseNo;
    private double rating;
    private boolean available;

    public Driver(String userId, String name, String email, String phone, 
                 String vehicleDetails, String licenseNo, Location location) {
        super(userId, name, email, phone, location);
        this.vehicleDetails = vehicleDetails;
        this.licenseNo = licenseNo;
        this.rating = 5.0;
        this.available = true;
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public String getVehicleDetails() { return vehicleDetails; }
    public String getLicenseNo() { return licenseNo; }
    public double getRating() { return rating; }
    public void updateRating(double newRating) { this.rating = (this.rating + newRating) / 2; }
}