package robot.rally.game;


import robot.rally.model.*;

public class Player {

	Robot robotControlling;
	int flagTracker;
	int playerID;
	
	
	public Player(int playerID, int x, int y) // Needs a player ID alongside coordinates to place the robot at the spanw position 
	{
		Robot robotControlling = new Robot(x, y);
		this.playerID = playerID;
		int flagTracker = 1;
	}
	
	
	public void instructRobot(Action instruction)
	{
		//class to allow selection of actions by user
		robotControlling.performSpecifiedAction(instruction);
	}
	
	public int getFlagTracker() {
		return flagTracker;
	}
	
	public void iterateFlagTracker() {
		flagTracker++;
	}
	
	public void checkFlag(int flagID) {
		if (flagTracker == flagID) {
			iterateFlagTracker();
		} else {
			;
		}
	}
}
