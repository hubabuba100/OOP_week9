package main;

/**
 * This is a rally car that works well on gravel
 * 
 * @see RallyCar
 *  
 **/
public class GravelCar extends RallyCar {
    private double suspensionTravel;
    /**
     * Initializes a new GravelCar object
     * @param make The brand of the car
     * @param model The model of the car
     * @param horsepower The horsepower of the car, in whole numbers
     * @param suspensionTravel The travel distance of the suspension, in milimeters
     * @return A new GravelCar object
     */
    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    public double getSuspensionTravel() {
        return suspensionTravel;
    }
    /**
     * Calculates the performance of the car with a mathmetical formula
     * @return A floating number indicating the performance, that can be compared to other cars.
     **/
    @Override
    public double calculatePerformance() {
        return Math.sqrt(getHorsepower() * suspensionTravel);
    }
}
