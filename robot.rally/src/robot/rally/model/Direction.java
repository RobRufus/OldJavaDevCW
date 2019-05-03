package robot.rally.model;

/**
 * This is an enum class that has the available directions {@link GridEntity} can face, alongside
 * methods to change direction based upon previous direction.
 * 
 * @author Team18.
 *
 */

public enum Direction { // Sets up four directions with methods that change the direction
	NORTH {
		public Direction turnClockwise() { return EAST; }
		public Direction turnCounterClockwise() { return WEST; }
	},
	EAST {
		public Direction turnClockwise() { return SOUTH; }
		public Direction turnCounterClockwise() { return NORTH; }
	},
	SOUTH {
		public Direction turnClockwise() { return WEST; }
		public Direction turnCounterClockwise() { return EAST; }
	},
	WEST {
		public Direction turnClockwise() { return NORTH; }
		public Direction turnCounterClockwise() { return SOUTH; }
	};
	
	// Abstract methods required as both methods are used in the enum classes
	
	/**
	 * This method changes the direction to the following one Clockwise.
	 * 
	 * @return This is the new direction.
	 */
	
	public abstract Direction turnClockwise();
	
	/**
	 * This method changes the direction to the following one Anticlockwise.
	 * 
	 * @return This is the new direction.
	 */
	
	public abstract Direction turnCounterClockwise();
}
