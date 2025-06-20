package RideSharingApp;

public class StandardPricing implements PricingStrategy{
    private static final double BASE_FARE = 2.0;
    private static final double PER_KM_RATE = 1.5;
    private static final double PER_MINUTE_RATE = 0.2;

    @Override
    public double calculateFare(double distance, double time, double surgeMultiplier) {
        return (BASE_FARE + (distance * PER_KM_RATE) + (time * PER_MINUTE_RATE)) * surgeMultiplier;
    }
}
