package main;

/**
 * The base class for other cars to be based on
 */
public abstract class RallyCar {
    private String make;
    private String model;
    private int horsepower;
    /**
     * Initializes the base class with common parameters
     * @param make The make of the car
     * @param model The model of the car
     * @param horsepower The horsepower of the car
     */
    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    /**
     * Creates a string representation of the car in the following format:
     * <pre>[Make] [Model] - [Horsepower]HP, Performance: [Performance]</pre>
     * The performnace value is calculated by the implementing class. Example output:
     * <pre>Opel Astra - 70HP, Performace: 130</pre>
     */
    @Override
    public String toString(){
        return getMake() + " " + getModel() + " - " + getHorsepower() + "HP, Performance: " + Math.round(calculatePerformance());
    }

    public abstract double calculatePerformance();
}
