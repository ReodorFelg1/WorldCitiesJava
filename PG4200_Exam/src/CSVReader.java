import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CSVReader {
    // Reads city data from a CSV file specified by the filePath and returns an array of City objects.
    public static City[] csvCollector(String filePath) {
        try {
            // Initialize a BufferedReader to read from the CSV file.
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            // Skip the header line of the CSV.
            br.readLine();

            // Determine the number of lines in the CSV to size the array appropriately.
            int lineCount = (int) br.lines().count();
            // Close the reader to reset.
            br.close();

            // Re-open the BufferedReader to start reading from the first data line.
            br = new BufferedReader(new FileReader(filePath));
            // Skip the header line again.
            br.readLine();

            // Initialize an array to store City objects.
            City[] cities = new City[lineCount];

            // Variables for processing each line of the CSV.
            String line;
            int index = 0;

            // Read each line of CSV, create a City object, and add it to the array.
            while ((line = br.readLine()) != null) {
                // Split each line into parts using commas as the delimiter.
                String[] data = line.split(",");
                // Extract and clean city name and coordinates, then parse them.
                String name = data[0].replace("\"", "").trim();
                double latitude = Double.parseDouble(data[2].replace("\"", "").trim());
                double longitude = Double.parseDouble(data[3].replace("\"", "").trim());
                // Create a new City object and add it to the cities array.
                cities[index++] = new City(name, latitude, longitude);
            }
            // Close the BufferedReader after finishing reading.
            br.close();

            // Return the array of City objects.
            return cities;
        } catch (IOException e) {
            // Handle exceptions and print an error stack trace.
            e.printStackTrace();
            return null;
        }
    }
}
