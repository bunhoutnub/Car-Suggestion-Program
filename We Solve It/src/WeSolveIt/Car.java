/**
 * The Car class represents a car with various attributes such as name, price, type, features, brand, passenger count, and year.
 * @author Bunhout(david) Nub
 * @author Daniel Wacter
 * @version 0.2(Apr 24, 2024)
 */
package WeSolveIt;

class Car {
    private String name;
    private int price;
    private String type;
    private String features;
    private String brand;
    private int passengerCount;
    private static int year;
    /**
     * Constructs a car object with the given parameters.
     * @param name The name of the car.
     * @param price The price of the car.
     * @param type The type of the car (e.g., sedan, suv).
     * @param features The features of the car.
     * @param brand The brand of the car.
     * @param passengerCount The passenger count of the car.
     */
    public Car(String name, int price, String type, String features, String brand, int passengerCount) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.features = features;
        this.brand = brand;
        this.passengerCount = passengerCount;
    }

    /**
     * Retrieves the name of the car.
     * @return The name of the car.
     */
    public String getName() {
        return name;
    }
    /**
     * Retrieves the price of the car.
     * @return The price of the car.
     */
    public int getPrice() {
        return price;
    }
    /**
     * Retrieves the type of the car.
     * @return The type of the car.
     */
    public String getType() {
        return type;
    }
    /**
     * Retrieves the features of the car.
     * @return The features of the car.
     */
    public String getFeatures() {
        return features;
    }
    /**
     * Retrieves the brand of the car.
     * @return The brand of the car.
     */
    public String getBrand() {
        return brand;
    }
    /**
     * Retrieves the passenger count of the car.
     * @return The passenger count of the car.
     */
    public int getPassengerCount() {
        return passengerCount;
    }
    /**
     * Retrieves the year of the car.
     * @return The year of the car.
     */
    public int getYear(){
        return year;
    }
    /**
     * Returns a string representation of the car.
     * @return A string representation of the car.
     */
    @Override
    public String toString() {
        return name + " (Year: " + year + ")\n" +
                "   - Price: $" + price + " (estimated)\n" +
                "   - Passenger capacity: " + passengerCount;
    }

}