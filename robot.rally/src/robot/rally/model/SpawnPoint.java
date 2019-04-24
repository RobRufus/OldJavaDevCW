package robot.rally.model;

public class SpawnPoint extends GridEntity  {

	int ownerID;
	
	
	
	public void activate()
	{
		//override activate function in GridEntity
	}
	
	
	public int getID(int owningPlayerID)
	{
		return 1;	//returns player ID
	}
	
	
}
