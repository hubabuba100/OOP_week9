package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An object to store the results of rally races
 * @see RaceResult
 */
public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;
    /**
     * Initializes a new RallyRaceResult object.
     * @param raceName The name of the race
     * @param location The location of the code
     */
    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        // Create a copy of the driver, so we only store the result of this competition
        // only
        Driver tmp = new Driver(driver.getName(), driver.getCountry(), driver.getCar());

        // Add the earned points
        tmp.addPoints(points);
        results.put(tmp, position);
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return driver.getPoints();
    }

    @Override
    public List<Driver> getResults() {
        List<Driver> standings = new ArrayList<>(results.keySet());
        Collections.sort(standings, new Comparator<Driver>() {
            @Override
            public int compare(Driver d1, Driver d2) {
                return Integer.compare(d2.getPoints(), d1.getPoints());
            }
        });
        return standings;
    }

    @Override
    public String toString() {
        String res = "- Race: " + getRaceName() + " (" + getLocation() + ")\n";
        int counter = 1;
        for (Driver driver : getResults()) {
            res += "Position " + counter++ + ": " + driver.toString() + "\n";
        }
        return res;
    }
}
