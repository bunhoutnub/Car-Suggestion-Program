/**
 * The CarSuggestionProgram class provides a simple car suggestion system based on user preferences.
 * @author Bunhout(david) Nub
 * @author Daniel Wacter
 * @version 0.2(Apr 24, 2024)
 */

package WeSolveIt;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CarSuggestionProgram {
    /**
     * The main method for the car suggestion program.
     * This method initializes the program, reads user preferences, filters cars based on those preferences,
     * and displays suggestions to the user.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read cars from file
        List<Car> cars = CarDatabase.readCarsFromFile("cars.txt");
        System.out.println("\nWelcome to the Java Car Suggestion Program!");    
        // Main loop to continue program until user chooses to exit
        while (true) {
            System.out.println("\nEnter 'quit' to exit.");; // Exit if user enters 'quit'
            // Accept user preferences
            int budget = getUserInput(scanner, "Enter your budget for a new car: $");
            if (budget <= 0 ) break;
           
            System.out.print("What type of car are you interested in? (e.g., sedan, suv, hatchback, coupe...): ");
            String carType = scanner.next();
            System.out.println("Which of the following features are important to you? : ");
            System.out.println("  a. Fuel efficiency");
            System.out.println("  b. Safety features");
            System.out.println("  c. Advanced technology");
            System.out.println("  d. Performance");
            System.out.println("  e. Comfort");
            System.out.print("Enter your choice(s) (e.g., bce): ");
            String features = scanner.next();
            System.out.print("Do you have any specific brand preference? Enter brand name (e.g.,Toyota, Honda...) or type 'Any' for no preference: ");
            String brandPreferences = scanner.next();
            int passengerCount = getUserInput(scanner, "How many passengers do you typically accommodate? ");

            // Filtering cars based on user preferences
            List<Car> suggestions = filterCars(cars, budget, carType, features, brandPreferences, passengerCount);

            // Displaying suggestions
            if (!suggestions.isEmpty()) {
                System.out.println("\nBased on your preferences, here are some car recommendations:");
                for (Car car : suggestions) {
                    System.out.println(car.getName());
                    System.out.println("   - Price: $" + car.getPrice() + " (estimated)");
                    System.out.println("   - Passenger capacity: " + car.getPassengerCount());
                }
            } else {
                System.out.println("Sorry, no cars match your criteria. Please try again.");
            }
        }
        // Close the scanner to prevent resource leak
        scanner.close();
    }
    /**
     * Retrieves user input for budget and validates it.
     * @param scanner The scanner object to accept user input.
     * @param prompt The prompt message to display to the user.
     * @return The budget entered by the user, or -1 if the user chooses to quit.
     */
    private static int getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.next();
        // if the user wants to quit return -1
        if (input.equalsIgnoreCase("quit")) return -1;
        try {
            int userInput = Integer.parseInt(input);
            // check if the budget is non-positive
            if (userInput <= 0) {
                System.out.println("Budget must be a positive integer.");
                return getUserInput(scanner, prompt);
            }   
            // return budget
            return userInput;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return getUserInput(scanner, prompt);
        }
    }
    
    /**
     * Filters the list of cars based on user preferences.
     * @param cars The list of cars to filter.
     * @param budget The maximum budget set by the user.
     * @param carType The type of car preferred by the user.
     * @param features The features preferred by the user.
     * @param brandPreferences The brand preference of the user.
     * @param passengerCount The number of passengers the car should accommodate.
     * @return A list of cars that match the user's preferences.
     */
    private static List<Car> filterCars(List<Car> cars, int budget, String carType, String features, String brandPreferences, int passengerCount) {
        // Implement filtering logic based on user preferences
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            // check if the car price is within the budget
            if (car.getPrice() <= budget &&
                    // check if the car type matches user preference
                    car.getType().equalsIgnoreCase(carType) &&
                    // check if the car features and car brand match user preference
                    car.getFeatures().contains(features) &&(brandPreferences.equalsIgnoreCase("Any") || car.getBrand().equalsIgnoreCase(brandPreferences)) &&
                    // Check if car can accommodate the desired number of passengers
                    car.getPassengerCount() >= passengerCount) {
                // Add the car to the list of filtered cars
                filteredCars.add(car);
            }
        }
        // Return the filtered list of cars
        return filteredCars;
    }
}   