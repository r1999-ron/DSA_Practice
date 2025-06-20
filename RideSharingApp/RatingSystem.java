package RideSharingApp;

public class RatingSystem {
    public void rateDriver(Driver driver, int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        driver.updateRating(rating);
    }
}
