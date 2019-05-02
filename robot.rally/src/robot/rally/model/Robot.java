package robot.rally.model;

public class Robot extends GridEntity {
	
	int robotID;
	boolean isAlive;
	Direction direction;
	Action action;
	Action previousAction;
	int actionCount;
	
	
	public Robot(int x, int y)
	{
		super(x,y);
		direction = Direction.NORTH; // Default Direction North
		isAlive = true; // Default to being alive
		actionCount = 5; // Default amount of possible turns
	}
	
	public void activate(Board currentBoard, int locationX, int locationY, Board updatedBoard)
	{
		//override activate function in GridEntity
	}
	
	public void updateLocation(int x, int y) { // Updates location of Robot
		locationX = locationX + x;
		locationY = locationY + y;
		
	}
		
	public boolean isAlive() { // Accessor method for state of alive
		return isAlive;
	}
	
	public void setState(boolean state) { // Set robot as dead/alive
		isAlive = state;
	}
	
	public Direction checkHeading() // Gets the direction of the robot
	{
		return direction;	
	}		
	
	
	public void performSpecifiedAction(Action action) // Runs using the enum class using the specified action and current robot instance
	{
		if (getActionCount() == 0 || previousAction.equals(action)) { // Makes sure there are avaliable actions remaining/previous action isn't being used
			; // If no actions/duplicate action, do nothing
		} else {
			action.run(this); 
			actionCount--; // Reduces the actionCount by 1;
		}
		previousAction = action; // Updates previousAction
	}		
	
	
	public void setDirection(Direction newDirection)
	{
		direction = newDirection;
	}		//changes the direction the robot is facing using enum classes Direction/Rotation
	
	
	public Action getPrevAction()
	{
		return previousAction;
	}	//checks the last action performed so the player can't do the same one twice
	
	
	public int getActionCount()
	{
		return actionCount;
	}		//counts down the number of remaining actions the player can do
	
	
	

}
