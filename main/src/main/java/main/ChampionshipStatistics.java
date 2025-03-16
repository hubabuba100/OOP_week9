package main;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * A class that provides functions for advanced championship statistics.
 */
public class ChampionshipStatistics {
    /**
     * Calculates the avarage number of points that the drivers collected.
     * @param drivers The drivers whose points should be avaraged
     * @return The avarage points per driver as a floating number.
     */
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        double res = 0; 
        for(Driver driver : drivers){
            res += driver.getPoints();
        }
        return res / drivers.size();
    }

    /**
     * Determines the most succesful country by avarageing all drivers points from the same country, and checking which country has the highest amount. 
     * If more countries have the same avarage, a random one will be returned.
     * @param drivers The drivers who should be included in the calculaton.
     * @return The name of the country with the best avarage score.
     */
    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        Map<String, Integer> countryPoints = new HashMap<String,Integer>();
        Map<String, Integer> driverCount = new HashMap<String,Integer>();
        //Adding up all points
        for (Driver driver : drivers) {
            if(!countryPoints.containsKey(driver.getCountry())){
                countryPoints.put(driver.getCountry(), driver.getPoints());
                driverCount.put(driver.getCountry(), 1);
            }
            else{
                countryPoints.put(driver.getCountry(), countryPoints.get(driver.getCountry()) + driver.getPoints());
                driverCount.put(driver.getCountry(), driverCount.get(driver.getCountry()) + 1);
            }
        }

        String result = "";
        int maxPoints = 0;
        //Calculating avarage and check best value
        for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {
            int avg = entry.getValue() / driverCount.get(entry.getKey());
            if (avg > maxPoints) {
                maxPoints = avg;
                result = entry.getKey();
            }
        }

        return result;
    }

    /**
     * Gets the number of races registered to the manager.
     * @return A integer number of the count of races registered
    */
    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}
