package robot.rally.model;

import robot.rally.model.*;

public class Conveyor extends GridEntity  {

	Direction direction;
	
	public Conveyor(int locationX, int locationY, Direction direction)
	{
		super(locationX, locationY); 
	}
	
	
	public void activate()
	{
		//override activate function in GridEntity
	}
	
	
}
