package robot.rally.game;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import robot.rally.model.*;


public class Simulator {

	//private ArrayList[][] board;
	private int numOfPlayers;
	private String[] playerName;
	private Robot robot;
	//private int numOfFlags;
	//creates a board object at the start of the game.
	public robot.rally.model.Board instanceOfBoard;
	public robot.rally.IO.Output outputBoard;
	//creates an array of all the players at the start of the game.
	public robot.rally.game.Player[] playerArray;

	public Simulator(int playerNumber, int flagTotal, String[] pName)
	{
		//Simulator class constructor
		numOfPlayers = playerNumber;
		outputBoard = new robot.rally.IO.Output();
		playerName = pName;
		//numOfFlags =  flagTotal;

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


	public void generateBoard(String boardFile)
	{
		int x=0,y=0;

		//read board file
		robot.rally.IO.Input inputString = new robot.rally.IO.Input();
		String boardData = inputString.readFile(boardFile);


		for (int i = 0; i < boardData.length();)		//iterates through the file string, reseting the corresponding board location when appropriate.
		{

			if (boardData.substring(i, i+1) == "/n" )		//resets grid location trackers when there is a new line
			{
				x++;
				y=0;
			}
			y++;
			i++;
		}
		instanceOfBoard = new robot.rally.model.Board(x,y);		//instanciates board using grid size calculated from the string above
		x=0; y=0;												// resets the x	y variables for the rest of the board generation process


		for (int i = 0; i < boardData.length();)		//iterates through the file string, reseting the corresponding board location when appropriate.
		{

			if (boardData.substring(i, i+1) == "/n")		//resets grid location trackers when there is a new line
			{
				x++;
				y=0;
				i++;
			}
			else
			{
				switch (boardData.charAt(i))	//iterates through finding the appropriate thing to generate based on the board location
				{

				case '1':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y, 1));
				y++;
					break;
				case '2':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y, 2));
				y++;
					break;
				case '3':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y, 3));
				y++;
            		break;
				case '4':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y, 4));
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
				case 'A':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.SpawnPoint(x,y,1));
				createPlayer(1, x, y);
				y++;
            		break;
				case 'B':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.SpawnPoint(x,y,2));
				createPlayer(2, x, y);
				y++;
            		break;
				case 'C':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.SpawnPoint(x,y,3));
				createPlayer(3, x, y);
				y++;
            		break;
				case 'D':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.SpawnPoint(x,y,4));
				createPlayer(4, x, y);
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
			}
			i++;		// moves on to the next char in the board file.
		}
			outputBoard.printBoard(instanceOfBoard);
	}


	public void stepThroughBoard()
	{
		//activates board entities one by one after the player movement			//----------------------------needs working on

		for(int x=0; x<instanceOfBoard.getBoardLength(); x++)
		{
			for(int y=0; y<instanceOfBoard.getBoardHeight(); y++)
			{
				GridEntity entity = instanceOfBoard.getLocation(x, y).get(0);
				entity.activate(instanceOfBoard, x, y, instanceOfBoard, robot);		//do the robot properly
			}
		}

	}


	public void createPlayer(int playerNum, int playerX, int playerY)
	{
		// creates an array of a number of players depending on game settings

			playerArray[playerNum-1]  = new Player(playerNum, playerX, playerY, playerName[playerNum]);
	}

	/*
	public void placePlayerSpawn(int x, int y)
	{
		//adds a player spawn point using board functions			-----unsure but i think this would only be used for random seeded boards

		//call board add spawn for player (player code)
		//instanceOfBoard.placeEntity(x, y, new robot.rally.model.SpawnPoint(x,y,"player1"));

	}
	*/

	public void flagSuccessCheck()
	{
		/*checks if all the flags have been collected and displays the winner
		 * is player X along with saving to file.
		 */

		for(int y=0; y < playerArray.length ; y++)
		{
			if (playerArray[y].getFlagTracker() == 4)
			{	try {
					outputBoard.OutToConsole(playerArray[y]);
					outputBoard.printBoard(instanceOfBoard);
					outputBoard.writeFile(playerArray[y]);
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}

	public void deadBotCheck()
	{
		Robot aRobot = new Robot(1,1);									//a robot instance to compare against

		//checks for any dead robots and sets them to be respawned.
		for(int y=0; y < playerArray.length ; y++)
		{
			if (!playerArray[y].robotControlling.isAlive())
			{
				playerArray[y].robotControlling.setState(true);
				playerArray[y].robotControlling.updateLocation(playerArray[y].getSpawnX(), playerArray[y].getSpawnY());

				for(int x=0; x<5; x++)	//5 locations checked by get adjacent, the location and the cardinal directions around it.
				{
					if ( instanceOfBoard.getAdjacent(playerArray[y].getSpawnX(), playerArray[y].getSpawnY())[x].get(1) !=  aRobot)							//bot put in first available location
					{
						instanceOfBoard.placeEntity( instanceOfBoard.getAdjacent(playerArray[y].getSpawnX(), playerArray[y].getSpawnY())[x].get(1).getLocationX(), instanceOfBoard.getAdjacent(playerArray[y].getSpawnX(), playerArray[y].getSpawnY())[x].get(1).getLocationY(), playerArray[y].robotControlling);
					}
				}
			}
		}

	}





}
