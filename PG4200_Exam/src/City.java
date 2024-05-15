public class City {
    // Private fields to hold city data
    private String name;       // City name
    private double latitude;   // City latitude
    private double longitude;  // City longitude

    // Constructor to initialize a City object with name, latitude, and longitude
    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter for city name
    public String getName() {
        return name;
    }

    // Getter for city latitude
    public double getLatitude() {
        return latitude;
    }

    // Getter for city longitude
    public double getLongitude() {
        return longitude;
    }

    // Overrides the Object's toString method to provide a string representation of a City
    @Override
    public String toString() {
        return "Name: " + name + ", latitude: " + latitude + ", longitude: " + longitude;
    }
}
