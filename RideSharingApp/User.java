package RideSharingApp;

abstract class User {
    protected String userId;
    protected String email;
    protected String name;
    protected String phone;
    protected Location currentLocation;

    public User(String userId, String email, String name, String phone, Location currentLocation){
            this.userId = userId;
            this.email = email;
            this.name = name;
            this.phone = phone;
            this.currentLocation = currentLocation;
    }

    public void updateLocation(Location newLocation) {
        this.currentLocation = newLocation;
    }

    public Location getCurrentLocation() { return currentLocation; }
    public String getUserId() { return userId; }
    public String getName(){return name;}
    
}
