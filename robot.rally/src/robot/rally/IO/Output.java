package robot.rally.IO;

import java.io.*;

public class Output {


	public Output()
	{
		//constructor class for Output
	}


	public void writeFile()
	{
		//writes the player name to file upon victory
	}


	public void OutToConsole(robot.rally.game.Player player)
	{
		//prints out to console on victory
		System.out.print("The Winner is player" + player.getPlayerID());
	}

	public void printBoard(robot.rally.model.Board prntme) //this will almost definatly not work in its current state haha ;-;
	{
		//prints out the board
		System.out.print(prntme);
	}

}
