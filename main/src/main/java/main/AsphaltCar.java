package main;

/**
 * This is a rally car that works well on asphalt
 * 
 * @see RallyCar
 *  
 **/
public class AsphaltCar extends RallyCar {
    private double downforce;

    /**
     * Initializes a new AsphaltCar object
     * @param make The brand of the car
     * @param model The model of the car
     * @param horsepower The horsepower of the car, in whole numbers
     * @param downforce The downforce of the car, given in kilograms
     * @return A new AsphaltCar object
     */
    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce() {
        return downforce;
    }

    /**
     * Calculates the performance of the car with a mathmetical formula
     * @return A floating number indicating the performance, that can be compared to other cars.
     **/
    @Override
    public double calculatePerformance() {
        return Math.sqrt(getHorsepower() * downforce);
    }

}
