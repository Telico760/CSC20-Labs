
/*
 * Brian Bracamontes
 * CSC 20 - Lab #4
 * Lab04.java
 *
 * Demonstrates importing and using classes from
 * five separate arithmetic packages.
 */

package Main;

// Import classes from the five arithmetic packages.
import add.Add;
import subtract.Subtract;
import multiply.Multiply;
import divide.Divide;
import modulo.Modulo;

public class Lab04 {

    public static void main(String[] args) {

        // Create an object for each arithmetic operation.
        // Each constructor stores two starting values.
        Add a = new Add(5, 3);
        Subtract s = new Subtract(10, 4);
        Multiply m = new Multiply(6, 3);
        Divide d = new Divide(20, 4);
        Modulo mod = new Modulo(17, 5);

        // ADDITION
        // Show the original equation, change the values,
        // and display the updated equation.
        System.out.println("----- ADDITION -----");
        System.out.println(a.toString());

        a.changeVals(4, 6);
        System.out.println(a.toString());
        System.out.println();

        // SUBTRACTION
        // Show the original and updated subtraction results.
        System.out.println("----- SUBTRACTION -----");
        System.out.println(s.toString());

        s.changeVals(9, 7);
        System.out.println(s.toString());
        System.out.println();

        // MULTIPLICATION
        // Show the original and updated multiplication results.
        System.out.println("----- MULTIPLICATION -----");
        System.out.println(m.toString());

        m.changeVals(4, 5);
        System.out.println(m.toString());
        System.out.println();

        // DIVISION
        // Use nonzero divisors to perform integer division.
        System.out.println("----- DIVISION -----");
        System.out.println(d.toString());

        d.changeVals(21, 3);
        System.out.println(d.toString());
        System.out.println();

        // MODULO
        // Display the remainder before and after changing values.
        System.out.println("----- MODULO -----");
        System.out.println(mod.toString());

        mod.changeVals(19, 4);
        System.out.println(mod.toString());

    }
}
