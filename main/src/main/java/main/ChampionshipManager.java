package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A singleton class, that manages all data related to the championship
 **/
public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    /**
     * Gets the instance of the singleton. If it does not exists currently, it will create a new instance.
     * @return The instance of the singleton
     **/
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    /**
     * Registers a new driver to the competition.
     * @param driver The driver to be registered
     */
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    /**
     * Registers a new race result to the state.
     * The drivers points will be updated according to the input results.
     * @param result The race result to be registered
     */
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
        for (Driver driver : result.getResults()) {
            for (Driver existingDriver : drivers) {
                if (driver.getName().equals(existingDriver.getName())) {
                    existingDriver.addPoints(driver.getPoints());
                }
            }
        }   
    }

    /**
     * Gets the currently registered drivers in a list
     * @return A list of the drivers ordered by their points in descending order.
     */
    public static List<Driver> getDriverStandings() {
        List<Driver> standings = new ArrayList<>(getInstance().drivers);
        Collections.sort(standings, new Comparator<Driver>() {
            @Override
            public int compare(Driver d1, Driver d2) {
                return Integer.compare(d2.getPoints(), d1.getPoints());
            }
        });
        return standings;
    }
    /**
     * Gets the driver with the highest point. If two or more drivers have the same amount of points, one will be randomly selected.
     * @return The driver with the highest amount of points
     */
    public static Driver getLeadingDriver() {
        return getDriverStandings().get(0);
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public static int getTotalRaces(){
        return totalRaces;
    }
    /**
     * Gets all the points handed out in all races
     * @return An intiger number with all the scores summed
     */
    public static int getTotalChampionshipPoints() {
        int res = 0;
        for (Driver driver : getInstance().drivers) {
            res += driver.getPoints();
        }
        return res;
    }
}
