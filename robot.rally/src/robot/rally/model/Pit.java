package robot.rally.model;

public class Pit extends GridEntity  {

	
	public Pit(int locationX, int locationY)
	{
		super(locationX, locationY); 
	}
	
	public void activate(Robot robot) // Receives a robot, sets the Robot's state to dead
	{
		robot.setState(false);
	}
	
	
}
