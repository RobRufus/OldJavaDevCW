package robot.rally.model;

public class SpawnPoint extends GridEntity  {

	String ownerID;
	
	
	public SpawnPoint(int locationX, int locationY, String ownerID)
	{
		super(locationX, locationY); 
	}
	
	
	public void activate(Board currentBoard, int locationX, int locationY, Board updatedBoard)
	{
		//override activate function in GridEntity
	}
	
	
	public int getID(String owningPlayerID)
	{
		return 1;	//returns player ID
	}
	
	
}
