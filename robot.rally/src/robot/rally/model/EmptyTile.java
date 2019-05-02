package robot.rally.model;

public class EmptyTile extends GridEntity  {

	public EmptyTile(int locationX, int locationY)
	{
		super(locationX, locationY); 
	}
	
	public void activate(Board currentBoard, int locationX, int locationY, Board updatedBoard, Robot robot)
	{
		//override activate function in GridEntity
	}
	
	
}
