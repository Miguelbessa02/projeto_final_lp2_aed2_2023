package models;

import edu.princeton.cs.algs4.Date;

/**
 * Represents a trip in a transportation system.
 */
public class Trip {
    private Route route;
    private Time startTime, endTime;

    /**
     * Constructs a Trip object with the specified route, start time, and end time.
     *
     * @param route     The route of the trip.
     * @param startTime The start time of the trip.
     * @param endTime   The end time of the trip.
     */
    public Trip(Route route, Time startTime, Time endTime) {
        this.route = route;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Gets the route of the trip.
     *
     * @return The route of the trip.
     */
    public Route getRoute() {
        return route;
    }

    /**
     * Sets the route of the trip.
     *
     * @param route The route of the trip.
     */
    public void setRoute(Route route) {
        this.route = route;
    }

    /**
     * Gets the start time of the trip.
     *
     * @return The start time of the trip.
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the trip.
     *
     * @param startTime The start time of the trip.
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end time of the trip.
     *
     * @return The end time of the trip.
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the trip.
     *
     * @param endTime The end time of the trip.
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Trip{" + "route=" + route + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
}
