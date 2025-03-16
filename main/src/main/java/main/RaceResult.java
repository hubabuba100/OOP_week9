package main;

import java.util.List;
/**
 * An interface to use for any object representing any kind of driving race
 */
public interface RaceResult {
    /**
     * Record a result of a driver
     * @param driver The driver object whose points should be recorded
     * @param position The position in the leaderboard
     * @param points The points given to the driver
     */
    void recordResult(Driver driver, int position, int points);

    /**
     * Get the point of a single driver.
     * @param driver The Driver whose point we want to see
     * @return The amount of points that the Driver earned
     */
    int getDriverPoints(Driver driver);

    /**
     * Gets the result of the race in an ordered manner.
     * @return A list of Driver's whit their point ordered in a descending order.
     */
    List<Driver> getResults();
}
