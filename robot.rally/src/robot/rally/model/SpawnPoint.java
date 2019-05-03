package robot.rally.model;

/**
 * This class is used to determine where a {@link Robot} is placed upon the {@link Board} upon
 * creation of the {@link Simulator} or upon death of the {@link Robot}.
 * 
 * @author Team18.
 *
 */

public class SpawnPoint extends GridEntity  {

	int ownerID;
	
	/**
	 * This is the constructor for the SpawnPoint.
	 * 
	 * @param locationX This is the Row the Pit will be placed on upon creation.
	 * @param locationY This is the Column the Pit will be placed on upon creation.
	 */
	
	public SpawnPoint(int locationX, int locationY, int ownerID)
	{
		super(locationX, locationY); 
		this.ownerID = ownerID;
	}
	
	/**
	 * This Activation method will do nothing as the SpawnPoint does not interact with the {@link Robot} directly.
	 * 
	 * @param currentBoard This is the current {@link Board} {@link GridEntity}s lie on.
	 * @param locationX This is the Row index for the position on the {@link Board}.
	 * @param locationY This is the Column index for the position on the {@link Board}.
	 * @param updatedBoard This is the updated state of the {@link Board} after activation.
	 * @param robot This is the {@link Robot} being affected by activation of the {@link GridEntity}.
	 */
	
	public void activate(Board currentBoard, int locationX, int locationY, Board updatedBoard, Robot robot)
	{
		//override activate function in GridEntity
	}
	
	
}
