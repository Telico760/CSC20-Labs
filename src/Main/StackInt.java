/*
 * Brian Bracamontes
 * CSC 20 - Lab #5
 * Writing a Stack Implementation
 *
 * This class implements a fixed-size stack of integers
 * using an array.
 *
 * A stack follows LIFO (Last In, First Out), meaning
 * the last element added is the first one removed.
 */

package Main;

public class StackInt{
	// Fields
	private int[] a;			// Array to hold the stack items behind the scenes
	private int top;			// This is the "top" of the stack
	private final int n = 256;	// This is going to be the fixed size of the stack
	
	// Constructor: create an empty stack with room for 256 integers.
	public StackInt(){
		
		a = new int[n];
		top = 0;
	}
	
	// Add an item to the top if the stack has available space.
	public void push(int item){
		
		//Ignore the request if all 256 positions are occupied.
		if (top >= n) {
			return;
		}
		
		// Store the new item, then advance the next free index.
		a[top] = item;
		top++;
	}
	
	// Return and remove the current top element.
	public int pop(){
		
		// Do not attempt to remove an item from an empty stack.
		if (isEmpty()) {
			return -1;
		}
		
		// Decrement top to logically remove the last element.
		top--;
		
		//Return the element that was at the top.
		return a[top];
	}
	
	// Return the top element without removing it.
	public int peek(){
		
		// An empty stack has no valid top element.
		if (isEmpty()) {
			return -1;
		}
		 		
		// The last occupied index is one less than top.
		return a[top - 1];
	} 
	
	//Check whether the stack currently has any elements.
	public boolean isEmpty(){
		
		//Return true when the stack contains no elements.
		return top == 0;
	}
	
	public int size(){
		
		return top;
	}
	
	// Clear the stack without reallocating the array.
	public void clear(){
		
		top = 0;
	}
	
	// Build a readable representation of the stack elements.
	@Override
	public String toString(){
		
		// Return empty brackets when no elements exist.
		if (isEmpty()) {
			return "[]";
		}
		
		// Start the representation with an opening bracket.
		String result = "[";
		
		// Append each stored item followed by a comma.
		for (int i = 0; i < top; i++) {
			result += a[i] + ",";
		}
		
		// Remove the final unnecessary comma.
		result = result.substring(0, result.length() - 1);
		
		// Close the brackets and return the completed string.
		return result + "]";
	}
}