package robot.rally.model;

public class Conveyor extends GridEntity  {

	Direction direction;
	
	public Conveyor(int locationX, int locationY, Direction direction)
	{
		super(locationX, locationY); 
	}
	
	public void activate(Board currentBoard,int locationX, int locationY, Board updatedBoard, Robot robot)
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
