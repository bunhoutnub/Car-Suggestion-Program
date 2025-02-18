/**
 * The CarDatabase class provides methods to read car data from a file.
 * @author Bunhout(david) Nub
 * @author Daniel Wacter
 * @version 0.2(Apr 24, 2024)
 */
package WeSolveIt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarDatabase {
    /**
     * Reads car data from a file and creates a list of Car objects.
     * @param filename The name of the file to read from.
     * @return A list of Car objects read from the file.
     */
    public static List<Car> readCarsFromFile(String filename) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Skip the first line (header)
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts using comma as delimiter
                String[] parts = line.split(",");

                // Extract individual components from the parts array
                String name = parts[0];
                int price = Integer.parseInt(parts[1]);
                String type = parts[2];
                String features = parts[3];
                String brand = parts[4];
                int passengerCount = Integer.parseInt(parts[5]);

                // Create a new Car object using the extracted components and add it to the list
                cars.add(new Car(name, price, type, features, brand, passengerCount));
            }
        } catch (IOException | NumberFormatException e) {
            // Handle IOException (e.g., file not found) or NumberFormatException (e.g., invalid price/passenger count)
            e.printStackTrace();
        }
        // Return the list of Car objects populated from the file data
        return cars;
    }
}