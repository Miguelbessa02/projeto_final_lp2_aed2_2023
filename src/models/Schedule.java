package models;

import edu.princeton.cs.algs4.Date;

/**
 * Represents the schedule of a connection, including the departure and arrival times.
 */
public class Schedule {
    private Time departureTime;
    private Time arrivalTime;

    /**
     * Constructs a Schedule object with the specified departure time and arrival time.
     *
     * @param departureTime The departure time of the connection.
     * @param arrivalTime   The arrival time of the connection.
     */
    public Schedule(Time departureTime, Time arrivalTime) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets the departure time of the connection.
     *
     * @return The departure time of the connection.
     */
    public Time getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the departure time of the connection.
     *
     * @param departureTime The departure time of the connection.
     */
    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Gets the arrival time of the connection.
     *
     * @return The arrival time of the connection.
     */
    public Time getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the arrival time of the connection.
     *
     * @param arrivalTime The arrival time of the connection.
     */
    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return departureTime + " - " + arrivalTime;
    }
}
