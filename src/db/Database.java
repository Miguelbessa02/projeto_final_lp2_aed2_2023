package db;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a database for storing and managing information about stations, users, routes, schedules, and connections.
 */
public class Database {
    private final EntityManagement<Station> stationsEntityManagement;
    private final EntityManagement<User> usersEntityManagement;
    private final EntityManagement<Route> routesEntityManagement;
    private final EntityManagement<Schedule> schedulesEntityManagement;
    private final EntityManagement<Connection> connectionsEntityManagement;

    /**
     * Constructs a new Database instance.
     */
    public Database() {
        stationsEntityManagement = new GenericBST<>();
        usersEntityManagement = new GenericBST<>();
        routesEntityManagement = new SymbolTable<>();
        schedulesEntityManagement = new SymbolTable<>();
        connectionsEntityManagement = new SymbolTable<>();
    }

    /**
     * Gets the entity management for stations.
     *
     * @return The entity management for stations.
     */
    public EntityManagement<Station> getStations() {
        return stationsEntityManagement;
    }

    /**
     * Gets the entity management for users.
     *
     * @return The entity management for users.
     */
    public EntityManagement<User> getUsers() {
        return usersEntityManagement;
    }

    /**
     * Gets the entity management for routes.
     *
     * @return The entity management for routes.
     */
    public EntityManagement<Route> getRoutes() {
        return routesEntityManagement;
    }

    /**
     * Gets the entity management for schedules.
     *
     * @return The entity management for schedules.
     */
    public EntityManagement<Schedule> getSchedules() {
        return schedulesEntityManagement;
    }

    /**
     * Gets the entity management for connections.
     * @return The entity management for connections.
     */
    public EntityManagement<Connection> getConnections() {
        return connectionsEntityManagement;
    }

    /**
     * Retrieves all planned and used routes by a user within a given period.
     *
     * @param userId    The user id.
     * @param startDate The start date.
     * @param endDate   The end date.
     * @return A list of routes.
     */
    public List<Route> getRoutesByUserAndPeriod(String userId, Time startDate, Time endDate) {
        List<Trip> trips = this.usersEntityManagement.get(userId).getTrips();
        List<Route> result = new ArrayList<>();

        for (Trip trip : trips) {
            if (trip.getStartTime().compareTo(startDate) >= 0 && trip.getEndTime().compareTo(endDate) <= 0) {
                result.add(trip.getRoute());
            }
        }

        return result;
    }

    /**
     * Retrieves all stations that have not been visited/used by users within a given period.
     *
     * @param userId    The user id.
     * @param startDate The start date.
     * @param endDate   The end date.
     * @return A list of stations.
     */
    public List<Station> getUnusedStationsByPeriod(String userId, Time startDate, Time endDate) {
        List<Station> result = new ArrayList<>();
        List<Station> stationList = this.stationsEntityManagement.getAll();

        for (Station station : stationList) {
            boolean isUsed = false;
            for (Trip trip : this.usersEntityManagement.get(userId).getTrips()) {
                if (trip.getStartTime().compareTo(startDate) >= 0 && trip.getEndTime().compareTo(endDate) <= 0) {
                    // Check if station meets the source, destination, or connection station criteria
                    if (trip.getRoute().getSource().equals(station) || trip.getRoute().getDestination().equals(station)) {
                        isUsed = true;
                        break;
                    }
                    for (Connection connectionStation : trip.getRoute().getConnections()) {
                        if (connectionStation.getSource().equals(station) || connectionStation.getDestination().equals(station)) {
                            isUsed = true;
                            break;
                        }
                    }
                }
            }
            if (!isUsed) {
                result.add(station);
            }
        }

        return result;
    }

