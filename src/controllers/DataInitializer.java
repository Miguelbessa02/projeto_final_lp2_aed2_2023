package controllers;

import db.Database;
import edu.princeton.cs.algs4.Date;
import models.*;

/**
 *
 * Inicializa os dados do sistema.
 */
public class DataInitializer {
    /**
     *
     * Inicializa os dados do sistema.
     * * @return O banco de dados do sistema.
     */
    public static Database InitData() {
        Database database = new Database();
        Preferences defaultPreferences = new Preferences(10, 10, 20);

        database.getUsers().add("1", new User(new Profile("1", "Doe")));
        database.getUsers().add("2", new User(new Profile("2", "Joe")));
        database.getUsers().add("3", new User(new Profile("3", "Smith")));
        database.getUsers().add("4", new User(new Profile("4", "Warner")));
        database.getUsers().add("5", new User(new Profile("5", "Alex")));
        database.getUsers().add("6", new User(new Profile("6", "Benjamin")));
        database.getUsers().add("7", new User(new Profile("7", "Lee")));
        database.getUsers().add("8", new User(new Profile("8", "Ahmed")));
        database.getUsers().add("9", new User(new Profile("9", "Oxe")));
        database.getUsers().add("10", new User(new Profile("10", "Poe")));

        database.getStations().add("1", new Station("Station 1", "Paris",
                new Coordinates(48.8584, 2.2945)));
        database.getStations().add("2", new Station("Station 2", "Lyon",
                new Coordinates(45.7640, 4.8357)));
        database.getStations().add("3", new Station("Station 3", "Marseille",
                new Coordinates(43.2965, 5.3698)));
        database.getStations().add("4", new Station("Station 4", "Paris",
                new Coordinates(43.6047, 1.4442)));
        database.getStations().add("5", new Station("Station 5", "Nice",
                new Coordinates(43.7102, 7.2620)));
        database.getStations().add("6", new Station("Station 6", "Lyon",
                new Coordinates(47.2181, 1.5528)));
        database.getStations().add("7", new Station("Station 7", "Strasbourg",
                new Coordinates(48.5734, 7.7521)));
        database.getStations().add("8", new Station("Station 8", "Lyon",
                new Coordinates(43.6108, 3.8767)));
        database.getStations().add("9", new Station("Station 9", "Bordeaux",
                new Coordinates(44.8378, 0.5792)));
        database.getStations().add("10", new Station("Station 10", "Lille",
                new Coordinates(50.6292, 3.0573)));

        database.getConnections().add("1", new Connection(
                database.getStations().get("1"), database.getStations().get("2"),
                new Schedule(new Time(9, 0, new Date(1, 1, 2020)),
                        new Time(10, 0, new Date(1, 1, 2020))),
                "Deluxe", defaultPreferences));
        database.getConnections().add("2", new Connection(
                database.getStations().get("2"), database.getStations().get("3"),
                new Schedule(new Time(10, 0, new Date(1, 1, 2020)),
                        new Time(11, 0, new Date(1, 1, 2020))),
                "Deluxe", defaultPreferences));
        database.getConnections().add("3", new Connection(
                database.getStations().get("3"), database.getStations().get("4"),
                new Schedule(new Time(11, 0, new Date(1, 1, 2020)),
                        new Time(12, 0, new Date(1, 1, 2020))),
                "Deluxe", defaultPreferences));
        database.getConnections().add("4", new Connection(
                database.getStations().get("4"), database.getStations().get("5"),
                new Schedule(new Time(12, 0, new Date(1, 1, 2020)),
                        new Time(13, 0, new Date(1, 1, 2020))),
                "Deluxe", defaultPreferences));
        database.getConnections().add("5", new Connection(
                database.getStations().get("1"), database.getStations().get("6"),
                new Schedule(new Time(13, 0, new Date(1, 1, 2020)),
                        new Time(14, 0, new Date(1, 1, 2020))),
                "Deluxe", defaultPreferences));
        database.getConnections().add("6", new Connection(
                database.getStations().get("6"), database.getStations().get("7"),
                new Schedule(new Time(14, 0, new Date(1, 1, 2020)),
                        new Time(15, 0, new Date(1, 1, 2020))),
                "Deluxe", defaultPreferences));
        database.getConnections().add("7", new Connection(
                database.getStations().get("1"), database.getStations().get("8"),
                new Schedule(new Time(13, 0, new Date(1, 1, 2020)),
                        new Time(14, 0, new Date(1, 1, 2020))),
                "Deluxe", defaultPreferences));

        database.getRoutes().add("1", new Route(
                database.getStations().get("1"), database.getStations().get("7")));
        database.getRoutes().add("2", new Route(
                database.getStations().get("2"), database.getStations().get("8")));
        database.getRoutes().add("3", new Route(
                database.getStations().get("3"), database.getStations().get("9")));
        database.getRoutes().add("4", new Route(
                database.getStations().get("4"), database.getStations().get("10")));
        database.getRoutes().add("5", new Route(
                database.getStations().get("5"), database.getStations().get("1")));
        database.getRoutes().add("6", new Route(
                database.getStations().get("6"), database.getStations().get("2")));
        database.getRoutes().add("7", new Route(
                database.getStations().get("7"), database.getStations().get("3")));
        database.getRoutes().add("8", new Route(
                database.getStations().get("8"), database.getStations().get("4")));
        database.getRoutes().add("9", new Route(
                database.getStations().get("9"), database.getStations().get("5")));
        database.getRoutes().add("10", new Route(
                database.getStations().get("10"), database.getStations().get("6")));

        database.getUsers().get("1").addTrip(new Trip(database.getRoutes().get("1"),
                new Time(9, 0, new Date(1, 1, 2020)),
                new Time(15, 0, new Date(1, 1, 2020))));
        database.getUsers().get("1").addTrip(new Trip(database.getRoutes().get("2"),
                new Time(10, 0, new Date(1, 1, 2020)),
                new Time(16, 0, new Date(1, 1, 2020))));
        database.getUsers().get("1").addTrip(new Trip(database.getRoutes().get("3"),
                new Time(11, 0, new Date(1, 1, 2020)),
                new Time(17, 0, new Date(1, 1, 2020))));
        database.getUsers().get("1").addTrip(new Trip(database.getRoutes().get("4"),
                new Time(12, 0, new Date(1, 1, 2020)),
                new Time(18, 0, new Date(1, 1, 2020))));
        database.getUsers().get("1").addTrip(new Trip(database.getRoutes().get("5"),
                new Time(13, 0, new Date(1, 1, 2020)),
                new Time(19, 0, new Date(1, 1, 2020))));
        database.getUsers().get("1").addTrip(new Trip(database.getRoutes().get("6"),
                new Time(14, 0, new Date(1, 1, 2020)),
                new Time(20, 0, new Date(1, 1, 2020))));
        database.getUsers().get("2").addTrip(new Trip(database.getRoutes().get("7"),
                new Time(15, 0, new Date(1, 1, 2020)),
                new Time(21, 0, new Date(7, 1, 2020))));

        return database;
    }
}
