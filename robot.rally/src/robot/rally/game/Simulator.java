package robot.rally.game;

import java.util.ArrayList;

import org.junit.Test;

import robot.rally.model.*;


public class Simulator {

	private ArrayList[][] board;
	private Player[] playerArray;
	
	//creates a board object at the start of the game.
	public robot.rally.model.Board instanceOfBoard;
	
	public Simulator() {

		//Simulator class constructor
		instanceOfBoard = new robot.rally.model.Board();

	}
	
	/*
	
	
	@Test
	public void Main() 
	{
		
		Cog cog = new Cog(+);
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

		
		//board[0][0].set(0, cog);		//example board elements set
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
	
	*/
	
	
	public void generateBoard() 
	{


		//read board file
		robot.rally.IO.Input inputString = new robot.rally.IO.Input();
		String boardData = inputString.readBoardFile("conveyor-loops.brd");
		
		

		for (int i = 0; i < boardData.length();)		//iterates through the file string, reseting the corresponding board location when appropriate.
		{
			int x=0,y=0;
			
			
			if (boardData.substring(i, i+1) == "/n" )		//resets grid location trackers when there is a new line
			{	
				x++;
				instanceOfBoard.setBoardHeight(x); // When new line is added, set board height equal to number of lines
				instanceOfBoard.setBoardLength(y); // Updates board length to number of characters before new line
				y=0;
			}
			
			switch (boardData.charAt(i))	//iterates through finding the appropriate thing to generate based on the board location
			{
			
			case '1':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y,1));		
			y++;
            	break;
			case '2':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y,2));		
			y++;
            	break;
			case '3':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y,3));		
			y++;
            	break;
			case '4':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y,4));		
			y++;
            	break;
			case '+':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Cog(x,y,Rotation.CLOCKWISE));		
			y++;
            	break;
			case '-':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Cog(x,y,Rotation.COUNTERCLOCKWISE));		
			y++;
            	break;
			case 'x':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Pit(x,y));		
			y++;
            	break;
			case 'A':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.SpawnPoint(x,y,"A"));		
			y++;
            	break;
			case 'B':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.SpawnPoint(x,y,"B"));		
			y++;
            	break;
			case 'C':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.SpawnPoint(x,y,"C"));		
			y++;
            	break;
			case 'D':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.SpawnPoint(x,y,"D"));		
			y++;
        		break;
			case '<':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Conveyor(x,y,Direction.WEST));		
			y++;
        		break;
			case '>':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Conveyor(x,y,Direction.EAST));			
			y++;
        		break;
			case '^':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Conveyor(x,y,Direction.NORTH));			
			y++;
        		break;
			case 'v':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Conveyor(x,y,Direction.SOUTH));			
			y++;
				break;
			default :  instanceOfBoard.placeEntity(x, y, new robot.rally.model.EmptyTile(x,y));			
			y++;

			}
			 i++;		// moves on to the next char in the board file.
		}
		
		

	}
	
	
	public void stepThroughBoard() 
	{
		//activates board entities one by one after the player movement			//----------------------------needs working on

		/*
		
		for(int i=0; i<instanceOfBoard.length; i++) 
		{
			for(int j=0; j<instanceOfBoard[i].length; j++) 
			{
				instanceOfBoard.getLocation(i, j);		
				
				
				
			}
		}
	
		*/
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
