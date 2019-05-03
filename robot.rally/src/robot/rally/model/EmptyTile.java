package robot.rally.model;

/**
 * This is a class used to represent an empty tile.
 * 
 * @author Team18.
 *
 */

public class EmptyTile extends GridEntity  {
	
	/**
	 * This is the constructor for an empty cell.
	 * 
	 * @param locationX This is the Row the EmptyTile will be placed on upon creation.
	 * @param locationY This is the Column the EmptyTile will be placed on upon creation.
	 */
	
	public EmptyTile(int locationX, int locationY)
	{
		super(locationX, locationY); 
	}
	
	/**
	 * This Activation method will do nothing as the EmptyTile does not interact with the {@link Robot}.
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
	
	
}
