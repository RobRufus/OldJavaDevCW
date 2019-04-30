package robot.rally.model;

public class Cog extends GridEntity  {

	Rotation rotation;
	
	public Cog(int x, int y, Rotation rotation) {
		super(x, y);
		this.rotation = rotation;
	}

	public void activate(Robot robot)
	{
		Direction newDirection = robot.checkHeading(); // Local variable that holds the robots direction
			switch (rotation) { // Updates direction based on if gear is clockwise or anticlockwise
				case CLOCKWISE:
					newDirection.turnClockwise();
				break;
				case COUNTERCLOCKWISE:
					newDirection.turnCounterClockwise();
				break;
				default:
				break;
			}
		robot.setDirection(newDirection); // updates robots direction
	}
	
	
}
