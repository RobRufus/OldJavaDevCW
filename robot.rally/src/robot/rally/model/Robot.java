package robot.rally.model;

public class Robot extends GridEntity {
	
	int robotID;
	boolean isAlive;
	Directions direcction;
	Actions action;
	Actions previousAction;
	int actionCount;
	
	
	public Robot(int locationX, int locationY)
	{
		super(locationX, locationY); 
		//constructor for robot class
	}
	
	
	
	public Directions checkHeading(Directions direction)
	{
		return new Directions();	
	}		//determines which direction the robot will move in
	
	
	public Actions performSpecifiedAction(Actions action)
	{
		return new Actions();
	}		//performs the action specified by the player
	
	
	public Directions setDirection(Directions direction)
	{
		return new Directions();
	}		//changes the direction the robot is facing
	
	
	public Actions getPrevAction()
	{
		return previousAction;
	}	//checks the last action performed so the player can't do the same one twice
	
	
	public int getActionCount()
	{
		return actionCount;
	}		//counts down the number of remaining actions the player can do
	
	
	
	

}
