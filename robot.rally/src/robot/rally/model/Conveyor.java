package robot.rally.model;

public class Conveyor extends GridEntity  {

	/** This class is used to move a {@link Robot} in a specific direction upon activation.
	* 
	* @author Team18
	*
	*/	
	
	Direction direction;
	
	/**
	 * This is the constructor for the Conveyer. It has a predetermined {@link Direction}.
	 * 
	 * @param locationX This is the Row the Conveyer will be placed on upon creation.
	 * @param locationY This is the Column the Conveyer will be placed on upon creation.
	 * @param direction This is the {@link Direction} of the Conveyer.
	 */
	
	public Conveyor(int locationX, int locationY, Direction direction)
	{
		super(locationX, locationY); 
	}
	
	/**
	 * This will move a specified {@link Robot} based on
	 * the {@link Direction} of the Conveyer. It will check to see if the new location is occupied by a {@link Robot}
	 * before it is moved. 
	 * 
	 * @param currentBoard This is the current {@link Board} {@link GridEntity}s lie on.
	 * @param locationX This is the Row index for the position on the {@link Board}.
	 * @param locationY This is the Column index for the position on the {@link Board}.
	 * @param updatedBoard This is the updated state of the {@link Board} after activation.
	 * @param robot This is the {@link Robot} being affected by activation of the {@link GridEntity}.
	 */
	
	public void activate(Board currentBoard,int locationX, int locationY, Robot robot)
	{
		//override activate function in GridEntity
		Direction dir = robot.checkHeading();
		switch(dir)
		{
			case NORTH:
				if(currentBoard.getLocation(locationX, locationY+1).get(1) == null ) //need way to see if board spot is occupied by robot ONLY, not empty tile
					robot.updateLocation(0, 2);
			case SOUTH:
				if(currentBoard.getLocation(locationX, locationY-1).get(1) == null)
					robot.updateLocation(0, -2);
			case EAST:
				if(currentBoard.getLocation(locationX+1, locationY).get(1) == null)
					robot.updateLocation(2, 0);
			case WEST:
				if(currentBoard.getLocation(locationX-1, locationY+1).get(1) == null)
					robot.updateLocation(2, 0);
		}				
	}
	
	
}
