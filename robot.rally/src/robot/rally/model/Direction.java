package robot.rally.model;

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
	public abstract Direction turnClockwise();
	public abstract Direction turnCounterClockwise();
}
