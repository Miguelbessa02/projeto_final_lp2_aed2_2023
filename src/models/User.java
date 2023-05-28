package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user in the transportation system.
 */
public class User {
    private Profile profile;
    private List<Trip> trips;

    /**
     * Constructs a User object with the specified profile and trips.
     *
     * @param profile The profile of the user.
     * @param trips   The list of trips associated with the user.
     */
    public User(Profile profile, List<Trip> trips) {
        this.profile = profile;
        this.trips = trips;
    }

    /**
     * Constructs a User object with the specified profile.
     *
     * @param profile The profile of the user.
     */
    public User(Profile profile) {
        this.profile = profile;
        this.trips = new ArrayList<>();
    }

    /**
     * adds a trip to the user.
     *
     * @param trip  trip that is going to add.
     */
    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    /**
     * Gets the profile of the user.
     *
     * @return The profile of the user.
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Sets the profile of the user.
     *
     * @param profile The profile of the user.
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Gets the list of trips associated with the user.
     *
     * @return The list of trips associated with the user.
     */
    public List<Trip> getTrips() {
        return trips;
    }

    /**
     * Sets the list of trips associated with the user.
     *
     * @param trips The list of trips associated with the user.
     */
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "Name: " + profile.getName();
    }
}
