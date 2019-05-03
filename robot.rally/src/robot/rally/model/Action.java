package robot.rally.model;


/** 
 * Enum class holding the available Actions a {@link Robot} can perform.
 * 
 * @author Team18.
 *
 */

	public enum Action { // The actions that a robot can perform
		
	FORWARD { // Updates the location of the robot
		public void run (Robot robot) {
			Direction direction = robot.checkHeading(); // Checks which direction the robot is facing
			switch (direction) { // Depending on direction, updates location of robot.
				case NORTH:
					robot.updateLocation(-1, 0);
				break;
				case EAST:
					robot.updateLocation(0, 1);
				break;
				case SOUTH:
					robot.updateLocation(1, 0);
				break;
				case WEST:
					robot.updateLocation(0, -1);
				break;
				default:
				break;
			}
		};
	},
	
	BACKWARD { // Same as forwards but reverse effect
		public void run (Robot robot) {
			Direction direction = robot.checkHeading();
			switch (direction) {
				case NORTH:
					robot.updateLocation(-1, 0);
				break;
				case EAST:
					robot.updateLocation(0, -1);
				break;
				case SOUTH:
					robot.updateLocation(1, 0);
				break;
				case WEST:
					robot.updateLocation(0, 1);
				break;
				default:
				break;
			}
		};
	},
	
	ROTATER { // Rotates to the right (clockwise)
		public void run (Robot robot) // Takes the robot as the parameter
		{ 	Direction direction = robot.checkHeading(); // Gets the robots current direction, puts it into local variable
			Direction newDirection = direction.turnClockwise(); // Creates a variable for the new direction
			robot.setDirection(newDirection); // Sets the robots direction as the new direction
		};
	},
	
	ROTATEL { // Same as ROTATER but for counterclockwise
		public void run (Robot robot) {
			Direction  direction = robot.checkHeading();
			Direction newDirection = direction.turnCounterClockwise();
			robot.setDirection(newDirection);
		};
	},
	
	UTURN { // Performs a clockwise (or counterclockwise) rotation twice
		public void run (Robot robot) {
			Direction direction = robot.checkHeading();
			Direction rotation1 = direction.turnClockwise();
			Direction newDirection = rotation1.turnClockwise();
			robot.setDirection(newDirection);
		};
	},
	
	WAIT {
		public void run (Robot robot) {
			// assert: true;
		};
	};


		/**
		* 
		* Performs specified Action using {@link Robot} and {@link Direction} methods.
		* 
		* @param robot The robot performing the specified Action
		*/
		
public abstract void run(Robot robot);}