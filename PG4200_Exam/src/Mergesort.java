public class Mergesort {
    private static int merges = 0;

    // Performs the merge sort on an array of City objects
    public static void mergeSort(City[] arr) {
        int inputLength = arr.length;

        // Base case: if the array length is less than 2, it's already sorted
        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        City[] leftArr = new City[midIndex];
        City[] rightArr = new City[inputLength - midIndex];

        // Copying elements to left and right arrays
        for (int i = 0; i < midIndex; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightArr[i - midIndex] = arr[i];
        }

        // Recursive calls to sort both halves
        mergeSort(leftArr);
        mergeSort(rightArr);

        // Merging the sorted halves
        merge(arr, leftArr, rightArr);
    }

    // Merges two sorted arrays into one sorted array
    private static void merge(City[] arr, City[] leftArr, City[] rightArr) {
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;
        int i = 0, j = 0, k = 0;

        // Merging while there are elements in both halves
        while (i < leftSize && j < rightSize) {
            if (leftArr[i].getLatitude() < rightArr[j].getLatitude() ||
                    (leftArr[i].getLatitude() == rightArr[j].getLatitude() &&
                            leftArr[i].getLongitude() <= rightArr[j].getLongitude())) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            merges++;
            k++;
        }

        // Copying remaining elements of left half, if any
        while (i < leftSize) {
            arr[k] = leftArr[i];
            merges++;
            i++;
            k++;
        }

        // Copying remaining elements of right half, if any
        while (j < rightSize) {
            arr[k] = rightArr[j];
            merges++;
            j++;
            k++;
        }
    }

    // Returns the number of merges performed during the sort
    public static int getMerges() {
        return merges;
    }

    // Resets the merge count to zero or any other specified value
    public static void setMerges(int newMerges) {
        Mergesort.merges = newMerges;
    }
}
