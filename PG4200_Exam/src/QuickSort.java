public class QuickSort {
    private static int comparisons = 0;

    // Performs the Quicksort algorithm on an array of City objects.
    public static void quickSort(City[] arr, int low, int high) {
        while (low < high) {
            int partitionIndex;
            // Partitions the array and determines the pivot's final position.
            partitionIndex = partition(arr, low, high);

            // Tail recursion optimization to minimize stack usage.
            if (partitionIndex - low < high - partitionIndex) {
                quickSort(arr, low, partitionIndex - 1);
                low = partitionIndex + 1;
            } else {
                quickSort(arr, partitionIndex + 1, high);
                high = partitionIndex - 1;
            }
        }
    }

    // Partitions the array around a pivot selected from the array elements.
    public static int partition(City[] arr, int low, int high) {
        City pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            // Increment comparison count for each comparison made
            comparisons++;

            // Compare elements based on latitude, and if equal, then by longitude.
            if (arr[j].getLatitude() < pivot.getLatitude() ||
                    (arr[j].getLatitude() == pivot.getLatitude() && arr[j].getLongitude() <= pivot.getLongitude())) {
                i++;
                // Swap arr[i] and arr[j]
                City tempSwap = arr[i];
                arr[i] = arr[j];
                arr[j] = tempSwap;
            }
        }

        // Swap the pivot into its correct position in the sorted array.
        City tempSwap = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tempSwap;

        // Return the pivot's final position
        return i + 1;
    }

    // Returns the total number of comparisons made during the sorting process.
    public static int getNumberOfComparisons() {
        return comparisons;
    }

    // Resets the comparison count to a specified value.
    public static void setComparisons(int newComparisons) {
        QuickSort.comparisons = newComparisons;
    }
}

