package robot.rally.game;


import robot.rally.model.*;

public class Player {

	Robot robotControlling;
	int flagTracker;
	int playerID;
	private int spawnX;
	private int spawnY;
	String playerName;


	public Player(int playerID, int x, int y, String thisPlayerName) // Needs a player ID alongside coordinates to place the robot at the spanw position
	{
		Robot robotControlling = new Robot(x, y);
		this.playerID = playerID;
		flagTracker = 1;
		spawnX = x;
		spawnY = y;
		playerName = thisPlayerName;
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

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerName(String pName)
	{
		playerName = pName;
	}

}