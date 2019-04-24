package robot.rally.game;

import java.util.ArrayList;

import org.junit.Test;

import robot.rally.model.*;

public class Simulator {

	private ArrayList[][] board;
	private Player[] playerArray;
	
	public Simulator() {

		//Simulator class constructor
	}
	
	
	
	
	@Test
	public void Main() 
	{
		
		Cog cog = new Cog();
		Conveyor conveyor = new Conveyor();
		Flag flag = new Flag();
		Pit pit = new Pit();
		Robot robot = new Robot();
		SpawnPoint spawn = new SpawnPoint();
		ArrayList[][] board = new ArrayList[5][5];
		

		//the code here itterates through the board grid and instantiates it 
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				board[i][j] = new ArrayList();
				board[i][j].add("-");
			}
		}

		
		board[0][0].set(0, cog);		//example board elements set
		board[4][4].set(0, conveyor);
		board[1][2].set(0, flag);
		board[2][3].set(0, robot);
		board[0][4].set(0, spawn);
		
		
		//creates a string to be added to so that the board can be displayed
		String toPrint = " ";
		
		//iterates through the board checking at each location for the contents
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				
				//determines what to display based on what is in the location
				if(board[i][j].get(0) instanceof Conveyor )
				{
					toPrint += ">";
				}
				else if( board[i][j].get(0) instanceof Cog )
				{
					toPrint += "+" ;
				}
				else if( board[i][j].get(0) instanceof Flag )
				{
					toPrint += "1" ;
				}
				else if( board[i][j].get(0) instanceof SpawnPoint )
				{
					toPrint += "A" ;
				}
				else if( board[i][j].get(0) instanceof Robot )
				{
					toPrint += "R" ;
				}
				else
				{
					toPrint += "." ;
				}
			
				
			}
			//every 5 locations goes onto a new line
			toPrint += " \n ";
		}
		//prints the board out to the user.
		System.out.println(toPrint);
			
	}
	
	
	
	
	public void generateBoard() 
	{
		//creates a board object at the start of the game.
	}
	
	
	public void stepThroughBoard() 
	{
		//activates board entities one by one after the player movement
	}
	
	
	public void createPlayerArray() 
	{
		// creates an array of a number of players depending on game settings
	}
	
	
	public void placePlayerSpawn() 
	{
		//adds a player spawn point using board functions
	}
	
	public void flagSuccessCheck() 
	{
		/*checks if all the flags have been collected and displays the winner 
		 * is player X along with saving to file.
		 */
	}
	
	public void deadBotCheck() 
	{
		//checks for any dead robots and sets them to be respawned.
	}
	
	
	
	
	
}