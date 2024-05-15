import java.util.Random;
import java.util.Scanner;

public class Terminal {
    public static void console() {
        // Path to CSV file containing city data
        String filePath = "PG4200_Exam/src/resources/worldcities.csv";
        // Loading city data from CSV file
        City[] cities = CSVReader.csvCollector(filePath);

        // Greeting and options prompt
        System.out.println("\nWelcome to Datastructures and Algorithms Examinations Program :O");
        System.out.println("Choose between 1, 2, 3 and 4 or q to quit!");

        // Scanner object to read user input
        try (Scanner scanner = new Scanner(System.in)) {
            boolean condition = true;
            while (condition) {
                // Displaying menu options
                System.out.println( "\n" +
                        "1. Print the mergesorted array with longitude and latitude values.\n" +
                        "2. Show the Time and The amount of merges when merging an unsorted array and a randomly sorted array.\n" +
                        "3. Print the quicksorted array with longitude and latitude values.\n" +
                        "4. Show the Time and The amount of comparisons when quicksorting an unsorted array and a randomly sorted array.\n" +
                        "q. Quit\n");

                System.out.print("Input Point -> ");
                String choice = scanner.next();  // Reading user choice

                switch (choice) {
                    case "1":
                        // Reset merge count and perform merge sort
                        Mergesort.setMerges(0);
                        System.out.println("\nMERGESORT: ");
                        Mergesort.mergeSort(cities);
                        // Print sorted cities
                        for (City city : cities) {
                            System.out.println(city);
                        }
                        // Reset merge count after operation
                        Mergesort.setMerges(0);
                        break;
                    case "2":
                        Mergesort.setMerges(0);

                        // Measure time and merges for sorting the unsorted array
                        long startTime = System.nanoTime();
                        Mergesort.mergeSort(cities);
                        long endTime = System.nanoTime();
                        long regularSortDuration = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

                        System.out.println("Unsorted array:");
                        System.out.println("Time: " + regularSortDuration + " ms");
                        System.out.println("Number of merges: " + Mergesort.getMerges() + "\n");

                        // Shuffle array and reset merge count for another sort
                        Mergesort.setMerges(0);
                        randomSorting(cities); // Randomizing the array

                        startTime = System.nanoTime();
                        Mergesort.mergeSort(cities);
                        endTime = System.nanoTime();
                        long randomSortDuration = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

                        System.out.println("Randomly sorted array:");
                        System.out.println("Time: " + randomSortDuration + " ms");
                        System.out.println("Number of merges: " + Mergesort.getMerges());

                        // Reset merges after completion
                        Mergesort.setMerges(0);
                        break;
                    case "3":
                        System.out.println("\nQUICKSORT: ");
                        QuickSort.quickSort(cities, 0, cities.length - 1);
                        // Print sorted cities
                        for (City city : cities) {
                            System.out.println(city);
                        }

                        // Reset comparisons and array after completion
                        QuickSort.setComparisons(0);
                        randomSorting(cities);
                        break;
                    case "4":
                        // Sort, time, and count comparisons for quicksort on unsorted array
                        QuickSort.setComparisons(0);
                        startTime = System.nanoTime();
                        QuickSort.quickSort(cities, 0, cities.length - 1);
                        endTime = System.nanoTime();
                        regularSortDuration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

                        System.out.println("Unsorted array:");
                        System.out.println("Time: " + regularSortDuration + " ms");
                        System.out.println("Number of comparisons: " + QuickSort.getNumberOfComparisons() + "\n");

                        // Reset comparisons, randomize array, and repeat quicksort for comparison
                        QuickSort.setComparisons(0);
                        randomSorting(cities);

                        startTime = System.nanoTime();
                        QuickSort.quickSort(cities, 0, cities.length - 1);
                        endTime = System.nanoTime();
                        randomSortDuration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

                        System.out.println("Randomly sorted array:");
                        System.out.println("Time: " + randomSortDuration + " ms");
                        System.out.println("Number of comparisons: " + QuickSort.getNumberOfComparisons());

                        // Reset comparisons and array after completion
                        QuickSort.setComparisons(0);
                        randomSorting(cities);
                        break;
                    case "q":
                        // Exit message and set loop condition too false to terminate
                        System.out.println("Thank you for trying our solutions, quitting.....");
                        condition = false;
                        break;
                    default:
                        // Handle invalid input
                        System.out.println("Invalid input, try again.");
                        break;
                }
            }
        }
    }

    public static void randomSorting(City[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
            // Swap elements to shuffle the array
            City a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }
}
