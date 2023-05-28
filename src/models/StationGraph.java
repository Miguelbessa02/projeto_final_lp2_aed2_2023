package models;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.util.List;

/**
 * Represents a graph of stations.
 * This class is used to find the best route between two stations.
 * The best route is the route with the minimum time, price, or stops.
 * The type of the best route is specified by the user.
 * The type can be time, price, or stops.
 * The best route is found using Dijkstra's algorithm.
 * The graph is represented as an edge-weighted digraph.
 * The vertices of the graph are the stations.
 * The edges of the graph are the connections between the stations.
 */
public class StationGraph extends EdgeWeightedDigraph {
    private final List<Station> stations;
    private final String type;

    /**
     * Constructs a StationGraph object with the specified stations, connections, and type.
     * @param stations The list of stations.
     * @param connections The list of connections.
     * @param type The type of the best route.
     */
    public StationGraph(List<Station> stations, List<Connection> connections, String type) {
        super(stations.size());
        this.stations = stations;
        this.type = type;

        for (Connection connection : connections) {
            double value = 0;
            switch (type){
                case "time" ->
                        value = connection.getPreferences().getTime();
                case "price" ->
                        value = connection.getPreferences().getPrice();
                case "stops" ->
                        value = connection.getPreferences().getStops();
                default ->
                        System.out.println("Invalid type");
            }
            addEdge(new DirectedEdge(connection.getSource().getId(), connection.getDestination().getId(), value));
        }
    }

    /**
     * Finds the best route between two stations.
     * @param source The source station.
     * @param destination The destination station.
     */
    public void findBestRoute(Station source, Station destination){
        DijkstraSP dijkstraSP = new DijkstraSP(this, source.getId());
        System.out.println("Best route from " + source.getName() + " to " + destination.getName() + " based on "+ type +":");
        double totalWeight = 0;
        for (DirectedEdge edge : dijkstraSP.pathTo(destination.getId())) {
            System.out.println(getStationName(edge.from()) + " -> " + getStationName(edge.to()) + " : " + edge.weight());
            totalWeight += edge.weight();
        }
        System.out.println("Total " + type + ": " + totalWeight);
    }

    /**
     * Gets the name of the station with the specified id.
     * @param id The id of the station.
     * @return The name of the station.
     */
    private String getStationName(int id){
        for (Station station : stations) {
            if (station.getId() == id){
                return station.getName();
            }
        }
        return null;
    }
}
