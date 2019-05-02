package robot.rally.model;

public class Pit extends GridEntity  {

	
	public Pit(int locationX, int locationY)
	{
		super(locationX, locationY); 
	}
	
	public void activate(Board currentBoard,int locationX, int locationY, Board updatedBoard)
	{
		//override activate function in GridEntity
	}
	
	
}
