package RideSharingApp;

class RideRequest {
    private String requestId;
    private Rider rider;
    private Location pickupLocation;
    private Location destination;
    private RideStatus status;

    public RideRequest(String requestId, Rider rider, Location pickupLocation, Location destination) {
        this.requestId = requestId;
        this.rider = rider;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.status = RideStatus.REQUESTED;
    }

    public String getRequestId() { return requestId; }
    public Rider getRider() { return rider; }
    public Location getPickupLocation() { return pickupLocation; }
    public Location getDestination() { return destination; }
    public RideStatus getStatus() { return status; }
    public void setStatus(RideStatus status) { this.status = status; }
}