package robot.rally.model;

public class Flag extends GridEntity  {

	int flagID;
	
	
	
	public void activate()
	{
		//override activate function in GridEntity
	}
	
	
	
	public boolean nextFlag(int flagTracker)
	{
		return true;	/*sets which flag is the next needed 
						to be collected when a flag is collected*/
	}
	
	
}