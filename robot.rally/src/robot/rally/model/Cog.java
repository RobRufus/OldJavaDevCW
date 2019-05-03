package robot.rally.model;

/**
 * This class is used to rotate a {@link Robot} upon activation
 * 
 * @author Team18
 *
 */

public class Cog extends GridEntity  {

	Rotation rotation;
	
	/**
	 * This is the constructor for a Cog, it is given a specified {@link Rotation} direction.
	 * 
	 * @param x This is the Row the Cog will be placed on upon creation.
	 * @param y This is the Column the Cog will be placed on upon creation.
	 * @param rotation This is the direction of {@link Rotation}.
	 */
	
	public Cog(int x, int y, Rotation rotation)
{
		super(x, y);
		this.rotation = rotation;
	}

	
	/**
	 * This will rotate a specified {@link Robot} clockwise or anticlockwise based on
	 * the {@link Rotation} of the Cog.
	 * 
	 * @param currentBoard This is the current {@link Board} {@link GridEntity}s lie on.
	 * @param locationX This is the Row index for the position on the {@link Board}.
	 * @param locationY This is the Column index for the position on the {@link Board}.
	 * @param updatedBoard This is the updated state of the {@link Board} after activation.
	 * @param robot This is the {@link Robot} being affected by activation of the {@link GridEntity}.
	 */
	
	public void activate(Board currentBoard, int locationX, int locationY, Robot robot)
	{
		Direction currentDirection = robot.checkHeading(); // Local variable that holds the robots direction
		Direction newDirection = null;
			switch (rotation) { // Updates direction based on if gear is clockwise or anticlockwise
				case CLOCKWISE:
					newDirection = currentDirection.turnClockwise();
				break;
				case COUNTERCLOCKWISE:
					newDirection = currentDirection.turnCounterClockwise();
				break;
				default:
				break;
			}
		robot.setDirection(newDirection); // updates robots direction
	}
	
	
}
