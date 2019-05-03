package robot.rally.IO;

import java.io.*;

public class Output {


	public Output()
	{
		//constructor class for Output
	}


	public void writeFile(robot.rally.game.Player player) throws IOException  //write the winning player to file on victory
	{
		FileWriter writeFile = new FileWriter("Winners.txt");

		for (int i = 0; i < 10; i++)
		{
			writeFile.write("The Winner is player" + player.getPlayerID() + " whos name is " + player.getPlayerName() + " /n" );
		}
		writeFile.close();

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
