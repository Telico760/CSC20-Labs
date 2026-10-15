
/*
 * Brian Bracamontes
 * CSC 20 - Lab #4
 * Divide.java
 *
 * Performs integer division using two stored values.
 */

package divide;

public class Divide {

    // Private fields store the dividend and divisor.
    private int n1;
    private int n2;

    // Constructor initializes the two private fields.
    public Divide(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Divide n1 by n2 and return the integer quotient.
    public int getResult() {

        // Prevent division by zero and explain the error.
        if (n2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        // Integer division discards any fractional portion.
        return n1 / n2;
    }

    // Replace the existing values with two new numbers.
    public void changeVals(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Return a readable division equation and result.
    @Override
    public String toString() {
        return n1 + " / " + n2 + " = " + getResult();
    }
}
