// Brian Bracamontes

package Main;

// Interface containing abstract method prototypes.
// Any class implementing this interface must provide these methods.
interface RobotMovement {
	
	void moveForward();
	
	void turnLeft();
	
}

// Interface containing a default method.
// A default method already has an implementation that implementing classes can use.
interface RobotStatus {
	default void displayStatus() {
		System.out.println("Robot status: Online");
	}
}

// Interface containing a static method.
// Static interface methods belong to the interface itself.
interface RobotUtility {
	
	static void displayManufacturer() {
		System.out.println("Robot manufacturer: BB Robotics");
	}
	
}

// Lab03 implements all 3 interfaces.
public class Lab03 implements RobotMovement, RobotStatus, RobotUtility {

	//Implement the  moveForward method required by RobotMovement.
	@Override
	public void moveForward() {
		System.out.println("The robot moves forward.");
	}
	
	//Implement the turnLeft method required by RobotMovement.
	@Override
	public void turnLeft() {
		System.out.println("The robot turns left.");
	}
	
	public static void main(String[] args) {
		
		// Create Lab03 object so the program can call its instance methods.
		Lab03 robot = new Lab03();
		
		// Call the methods implemented from the RobotMovement interface.
		robot.moveForward();
		robot.turnLeft();
		
		// Call the default method inherited from the RobotStatus interface.
		robot.displayStatus();
		
		// Call the static method directly through its interface name.
		RobotUtility.displayManufacturer();
		
	}

}
