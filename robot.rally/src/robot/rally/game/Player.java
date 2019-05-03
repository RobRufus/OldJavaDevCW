package robot.rally.game;

/**
 * This class is used to create a player, which creates a {@link Robot} at a {@link GridEntity} and tracks how many flags are being collected.
 *
 * @author Team 18.
 */

import robot.rally.model.*;

public class Player {

	Robot robotControlling;
	int flagTracker;
	int playerID;
	private int spawnX;
	private int spawnY;
	String playerName;


	/**
	 * This is the constructor for the Player class. It creates a new {@link Robot} at a specified {@link SpawnPoint}.
	 * It is given a playerID depending upon the value of the {@link SpawnPoint}.
	 * The flagTracker is set to 1, indicating the Player must collect the first {@link Flag}.
	 * spawnX and spawnY are Fields to hold the {@link SpawnPoint} location.
	 * playerName holds the name of the playerID.
	 *
	 * @param playerID
	 * @param x
	 * @param y
	 * @param thisPlayerName
	 */

	public Player(int playerID, int x, int y, String thisPlayerName) // Needs a player ID alongside coordinates to place the robot at the spanw position
	{
		Robot robotControlling = new Robot(x, y);
		this.playerID = playerID;
		flagTracker = 1;
		spawnX = x;
		spawnY = y;
		playerName = thisPlayerName;
	}

	/**
	 * This tells the controlled {@link Robot} to perform a specific {@link Action}.
	 *
	 * @param instruction This is the specific {@link Action} the {@link Robot} will perform.
	 */

	public void instructRobot(Action instruction)
	{
		//class to allow selection of actions by user
		robotControlling.performSpecifiedAction(instruction);
	}

	/**
	 * This will return the value of the flagTracker, once 5, the game ends.
	 *
	 * @return The value of the flagTracker.
	 */

	public int getFlagTracker() {
		return flagTracker;
	}

	/**
	 * This will increase the value of the flagTracker by one.
	 */

	public void iterateFlagTracker() {
		flagTracker++;
	}

	/**
	 * This will check a given {@link Flag} to see if the ID matches the flagTracker value. If equal
	 * it will increase the flagTracker by one, otherwise nothing happens.
	 *
	 * @param flagID
	 */

	public void checkFlag(int flagID) {
		if (flagTracker == flagID) {
			iterateFlagTracker();
		} else {
			;
		}
	}

	/**
	 * This gets the value of the {@link SpawnPoint}'s X value.
	 *
	 * @return The X value of the Player's {@link SpawnPoint}.
	 */

	public int getSpawnX() {
		return spawnX;
	}

	/**
	 * This gets the value of the {@link SpawnPoint}'s Y Value.
	 *
	 * @return The X value of the Player's {@link SpawnPoint}.
	 */

	public int getSpawnY() {
		return spawnY;
	}

	/**
	 * This gets the value of the playerID.
	 *
	 * @return The playerID value.
	 */

	public int getPlayerID() {
		return playerID;
	}

	/**
	 * This sets the Player's name using a specified string.
	 *
	 * @param pName This is the name of the Player.
	 */

	public void setPlayerName(String pName)
	{
		playerName = pName;
	}

	/**
	 * This returns a specified Player's name.
	 *
	 * @param pName This is the name of the Player.
	 */

	public String getPlayerName()
	{
		return playerName;
	}

}