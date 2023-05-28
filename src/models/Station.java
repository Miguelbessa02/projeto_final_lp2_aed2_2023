package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a station in a transportation system.
 */
public class Station {
    public static int idCounter = 0;
    private String name;
    private int id;
    private String location;
    private Coordinates coordinates;
    private List<Connection> connections;

    /**
     * Constructs a Station object with the specified name, location, coordinates, and connections.
     *
     * @param name        The name of the station.
     * @param location    The location of the station.
     * @param coordinates The coordinates (latitude and longitude) of the station.
     * @param connections The list of connections associated with the station.
     */
    public Station(String name, String location, Coordinates coordinates, List<Connection> connections) {
        this.name = name;
        this.location = location;
        this.coordinates = coordinates;
        this.connections = connections;
        this.id = idCounter++;
    }

    /**
     * Constructs a Station object with the specified name, location, and coordinates.
     *
     * @param name        The name of the station.
     * @param location    The location of the station.
     * @param coordinates The coordinates (latitude and longitude) of the station.
     */
    public Station(String name, String location, Coordinates coordinates) {
        this.name = name;
        this.location = location;
        this.coordinates = coordinates;
        this.connections = new ArrayList<>();
        this.id = idCounter++;
    }

    /**
     * Gets id of the station.
     * @return id of the station.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of the station.
     * @param id id of the station.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * adds a connection to the station.
     * @param connection connection that is going to add.
     */
    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    /**
     * Gets the name of the station.
     *
     * @return The name of the station.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the station.
     *
     * @param name The name of the station.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the location of the station.
     *
     * @return The location of the station.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the station.
     *
     * @param location The location of the station.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the coordinates (latitude and longitude) of the station.
     *
     * @return The coordinates of the station.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the coordinates (latitude and longitude) of the station.
     *
     * @param coordinates The coordinates of the station.
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets the list of connections associated with the station.
     *
     * @return The list of connections.
     */
    public List<Connection> getConnections() {
        return connections;
    }

    /**
     * Sets the list of connections associated with the station.
     *
     * @param connections The list of connections.
     */
    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    /**
     * Returns true iff the specified object is equal to this station.
     * @param o The object to compare.
     * @return true iff the specified object is equal to this station.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name) && Objects.equals(location, station.location)
                && Objects.equals(coordinates, station.coordinates) && Objects.equals(connections, station.connections);
    }

    /**
     * Returns the hashcode of this station.
     * @return The hashcode of this station.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, location, coordinates, connections);
    }

    /**
     * Returns a string representation of the station.
     * @return A string representation of the station.
     */
    @Override
    public String toString() {
        return id + " " +name +" (" + location + ")";
    }
}
