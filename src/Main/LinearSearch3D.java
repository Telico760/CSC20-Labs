
/*
 * Brian Bracamontes
 * CSC 20 - Linear Search Program for a 3D Array
 *
 * This program allows a user to search for integers
 * stored inside a three-dimensional array.
 *
 * Features:
 * 1. Creates a 3D array containing sample data.
 * 2. Displays the available values by layer.
 * 3. Allows the user to search for any integer.
 * 4. Uses three nested loops to perform a linear search.
 * 5. Displays the location of the first matching value.
 * 6. Reports when a value is not found.
 * 7. Handles invalid input without crashing.
 * 8. Allows repeated searches until the user quits.
 */

package Main;

// Import Scanner to read keyboard input.
import java.util.Scanner;

public class LinearSearch3D {

    public static void main(String[] args) {

        // STEP 1: Create a three-dimensional integer array.
        // This array has 2 layers, 2 rows per layer,
        // and 3 columns per row.
        int[][][] numbers = {
            {
                {4, 8, 12},
                {16, 20, 24}
            },
            {
                {3, 6, 9},
                {1, 15, 18}
            }
        };

        // STEP 2: Create a Scanner to read user input.
        Scanner input = new Scanner(System.in);

        // STEP 3: Display the program's introduction.
        System.out.println("=====================================");
        System.out.println("       3D ARRAY LINEAR SEARCH");
        System.out.println("=====================================");

        System.out.println("\nAvailable array values:");

        // Display each layer of the 3D array.
        for (int layer = 0; layer < numbers.length; layer++) {

            System.out.println("\nLayer " + layer + ":");

            // Display each row in the current layer.
            for (int row = 0; row < numbers[layer].length; row++) {

                // Display each value in the current row.
                for (int col = 0; col < numbers[layer][row].length; col++) {

                    // Use tabs to separate the columns.
                    System.out.print(numbers[layer][row][col] + "\t");
                }

                // Move to the next line after each row.
                System.out.println();
            }
        }

        // Explain the program to the user.
        System.out.println("\nYou can search for any whole number.");
        System.out.println("If the number exists, its location will be displayed.");
        System.out.println("If it does not exist, you can try again.");

        // STEP 4: Repeat searches until the user chooses to quit.
        while (true) {

            // Ask the user to enter a number or quit.
            System.out.print("\nEnter a whole number to search for (or Q to quit): ");

            // Read the entire input line and remove extra spaces.
            String userInput = input.nextLine().trim();

            // Check if the user wants to exit the application.
            if (userInput.equalsIgnoreCase("q")) {

                System.out.println(
                    "\nThank you for using the 3D Array Linear Search!"
                );

                // Exit the while loop and finish the program.
                break;
            }

            // STEP 5: Validate and convert the user's input.
            int target;

            try {

                // Convert the entered String into an integer.
                target = Integer.parseInt(userInput);

            } catch (NumberFormatException e) {

                // Handle text, decimals, or out-of-range integers.
                System.out.println(
                    "Invalid input. Please enter a whole number or Q to quit."
                );

                // Skip the search and ask for another input.
                continue;
            }

            // STEP 6: Initialize the search variables.

            // Assume the target has not been found yet.
            boolean found = false;

            // Store the location of the matching element.
            // -1 represents an unknown or invalid index.
            int foundLayer = -1;
            int foundRow = -1;
            int foundColumn = -1;

            // STEP 7: Perform a linear search using nested loops.

            // Outer loop: search through every layer.
            for (int layer = 0; layer < numbers.length && !found; layer++) {

                // Middle loop: search through every row.
                for (int row = 0; row < numbers[layer].length && !found; row++) {

                    // Inner loop: check every column in the row.
                    for (int col = 0; col < numbers[layer][row].length; col++) {

                        // Compare the current value with the target.
                        if (numbers[layer][row][col] == target) {

                            // Mark the target as found.
                            found = true;

                            // Save the matching array indexes.
                            foundLayer = layer;
                            foundRow = row;
                            foundColumn = col;

                            // Exit the innermost loop.
                            // The !found conditions stop the other loops.
                            break;
                        }
                    }
                }
            }

            // STEP 8: Display the search result.

            if (found) {

                // Inform the user that a match was found.
                System.out.println(
                    "\nValue " + target + " was found!"
                );

                // Display the exact three-dimensional location.
                System.out.println(
                    "Location: Layer " + foundLayer +
                    ", Row " + foundRow +
                    ", Column " + foundColumn
                );

            } else {

                // Inform the user that no matching value exists.
                System.out.println(
                    "\nValue " + target + " was not found in the array."
                );
            }

            // The while loop automatically repeats here.
        }

        // STEP 9: Close the Scanner when the user quits.
        input.close();
    }
}
