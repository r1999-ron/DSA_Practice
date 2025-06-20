package RideSharingApp;

import java.util.Date;

class Trip {
    private String tripId;
    private Driver driver;
    private RideRequest rideRequest;
    private double fare;
    private Date startTime;
    private Date endTime;

    public Trip(String tripId, Driver driver, RideRequest rideRequest) {
        this.tripId = tripId;
        this.driver = driver;
        this.rideRequest = rideRequest;
        this.startTime = new Date();
        rideRequest.setStatus(RideStatus.ACCEPTED);
        driver.setAvailable(false);
    }

    public void completeTrip(double fare) {
        this.fare = fare;
        this.endTime = new Date();
        rideRequest.setStatus(RideStatus.COMPLETED);
        driver.setAvailable(true);
    }

    public String getTripId() { return tripId; }
    public Driver getDriver() { return driver; }
    public double getFare() { return fare; }
    public RideRequest getRideRequest() { return rideRequest; }
}