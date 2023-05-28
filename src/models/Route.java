package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a route from a source station to a destination station, consisting of multiple connections.
 */
public class Route {
    private Station source;
    private Station destination;
    private List<Connection> connections;

    /**
     * Constructs a Route object with the specified source station, destination station, connections, and preferences.
     *
     * @param source       The source station of the route.
     * @param destination  The destination station of the route.
     * @param connections  The list of connections comprising the route.
     */
    public Route(Station source, Station destination, List<Connection> connections) {
        this.source = source;
        this.destination = destination;
        this.connections = connections;
    }

    /**
     * Constructs a Route object with the specified source station, destination station, and connections.
     *
     * @param source       The source station of the route.
     * @param destination  The destination station of the route.
     */
    public Route(Station source, Station destination) {
        this.source = source;
        this.destination = destination;
        this.connections = new ArrayList<>();
    }

    /**
     * Constructs a Route object with the specified source station, destination station, and connections.
     *
     * @param connection       connection that is going to add.
     */
    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    /**
     * Gets the source station of the route.
     *
     * @return The source station of the route.
     */
    public Station getSource() {
        return source;
    }

    /**
     * Sets the source station of the route.
     *
     * @param source The source station of the route.
     */
    public void setSource(Station source) {
        this.source = source;
    }

    /**
     * Gets the destination station of the route.
     *
     * @return The destination station of the route.
     */
    public Station getDestination() {
        return destination;
    }

    /**
     * Sets the destination station of the route.
     *
     * @param destination The destination station of the route.
     */
    public void setDestination(Station destination) {
        this.destination = destination;
    }

    /**
     * Gets the list of connections comprising the route.
     *
     * @return The list of connections comprising the route.
     */
    public List<Connection> getConnections() {
        return connections;
    }

    /**
     * Sets the list of connections comprising the route.
     *
     * @param connections The list of connections comprising the route.
     */
    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    /**
     * Returns the string representation of the Route object.
     *
     * @return The string representation of the Route object.
     */
    @Override
    public String toString() {
        return "Route{" +
                "source=" + source +
                ", destination=" + destination +
                ", connections=" + connections + '}';
    }
}
