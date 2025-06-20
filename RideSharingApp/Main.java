package RideSharingApp;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        RideSharingApp uber = new RideSharingApp();

        // Create locations
        Location riderLocation = new Location(40.7128, -74.0060); // NYC
        Location driver1Location = new Location(40.7125, -74.0050); // 0.1km away
        Location driver2Location = new Location(40.7200, -74.0100); // 1km away
        Location destination = new Location(40.7580, -73.9855); // Times Square

        // Register users
        Rider john = new Rider("R1", "John", "john@example.com", "555-1234", 
                             "CREDIT_CARD", riderLocation);
        uber.addRider(john);

        Driver alice = new Driver("D1", "Alice", "alice@example.com", "555-5678",
                                "Toyota Camry", "DL12345", driver1Location);
        Driver bob = new Driver("D2", "Bob", "bob@example.com", "555-9999",
                              "Honda Accord", "DL67890", driver2Location);
        uber.addDriver(alice);
        uber.addDriver(bob);

        // Request a ride
        String requestId = uber.requestRide("R1", riderLocation, destination);
        System.out.println("Ride requested: " + requestId);

        String tripId = uber.acceptRide("D1", requestId);
        System.out.println("Ride accepted. Trip ID: " + tripId);


        uber.getTrip(tripId).ifPresent(trip -> {
            System.out.println("Matched driver: " + trip.getDriver().getName() + 
                             " (" + trip.getDriver().getCurrentLocation().distanceTo(riderLocation) + 
                             " km away)");
            System.out.println("Fare: $" + trip.getFare());
        });

        Payment payment = uber.processPayment(tripId);
        System.out.println("Payment status: " + payment.getStatus());


    }
}