package RideSharingApp;
import java.util.*;
import java.util.stream.Collectors;

public class DriverMatcher {

    private static final double MAX_MATCH_DISTANCE_KM = 5.0;

    public List<Driver> findNearByDriver(Location pickupLocation, Map<String, Driver> allDriver){
        return allDriver.values().stream()
           .filter(Driver :: isAvailable)
           .filter(driver ->{
            double distance = driver.getCurrentLocation().distanceTo(pickupLocation);
            return distance <= MAX_MATCH_DISTANCE_KM;
           })
           .sorted(Comparator.comparingDouble(driver ->
             driver.getCurrentLocation().distanceTo(pickupLocation)))
           .collect(Collectors.toList());

    }
    
}
