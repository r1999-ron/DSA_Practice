package RideSharingApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class RideSharingApp {
    private Map<String, Rider> riders = new HashMap<>();
    private Map<String, Driver> drivers = new HashMap<>();
    private Map<String, RideRequest> rideRequests = new HashMap<>();
    private Map<String, Trip> trips = new HashMap<>();
    private Map<String, Payment> payments = new HashMap<>();
    private DriverMatcher driverMatcher = new DriverMatcher();
    private PricingStrategy pricingStrategy = new StandardPricing();
    RatingSystem ratingSystem = new RatingSystem();

    public void addRider(Rider rider) {
        riders.put(rider.getUserId(), rider);
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getUserId(), driver);
    }

    public String requestRide(String riderId, Location pickupLocation, Location destination) {
        Rider rider = riders.get(riderId);
        if (rider == null) throw new IllegalArgumentException("Rider not found");

        List<Driver> nearbyDrivers = driverMatcher.findNearByDriver(pickupLocation, drivers);
        if (nearbyDrivers.isEmpty()) {
            throw new RuntimeException("No available drivers nearby");
        }

        String requestId = "REQ_" + System.currentTimeMillis();
        RideRequest request = new RideRequest(requestId, rider, pickupLocation, destination);
        rideRequests.put(requestId, request);

        return requestId;
    }

    public String acceptRide(String driverId, String requestId) {
        Driver driver = drivers.get(driverId);
        if (driver == null) throw new IllegalArgumentException("Driver not found");

        RideRequest request = rideRequests.get(requestId);
        if (request == null) throw new IllegalArgumentException("Ride request not found");

        String tripId = "TRIP_" + System.currentTimeMillis();
        Trip trip = new Trip(tripId, driver, request);
        trips.put(tripId, trip);

        // Calculate fare
        double distance = request.getPickupLocation().distanceTo(request.getDestination());
        double time = distance * 3; // Approx time in minutes
        double fare = pricingStrategy.calculateFare(distance, time, 1.0);
        trip.completeTrip(fare);

        return tripId;
    }

    public Payment processPayment(String tripId) {
        Trip trip = trips.get(tripId);
        if (trip == null) throw new IllegalArgumentException("Trip not found");

        String paymentId = "PAY_" + System.currentTimeMillis();
        Payment payment = new Payment(paymentId, trip);
        payment.processPayment();
        payments.put(paymentId, payment);

        return payment;
    }

    public Optional<Trip> getTrip(String tripId) {
        return Optional.ofNullable(trips.get(tripId));
    }

    public void rateDriver(String driverId, int rating) {
        Driver driver = drivers.get(driverId);
        if (driver == null) throw new IllegalArgumentException("Driver not found");
        ratingSystem.rateDriver(driver, rating);
    }

}