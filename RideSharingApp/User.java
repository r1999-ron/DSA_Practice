package RideSharingApp;

abstract class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String phone;
    protected Location currentLocation;

    public User(String userId, String name, String email, String phone, Location currentLocation){
            this.userId = userId;
            this.name = name;
            this.email = email;
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
