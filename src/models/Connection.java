package models;

import edu.princeton.cs.algs4.Date;

/**
 * Represents a connection between two stations.
 */
public class Connection {
    private Station source;
    private Station destination;
    private Schedule schedule;
    private String type;
    private Preferences preferences;

    /**
     * Constructs a Connection object with the specified properties.
     *
     * @param source      The source station.
     * @param destination The destination station.
     * @param schedule    The schedule of the connection.
     * @param type        The type of the connection.
     * @param preferences The preferences of the connection.
     */
    public Connection(Station source, Station destination, Schedule schedule, String type, Preferences preferences) {
        this.source = source;
        this.destination = destination;
        this.schedule = schedule;
        this.type = type;
        this.preferences = preferences;
    }

    /**
     * Constructs a Connection object with the specified properties.
     *
     * @param source      The source station.
     * @param destination The destination station.
     * @param preferences The preferences of the connection.
     */
    public Connection(Station source, Station destination, Preferences preferences) {
        this.source = source;
        this.destination = destination;
        this.preferences = preferences;
        this.schedule = new Schedule(new Time(0, 0, new Date(10, 1, 2000)),
                new Time(0, 0, new Date(10, 1, 2000)));
        this.type = "Default";
    }

    /**
     * Gets the source station of the connection.
     *
     * @return The source station.
     */
    public Station getSource() {
        return source;
    }

    /**
     * Sets the source station of the connection.
     *
     * @param source The source station.
     */
    public void setSource(Station source) {
        this.source = source;
    }

    /**
     * Gets the destination station of the connection.
     *
     * @return The destination station.
     */
    public Station getDestination() {
        return destination;
    }

    /**
     * Sets the destination station of the connection.
     *
     * @param destination The destination station.
     */
    public void setDestination(Station destination) {
        this.destination = destination;
    }

    /**
     * Gets the schedule of the connection.
     *
     * @return The schedule.
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Sets the schedule of the connection.
     *
     * @param schedule The schedule.
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * Gets the type of the connection.
     *
     * @return The type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the connection.
     *
     * @param type The type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the preferences of the connection.
     *
     * @return The preferences.
     */
    public Preferences getPreferences() {
        return preferences;
    }

    /**
     * Sets the preferences of the connection.
     *
     * @param preferences The preferences.
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
}
