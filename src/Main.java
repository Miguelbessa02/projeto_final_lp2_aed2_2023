import controllers.DataInitializer;
import db.Database;
import edu.princeton.cs.algs4.Date;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database;

        database = DataInitializer.InitData();

        System.out.println("Get Routes By User And Period");
        database.getRoutesByUserAndPeriod("1",
                new Time(9, 0, new Date(1, 1, 2020)),
                new Time(20, 0, new Date(1, 1, 2020))).forEach(System.out::println);

        System.out.println("*".repeat(20));

        System.out.println("Get Unused Stations By Period");
        database.getUnusedStationsByPeriod("1",
                new Time(9, 0, new Date(1, 1, 2020)),
                new Time(15, 0, new Date(1, 1, 2020))).forEach(System.out::println);

        System.out.println("*".repeat(20));

        System.out.println("Get Users By Route And Period");
        List<Station> stations = new ArrayList<>();
        stations.add(database.getStations().get("1"));
        stations.add(database.getStations().get("2"));
        stations.add(database.getStations().get("3"));
        database.getUsersByRouteAndPeriod(stations,
                new Time(9, 0, new Date(1, 1, 2020)),
                new Time(20, 0, new Date(1, 1, 2020))).forEach(System.out::println);

        System.out.println("*".repeat(20));

        System.out.println("Get Top Users By Stations And Period");
        database.getTopUsersByStationsAndPeriod(new Time(9, 0, new Date(1, 1, 2020)),
                new Time(20, 0, new Date(1, 1, 2020))).forEach(System.out::println);

        System.out.println("*".repeat(20));

        System.out.println("Get Connection Schedule");
        database.getConnectionSchedule("Paris", "Lyon").forEach(System.out::println);

        System.out.println("*".repeat(20));

        System.out.println("-----------------------SYSTEM REPORT-----------------------");
        database.generateSystemReport();

        System.out.println("*".repeat(20));

        System.out.println("DAILY USAGE OF STATIONS");
        database.listDailyUsageFrequency(new Date(1, 1, 2020));

        System.out.println("*".repeat(20));

        System.out.println("WEEKLY USAGE OF STATIONS");
        database.listWeeklyUsageFrequency(new Date(1, 1, 2020), new Date(2, 1, 2020));

    }
}