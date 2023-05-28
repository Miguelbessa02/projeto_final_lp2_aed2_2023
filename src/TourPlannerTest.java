import controllers.DataInitializer;
import db.Database;
import edu.princeton.cs.algs4.Date;
import models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to test the TourPlanner application.
 */
public class TourPlannerTest {
    private Database database;

    @BeforeEach
    public void setUp() {
        database = DataInitializer.InitData();
    }

    /**
     * Test the get user profile
     */
    @Test
    public void testGetProfileUser() {
        Assertions.assertEquals(new Profile("1", "Doe"), database.getUsers().get("1").getProfile());
        Assertions.assertEquals(new Profile("2", "Joe"), database.getUsers().get("2").getProfile());
        Assertions.assertEquals(new Profile("3", "Smith"), database.getUsers().get("3").getProfile());
        Assertions.assertEquals(new Profile("4", "Warner"), database.getUsers().get("4").getProfile());
        Assertions.assertEquals(new Profile("5", "Alex"), database.getUsers().get("5").getProfile());
        Assertions.assertEquals(new Profile("6", "Benjamin"), database.getUsers().get("6").getProfile());
        Assertions.assertEquals(new Profile("7", "Lee"), database.getUsers().get("7").getProfile());
        Assertions.assertEquals(new Profile("8", "Ahmed"), database.getUsers().get("8").getProfile());
        Assertions.assertEquals(new Profile("9", "Oxe"), database.getUsers().get("9").getProfile());
        Assertions.assertEquals(new Profile("10", "Poe"), database.getUsers().get("10").getProfile());
    }

    /**
     * Test the add
     */
    @Test
    public void testAddUser() {
        database.getUsers().add("11", new User(new Profile("11", "A")));
        Assertions.assertEquals(new Profile("11", "A"), database.getUsers().get("11").getProfile());

        database.getUsers().add("12", new User(new Profile("12", "B")));
        Assertions.assertEquals(new Profile("12", "B"), database.getUsers().get("12").getProfile());

        database.getUsers().add("13", new User(new Profile("13", "C")));
        Assertions.assertEquals(new Profile("13", "C"), database.getUsers().get("13").getProfile());

        Assertions.assertEquals(13, database.getUsers().getAll().size());
    }

    /**
     * Test the add and remove user
     */
    @Test
    public void testRemoveUser() {
        database.getUsers().add("11", new User(new Profile("11", "A")));
        Assertions.assertEquals(new Profile("11", "A"), database.getUsers().get("11").getProfile());

        database.getUsers().remove("11");
        Assertions.assertNull(database.getUsers().get("11"));

        Assertions.assertEquals(10, database.getUsers().getAll().size());
    }

    /**
     * Test the get trips by user
     */
    @Test
    public void testTripsUser() {
        Assertions.assertEquals(6, database.getUsers().get("1").getTrips().size());
        Assertions.assertEquals(1, database.getUsers().get("2").getTrips().size());
        Assertions.assertEquals(0, database.getUsers().get("3").getTrips().size());
        Assertions.assertEquals(0, database.getUsers().get("4").getTrips().size());
        Assertions.assertEquals(0, database.getUsers().get("5").getTrips().size());
        Assertions.assertEquals(0, database.getUsers().get("6").getTrips().size());
        Assertions.assertEquals(0, database.getUsers().get("7").getTrips().size());
        Assertions.assertEquals(0, database.getUsers().get("8").getTrips().size());
        Assertions.assertEquals(0, database.getUsers().get("9").getTrips().size());
        Assertions.assertEquals(0, database.getUsers().get("10").getTrips().size());
    }

