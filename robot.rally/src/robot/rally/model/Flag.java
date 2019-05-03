package robot.rally.model;

/** This class is used by {@link Player} to increase their Flag Tracker value in order to win the game.
* 
* @author Team18
*
*/	

public class Flag extends GridEntity  {

	int flagID;

	/**
	 * This is the constructor for the Flag. It has a given flagID based on it's value in a .brd file.
	 * 
	 * @param locationX This is the Row the Conveyer will be placed on upon creation.
	 * @param locationY This is the Column the Conveyer will be placed on upon creation.
	 * @param flagID This is the {@link Direction} of the Conveyer.
	 */
	
	public Flag(int locationX, int locationY, int flagID)
	{
		super(locationX, locationY); 
		this.flagID = flagID;
	}
	
	/**
	 * This Activation method will do nothing as the Flag does not interact with the {@link Robot} directly.
	 * 
	 * @param currentBoard This is the current {@link Board} {@link GridEntity}s lie on.
	 * @param locationX This is the Row index for the position on the {@link Board}.
	 * @param locationY This is the Column index for the position on the {@link Board}.
	 * @param updatedBoard This is the updated state of the {@link Board} after activation.
	 * @param robot This is the {@link Robot} being affected by activation of the {@link GridEntity}.
	 */
	
	public void activate(Board currentBoard, int locationX, int locationY, Robot robot)
	{
		//override activate function in GridEntity
		
	}
	
	/**
	 * This method will return the flagID for this flag.
	 * 
	 * @return The flagID as an integer.
	 */
	
	public int getFlagID() 
	{
		
		return flagID;
	}
	
	public boolean nextFlag(int flagTracker)
	{
		
		return true;	/*sets which flag is the next needed 
						to be collected when a flag is collected*/
	}
	
	
}
