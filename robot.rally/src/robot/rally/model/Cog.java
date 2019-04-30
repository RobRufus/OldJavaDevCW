package robot.rally.model;

public class Cog extends GridEntity  {

	Rotation rotation;
	
<<<<<<< HEAD
	public Cog(int x, int y, Rotation rotation) {
		super(x, y);
		this.rotation = rotation;
	}

	public void activate(Robot robot)
=======
	public Cog(int locationX, int locationY, Rotation rotation)
	{
		super(locationX, locationY); 
	}
	
	public void activate()
>>>>>>> b0c4b18d03ef1293a3ba52ac9009dcef02ff60f2
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
