
/*
 * Brian Bracamontes
 * CSC 20 - Lab #4
 * Modulo.java
 *
 * Calculates the remainder after integer division.
 */

package modulo;

public class Modulo {

    // Private fields store the two numbers for modulo.
    private int n1;
    private int n2;

    // Constructor initializes the two private fields.
    public Modulo(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Return the remainder after dividing n1 by n2.
    public int getResult() {

        // A zero divisor is not allowed for modulo.
        if (n2 == 0) {
            throw new ArithmeticException("Cannot use modulo with zero.");
        }

        // The percent operator calculates the remainder.
        return n1 % n2;
    }

    // Replace the existing values with two new numbers.
    public void changeVals(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Return a readable modulo equation and result.
    @Override
    public String toString() {
        return n1 + " % " + n2 + " = " + getResult();
    }
}
