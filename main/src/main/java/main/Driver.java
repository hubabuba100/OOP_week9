package main;

public class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    /**
     * Initializes an instance of the Driver class
     * @param name The name of the driver
     * @param country The country of the driver
     * @param car The car that the driver uses
     */
    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPoints() {
        return points;
    }

    public RallyCar getCar() {
        return car;
    }

    public void setCar(RallyCar car) {
        this.car = car;
    }

    /**
     * Adds points to the driver's current point count.
     * @param points Number of points to add to the driver
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Returns a string representation of the Driver in the following format: <br/>
     * <pre>[Name] ([Country]) - [Points] points</pre>
     * Example:
     * <pre>John Smith (United Kingdom) - 32 points</pre>
     */
    @Override
    public String toString(){
        return name + " (" + country + ") - " +  points + " points";
    }
}
