package robot.rally.model;

/**
 * This is the Robot class that performs various actions and is interacted with using other
 * {@link GridEntity}.
 * 
 * @author Team18.
 *
 */

public class Robot extends GridEntity {
	
	int robotID;
	boolean isAlive;
	Direction direction;
	Action action;
	Action previousAction;
	int actionCount;
	
	/**
	 * This is the constructor for the Robot.
	 * 
	 * @param x This is the Row the Pit will be placed on upon creation.
	 * @param y This is the Column the Pit will be placed on upon creation.
	 */
	
	public Robot(int x, int y)
	{
		super(x,y);
		direction = Direction.NORTH; // Default Direction North
		isAlive = true; // Default to being alive
		actionCount = 5; // Default amount of possible turns
	}
	
	/**
	 * This Activation method will not have the Robot do anything as it does not interact with itself.
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
	
	/**
	 * This will update the Robot's location values which can update it's position on the {@link Board}.
	 * 
	 * @param x This is the change in Row index.
	 * @param y This is the change in Column index.
	 */
	
	public void updateLocation(int x, int y) { // Updates location of Robot
		locationX = locationX + x;
		locationY = locationY + y;
	}
	
	/**
	 * This returns the state of the Robot, if it is alive (True) or dead (False).
	 * 
	 * @return The state of the Robot in boolean form. 
	 */
	
	public boolean isAlive() { // Accessor method for state of alive
		return isAlive;
	}
	
	/**
	 * This changes the state of the Robot to being alive (True) or dead (False).
	 * 
	 * @param state This is the new state of the Robot in boolean form. 
	 */
	
	public void setState(boolean state) { // Set robot as dead/alive
		isAlive = state;
	}
	
	/**
	 * This returns the {@link Direction} in which the Robot is facing. 
	 * 
	 * @return The {@link Direction} the Robot is facing.
	 */
	
	public Direction checkHeading() // Gets the direction of the robot
	{
		return direction;	
	}		
	
	/**
	 * This performs a specific {@link Action} and reduced the Robot's action count by 1. It also sets the previousAction as the
	 * specified {@link Action} so it can not be repeated once called again. When called, it makes sure
	 * there are actions remaining and there is no duplicate {@link Action} being done before
	 * performing the {@link Action}.
	 * 
	 * @param action This is the specific {@link Action} the Robot will perform.
	 */
	
	public void performSpecifiedAction(Action action) // Runs using the enum class using the specified action and current robot instance
	{
		if (getActionCount() == 0 || previousAction.equals(action)) { // Makes sure there are available actions remaining/previous action isn't being used
			; // If no actions/duplicate action, do nothing
		} else {
			action.run(this); 
			actionCount--; // Reduces the actionCount by 1;
		}
		previousAction = action; // Updates previousAction
	}		
	
	/**
	 * This changes the Robot's {@link Direction} to a specified one.
	 * 
	 * @param newDirection This is the specified new {@link Direction} for the Robot. 
	 */
	
	public void setDirection(Direction newDirection)
	{
		direction = newDirection;
	}	
	
	/**
	 * This method returns the previously used {@link Action}.
	 * 
	 * @return The previously used {@link Action}.
	 */
	
	public Action getPrevAction()
	{
		return previousAction;
	}	//checks the last action performed so the player can't do the same one twice
	
	/**
	 * This method returns the {@link Action} count.
	 * 
	 * @return The number of actions remaining. 
	 */
	
	public int getActionCount()
	{
		return actionCount;
	}		//counts down the number of remaining actions the player can do
	
	
	

}
