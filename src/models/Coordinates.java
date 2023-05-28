package models;

/**
 * Represents geographical coordinates with latitude and longitude values.
 */
public class Coordinates {
    private double latitude;
    private double longitude;

    /**
     * Constructs a Coordinates object with the specified latitude and longitude.
     *
     * @param latitude  The latitude value.
     * @param longitude The longitude value.
     */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Gets the latitude value.
     *
     * @return The latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets the longitude value.
     *
     * @return The longitude.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Returns the string representation of the Coordinates object in the format "latitude,longitude".
     *
     * @return The string representation of the coordinates.
     */
    @Override
    public String toString() {
        return latitude + "," + longitude;
    }
}
