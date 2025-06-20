package RideSharingApp;

public interface PricingStrategy {

    double calculateFare(double distance, double time, double surgeMultiplier);
    
}