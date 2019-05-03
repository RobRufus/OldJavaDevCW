package robot.rally.model;

public class Pit extends GridEntity  {

	/**
	 * This is the constructor for the Pit.
	 * 
	 * @param locationX This is the Row the Pit will be placed on upon creation.
	 * @param locationY This is the Column the Pit will be placed on upon creation.
	 */
	
	public Pit(int locationX, int locationY)
	{
		super(locationX, locationY); 
	}
	
	/**
	 * This Activation method will set a specified {@link Robot}'s state to dead.
	 * 
	 * @param currentBoard This is the current {@link Board} {@link GridEntity}s lie on.
	 * @param locationX This is the Row index for the position on the {@link Board}.
	 * @param locationY This is the Column index for the position on the {@link Board}.
	 * @param updatedBoard This is the updated state of the {@link Board} after activation.
	 * @param robot This is the {@link Robot} being affected by activation of the {@link GridEntity}.
	 */
	
	public void activate(Board currentBoard,int locationX, int locationY, Board updatedBoard, Robot robot)
	{
		//override activate function in GridEntity
		robot.setState(false);
	}
	
	
}
