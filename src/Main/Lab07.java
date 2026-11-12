
/*
 * Brian Bracamontes
 * CSC 20 - Lab #7
 * Search vs. Sort
 *
 * This program demonstrates three algorithms:
 *
 * 1. Linear Search  - O(n)
 * 2. Selection Sort - O(n^2)
 * 3. Binary Search  - O(log n)
 *
 * Linear Search examines elements sequentially.
 * Selection Sort sorts the array in ascending order.
 * Binary Search efficiently searches a sorted array.
 */

package Main;

public class Lab07 {

    public static void main(String[] args){
        // Do NOT modify this method! This portion is provided just so you can see how I will grade the assignment.
        int[] a = {9,1,8,2,7,3,6,4,5};
        System.out.println(linearSearch(a, 0));     // This should return false
        System.out.println(linearSearch(a, 3));     // This should return true
        selectionSort(a);                           // This should sort the array
        System.out.println(binarySearch(a, 0));     // This should return -1
        System.out.println(binarySearch(a, 3));     // This should return 2 (the index of value 3 once array is sorted)
        // END OF TEST DATA
    }

    ////////////// DO ALL OF YOUR CODING BELOW THIS LINE! //////////////////////////////////


    /*
     * LINEAR SEARCH
     *
     * Searches the array one element at a time.
     *
     * Returns:
     * true  - if the value exists in the array
     * false - if the value does not exist
     *
     * Worst-case time complexity: O(n)
     */
    public static boolean linearSearch(int[] a, int value) {

        // Loop through all elements in the array.
        for (int i = 0; i < a.length; i++) {

            // Compare the current element with the target.
            if (a[i] == value) {

                // Stop immediately when a match is found.
                return true;
            }
        }

        // The search finished without finding the value.
        return false;
    }


    /*
     * SELECTION SORT
     *
     * Sorts the array in ascending order.
     *
     * Repeatedly finds the smallest value in the
     * unsorted portion and moves it to the front.
     *
     * The original array is modified directly.
     *
     * Time complexity: O(n^2)
     * Extra space complexity: O(1)
     */
    public static void selectionSort(int[] a) {

        // Move through the array, one position at a time.
        // The final element will be sorted automatically.
        for (int i = 0; i < a.length - 1; i++) {

            // Assume the current position contains
            // the smallest remaining value.
            int minIndex = i;

            // Search the remaining unsorted elements.
            for (int j = i + 1; j < a.length; j++) {

                // If a smaller value is found,
                // remember its index.
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the smallest remaining element
            // into the current sorted position.

            // Temporarily save the current element.
            int temp = a[i];

            // Move the smallest value into position i.
            a[i] = a[minIndex];

            // Move the saved value to the old
            // position of the smallest value.
            a[minIndex] = temp;
        }

        // Do not print the array here.
        // The professor requires this method to
        // modify the array without displaying it.
    }


    /*
     * BINARY SEARCH
     *
     * Searches for a value in an already sorted array.
     *
     * The search repeatedly checks the middle element
     * and eliminates half of the remaining search range.
     *
     * Returns:
     * The index of the matching element if found.
     * -1 if the value is not present.
     *
     * Worst-case time complexity: O(log n)
     */
    public static int binarySearch(int[] a, int value) {

        // Set the lower boundary of the search range.
        int low = 0;

        // Set the upper boundary of the search range.
        int high = a.length - 1;

        // Continue searching while a valid range exists.
        while (low <= high) {

            // Find the middle index of the current range.
            // This formula avoids integer overflow.
            int mid = low + (high - low) / 2;

            // Check whether the middle element is
            // equal to the requested value.
            if (a[mid] == value) {

                // Return the index of the matching value.
                return mid;
            }

            // If the target is greater than the middle
            // element, search the right half.
            if (a[mid] < value) {

                // Ignore the middle and all lower indexes.
                low = mid + 1;

            } else {

                // Otherwise, search the left half.
                // Ignore the middle and all higher indexes.
                high = mid - 1;
            }
        }

        // The search range is empty.
        // The requested value was not found.
        return -1;
    }
}
