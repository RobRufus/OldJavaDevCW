package robot.rally.model;

import robot.rally.model.*;

public class Conveyor extends GridEntity  {

	Directions direction;
	
	public Conveyor(int locationX, int locationY, Directions direction)
	{
		super(locationX, locationY); 
	}
	
	
	public void activate()
	{
		//override activate function in GridEntity
	}
	
	
}
