package RideSharingApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RideSharingApp {
    private Map<String, Rider> riders = new HashMap<>();
    private Map<String, Driver> drivers = new HashMap<>();
    private List<RideRequest> rideRequests = new ArrayList<>();
    private List<Trip> trips = new ArrayList<>();
    private DriverMatcher driverMatcher = new DriverMatcher();
    private PricingStrategy pricingStrategy = new StandardPricing();

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
        rideRequests.add(request);

        Driver closestDriver = nearbyDrivers.get(0);
        String tripId = "TRIP_" + System.currentTimeMillis();
        Trip trip = new Trip(tripId, closestDriver, request);
        trips.add(trip);

        // Calculate and set fare (simplified)
        double distance = pickupLocation.distanceTo(destination);
        double time = distance * 3; // Approx time in minutes
        double fare = pricingStrategy.calculateFare(distance, time, 1.0);
        trip.completeTrip(fare);

        return tripId;
    }

    public String acceptRide(String driverId, String requestId) {
        Driver driver = drivers.get(driverId);
        if (driver == null) throw new IllegalArgumentException("Driver not found");

        RideRequest request = rideRequests.stream()
            .filter(req -> req.getRequestId().equals(requestId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Ride request not found"));

        String tripId = "TRIP_" + System.currentTimeMillis();
        Trip trip = new Trip(tripId, driver, request);
        trips.add(trip);

        // Calculate fare (simplified - using random distance/time)
        double distance = 5 + Math.random() * 20; // 5-25 km
        double time = 10 + Math.random() * 30; // 10-40 minutes
        double surge = 1.0; // No surge by default
        double fare = pricingStrategy.calculateFare(distance, time, surge);
        trip.completeTrip(fare);

        return tripId;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void completeTrip(String tripId) {
        Trip trip = trips.stream()
            .filter(t -> t.getTripId().equals(tripId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Trip not found"));
        
        trip.completeTrip(trip.getFare());
    }
}