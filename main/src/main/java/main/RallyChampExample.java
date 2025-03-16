package main;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Our entry class
 */
public class RallyChampExample {

    //The main entry point of the program
    public static void main(String[] args) {

        //The main function has two parts: data initialization, and information printing

        // PART 1 starts here
        
        // Get singleton instance
        ChampionshipManager manager = ChampionshipManager.getInstance();
        // Registering the drivers and cars
        manager.registerDriver(new Driver("Juha Kankkunen", "Finland", new GravelCar("Subaru", "WRX STI", 330, 250)));
        manager.registerDriver(new Driver("Tommi Mäkinen", "Finland", new GravelCar("Ford", "Fiesta Rally", 290, 240)));
        manager.registerDriver(new Driver("Marcus Grönholm", "Sweden", new GravelCar("Toyota", "GR Yaris", 500, 260)));
        manager.registerDriver(new Driver("Ari Vatanen", "Sweden", new AsphaltCar("Hyundai", "i20 N", 500, 350)));
        manager.registerDriver(new Driver("Markku Alén", "Estonia", new AsphaltCar("Peugeot", "208 Rally4", 210, 250)));

        // Creating the races
        RallyRaceResult race0 = new RallyRaceResult("WRC Rally Finland", "Jyväskylä");
        RallyRaceResult race1 = new RallyRaceResult("Rallin SM-sarja", "Seinäjoki");

        // Create a list with the current drivers, and shuffle their position
        LinkedList<Driver> race0Order = new LinkedList<>(ChampionshipManager.getDriverStandings());
        Collections.shuffle(race0Order);
        int race0Multiplier = race0Order.size();

        // Recording the results based on the order in the shuffled list
        for (int i = 0; i < race0Order.size(); i++) {
            race0.recordResult(race0Order.get(i), i, race0Multiplier * 7 + (race0Multiplier--));
        }

        manager.addRaceResult(race0);

        // Repeating these steps for the other race
        LinkedList<Driver> race1Order = new LinkedList<>(ChampionshipManager.getDriverStandings());
        Collections.shuffle(race1Order);
        int race1Multiplier = race1Order.size();

        for (int i = 0; i < race1Order.size(); i++) {
            race1.recordResult(race1Order.get(i), i, race1Multiplier * 7 + (race1Multiplier--));
        }

        manager.addRaceResult(race1);

        //PART 2 starts here

        //Some fancy things
        System.out.println("«««««««««««««««««««« RALLY MANAGER »»»»»»»»»»»»»»»»»»»»");

        //Printing out all the drivers, also saving the first one
        Driver best = null;
        int counter = 1;
        for (Driver driver : ChampionshipManager.getDriverStandings()) {
            if(best == null){
                best = driver;
            }
            //The counter increments by one after the println
            System.out.println(counter++ + ": " + driver.toString());
        }

        //Printing out the best driver
        System.out.println("------------------------------\nBest driver: " + best.toString());

        //Printing general info about the championship
        System.out.println("\n«««««««««« Statistics »»»»»»»»»»\nDrivers: " + 
        ChampionshipManager.getTotalDrivers() + "\nRaces: " +  ChampionshipManager.getTotalRaces() + 
        "\nAvarage points / driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(ChampionshipManager.getDriverStandings()) + 
        "\nMost successful country: " + ChampionshipStatistics.findMostSuccessfulCountry(ChampionshipManager.getDriverStandings()) + 
        "\nTotal points combined: " + ChampionshipStatistics.calculateAveragePointsPerDriver(ChampionshipManager.getDriverStandings()) * ChampionshipManager.getTotalDrivers());

        //Printing out the races (see toString implementation)
        System.out.println("\n«««««««««« Races »»»»»»»»»»\n" + race0.toString() + "\n" + race1.toString());

        //Printing out all the cars
        System.out.println("«««««««««« Cars »»»»»»»»»»");
        for (Driver driver : ChampionshipManager.getDriverStandings()) {
            System.out.println("Car of " + driver.getName() + ": " + driver.getCar().toString());
        }
    }
}
