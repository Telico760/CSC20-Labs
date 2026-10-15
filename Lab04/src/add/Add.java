
/*
 * Brian Bracamontes
 * CSC 20 - Lab #4
 * Add.java
 *
 * Performs addition using two stored integer values.
 */

package add;

public class Add {

    // Private fields store the two numbers for addition.
    private int n1;
    private int n2;

    // Constructor initializes the two private fields.
    public Add(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Calculate and return the sum of the stored values.
    public int getResult() {
        return n1 + n2;
    }

    // Replace the existing values with two new numbers.
    public void changeVals(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Return a readable addition equation and its result.
    @Override
    public String toString() {
        return n1 + " + " + n2 + " = " + getResult();
    }
}
