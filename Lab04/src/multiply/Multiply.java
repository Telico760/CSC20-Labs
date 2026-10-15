
/*
 * Brian Bracamontes
 * CSC 20 - Lab #4
 * Multiply.java
 *
 * Performs multiplication using two stored integer values.
 */

package multiply;

public class Multiply {

    // Private fields store the two numbers for multiplication.
    private int n1;
    private int n2;

    // Constructor initializes the two private fields.
    public Multiply(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Multiply the two stored numbers.
    public int getResult() {
        return n1 * n2;
    }

    // Replace the existing values with two new numbers.
    public void changeVals(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Return a readable multiplication equation and result.
    @Override
    public String toString() {
        return n1 + " * " + n2 + " = " + getResult();
    }
}