    /**
     * Retrieves all users who have used a route passing through specific stations within a given period.
     *
     * @param stations  The list of stations.
     * @param startDate The start date.
     * @param endData   The end date.
     * @return A list of users.
     */
    public List<User> getUsersByRouteAndPeriod(List<Station> stations, Time startDate, Time endData) {
        List<User> result = new ArrayList<>();
        List<User> userList = this.usersEntityManagement.getAll();

        for (User user : userList) {
            for (Trip trip : user.getTrips()) {
                if (trip.getStartTime().compareTo(startDate) >= 0 && trip.getEndTime().compareTo(endData) <= 0) {
                    // Check if route meets the source, destination, or connection station criteria
                    if (stations.contains(trip.getRoute().getSource()) || stations.contains(trip.getRoute().getDestination())) {
                        result.add(user);
                        break;
                    }
                    for (Connection connectionStation : trip.getRoute().getConnections()) {
                        if (stations.contains(connectionStation.getSource()) || stations.contains(connectionStation.getDestination())) {
                            result.add(user);
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * Retrieves the top 3 users who have visited/used the highest number of stations within a given period.
     *
     * @param startDate The start date.
     * @param endDate   The end date.
     * @return A list of users.
     */
    public List<User> getTopUsersByStationsAndPeriod(Time startDate, Time endDate) {
        List<User> result = new ArrayList<>();
        RedBlackBST<Integer, User> bst = new RedBlackBST<>();

        for (User user : this.usersEntityManagement.getAll()) {
            int count = 0;
            for (Trip trip : user.getTrips()) {
                if (trip.getStartTime().compareTo(startDate) >= 0 && trip.getEndTime().compareTo(endDate) <= 0) {
                    // Count the number of stations including source, destination, and connection stations
                    count += trip.getRoute().getConnections().size() + 2;
                }
            }
            bst.put(count, user);
        }

        // Retrieve the top 3 users with the highest number of stations
        int count = 0;
        for (int stationsCount : bst.keys()) {
            if (count >= 3) {
                break;
            }
            result.add(bst.get(stationsCount));
            count++;
        }

        return result;
    }

    /**
     * Retrieves the connection schedules between two terminals in two specified locations.
     *
     * @param location1 The location of terminal 1.
     * @param location2 The location of terminal 2.
     * @return A list of schedules.
     */
    public List<Schedule> getConnectionSchedule(String location1, String location2) {
        List<Schedule> schedules = new ArrayList<>();

        for (Connection connection : connectionsEntityManagement.getAll()) {
            if (connection.getSource().getLocation().equalsIgnoreCase(location1)
                    && connection.getDestination().getLocation().equalsIgnoreCase(location2)) {
                schedules.add(connection.getSchedule());
            }
        }

        return schedules;
    }

    /**
     * Generates a system-wide report that includes a list of stations, a list of users, and a list of connections between stations.
     */
    public void generateSystemReport() {
        System.out.println("----- Stations -----");
        for (Station station : stationsEntityManagement.getAll()) {
            System.out.println(station);
        }

        System.out.println("----- Users -----");
        for (User user : usersEntityManagement.getAll()) {
            System.out.println(user);
        }

        System.out.println("----- Connections -----");
        for (Route route : routesEntityManagement.getAll()) {
            System.out.println(route.getSource() + " --> " + route.getDestination());
        }
    }

    /**
     * Lists the daily usage frequency of stations.
     *
     * @param date The date for which to list the usage frequency.
     */
    public void listDailyUsageFrequency(Date date) {
        ST<String, Integer> st = new ST<>();

        for (User user : usersEntityManagement.getAll()) {
            for (Trip trip : user.getTrips()) {
                if (trip.getStartTime().getDate().compareTo(date) >= 0 ||
                        trip.getEndTime().getDate().compareTo(date) <= 0) {
                    addStationFrequency(st, trip.getRoute().getSource());
                    addStationFrequency(st, trip.getRoute().getDestination());
                    for (Connection connection : trip.getRoute().getConnections()) {
                        addStationFrequency(st, connection.getSource());
                        addStationFrequency(st, connection.getDestination());
                    }
                }
            }
        }
        for (String s : st.keys()) {
            System.out.println(s + " has " + st.get(s) + " number of daily usages.");
        }
    }

    /**
     * Lists the weekly usage frequency of stations.
     *
     * @param startDate The start date for which to list the usage frequency.
     * @param endDate   The end date for which to list the usage frequency.
     */
    public void listWeeklyUsageFrequency(Date startDate, Date endDate) {
        ST<String, Integer> st = new ST<>();

        for (User user : usersEntityManagement.getAll()) {
            for (Trip trip : user.getTrips()) {
                if (trip.getStartTime().getDate().compareTo(startDate) >= 0 && trip.getEndTime().getDate().compareTo(endDate) <= 0) {
                    addStationFrequency(st, trip.getRoute().getSource());
                    addStationFrequency(st, trip.getRoute().getDestination());
                    for (Connection connection : trip.getRoute().getConnections()) {
                        addStationFrequency(st, connection.getSource());
                        addStationFrequency(st, connection.getDestination());
                    }
                }
            }
        }

        for (String s : st.keys()) {
            System.out.println(s + " has " + st.get(s) + " number of weekly usages.");
        }
    }

    /**
     * add station frequency
     * @param st station frequency
     * @param s Station
     */
    private void addStationFrequency(ST<String, Integer> st, Station s) {
        if (st.contains(s.getName())) {
            st.put(s.getName(), st.get(s.getName()) + 1);
        } else {
            st.put(s.getName(), 1);
        }
    }
}