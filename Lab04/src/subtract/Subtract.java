
/*
 * Brian Bracamontes
 * CSC 20 - Lab #4
 * Subtract.java
 *
 * Performs subtraction using two stored integer values.
 */

package subtract;

public class Subtract {

    // Private fields store the two numbers for subtraction.
    private int n1;
    private int n2;

    // Constructor initializes the two private fields.
    public Subtract(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Subtract the second number from the first.
    public int getResult() {
        return n1 - n2;
    }

    // Replace the existing values with two new numbers.
    public void changeVals(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Return a readable subtraction equation and its result.
    @Override
    public String toString() {
        return n1 + " - " + n2 + " = " + getResult();
    }
}