    /**
     * Test the add trip
     */
    @Test
    public void testAddTrip() {
        database.getUsers().add("11", new User(new Profile("11", "A")));

        database.getUsers().get("11")
                .addTrip(new Trip(database.getRoutes().get("5"),
                        new Time(13, 0, new Date(1, 1, 2020)),
                        new Time(19, 0, new Date(1, 1, 2020))));
        database.getUsers().get("11")
                .addTrip(new Trip(database.getRoutes().get("6"),
                        new Time(13, 0, new Date(1, 1, 2020)),
                        new Time(19, 0, new Date(1, 1, 2020))));
        database.getUsers().get("11")
                .addTrip(new Trip(database.getRoutes().get("7"),
                        new Time(13, 0, new Date(1, 1, 2020)),
                        new Time(19, 0, new Date(1, 1, 2020))));
        database.getUsers().get("11")
                .addTrip(new Trip(database.getRoutes().get("8"),
                        new Time(13, 0, new Date(1, 1, 2020)),
                        new Time(19, 0, new Date(1, 1, 2020))));
        database.getUsers().get("11")
                .addTrip(new Trip(database.getRoutes().get("9"),
                        new Time(13, 0, new Date(1, 1, 2020)),
                        new Time(19, 0, new Date(1, 1, 2020))));
        database.getUsers().get("11")
                .addTrip(new Trip(database.getRoutes().get("10"),
                        new Time(13, 0, new Date(1, 1, 2020)),
                        new Time(19, 0, new Date(1, 1, 2020))));

        Assertions.assertEquals(6, database.getUsers().get("11").getTrips().size());
    }

    /**
     * test the routes by user and period
     */
    @Test
    public void testRoutesByUserAndPeriod() {
        Assertions.assertEquals(6,
                database.getRoutesByUserAndPeriod("1",
                        new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(20, 0, new Date(1, 1, 2020))).size());

        Assertions.assertEquals(0,
                database.getRoutesByUserAndPeriod("2",
                        new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(20, 0, new Date(1, 1, 2020))).size());

        Assertions.assertEquals(0,
                database.getRoutesByUserAndPeriod("3",
                        new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(20, 0, new Date(1, 1, 2020))).size());

        Assertions.assertEquals(0,
                database.getRoutesByUserAndPeriod("4",
                        new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(20, 0, new Date(1, 1, 2020))).size());

        Assertions.assertEquals(0,
                database.getRoutesByUserAndPeriod("5",
                        new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(20, 0, new Date(1, 1, 2020))).size());

        Assertions.assertEquals(0,
                database.getRoutesByUserAndPeriod("6",
                        new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(20, 0, new Date(1, 1, 2020))).size());
    }

    /**
     * test the unused routes by period
     */
    @Test
    public void testUnusedStationsByPeriod() {
        Assertions.assertEquals(8,
                database.getUnusedStationsByPeriod("1",
                        new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(15, 0, new Date(1, 1, 2020))).size());

        Assertions.assertEquals(2,
                database.getStations().getAll().size() -
                        database.getUnusedStationsByPeriod("1",
                                new Time(9, 0, new Date(1, 1, 2020)),
                                new Time(15, 0, new Date(1, 1, 2020))).size());
    }

    /**
     * test the get user by route and period
     */
    @Test
    public void testGetUserByRouteAndPeriod() {
        List<Station> stations = new ArrayList<>();
        stations.add(database.getStations().get("1"));
        stations.add(database.getStations().get("2"));
        stations.add(database.getStations().get("3"));

        Assertions.assertEquals(1,
                database.getUsersByRouteAndPeriod(stations,
                        new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(20, 0, new Date(1, 1, 2020))).size());

        stations.add(database.getStations().get("4"));
        stations.add(database.getStations().get("5"));

        Assertions.assertEquals(1,
                database.getUsersByRouteAndPeriod(stations,
                        new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(20, 0, new Date(1, 1, 2020))).size());
    }

    /**
     * test the get top users by stations and period
     */
    @Test
    public void testTopUsersByStationsAndPeriod(){
        List<User> users = database.getTopUsersByStationsAndPeriod(new Time(9, 0, new Date(1, 1, 2020)),
                new Time(20, 0, new Date(1, 1, 2020)));

        Assertions.assertEquals(2, users.size());
    }
}
