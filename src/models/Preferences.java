package models;

/**
 * Represents user preferences for selecting routes based on price, time, and stops.
 */
public class Preferences {
    private double price;
    private double time;
    private int stops;

    /**
     * Constructs a Preferences object with the specified price, time, and stops.
     *
     * @param price The preferred price.
     * @param time  The preferred time.
     * @param stops The preferred number of stops.
     */
    public Preferences(double price, double time, int stops) {
        this.price = price;
        this.time = time;
        this.stops = stops;
    }

    /**
     * Gets the preferred price.
     *
     * @return The preferred price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the preferred time.
     *
     * @return The preferred time.
     */
    public double getTime() {
        return time;
    }

    /**
     * Gets the preferred number of stops.
     *
     * @return The preferred number of stops.
     */
    public int getStops() {
        return stops;
    }

    /**
     * Sets the preferred price.
     *
     * @param price The preferred price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the preferred time.
     *
     * @param time The preferred time.
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Sets the preferred number of stops.
     *
     * @param stops The preferred number of stops.
     */
    public void setStops(int stops) {
        this.stops = stops;
    }

    /**
     * Returns the string representation of the Preferences object.
     *
     * @return The string representation of the Preferences object.
     */
    @Override
    public String toString() {
        return "Preferences{" +
                "price=" + price +
                ", time=" + time +
                ", stops=" + stops +
                '}';
    }
}
