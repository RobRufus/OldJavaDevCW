package robot.rally.game;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

import robot.rally.IO.Input;
import robot.rally.model.*;
import robot.rally.view.BoardController;


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
	private String boardData;
	
	public Simulator(int playerNumber)
	{
		//Simulator class constructor
		numOfPlayers = playerNumber;
		outputBoard = new robot.rally.IO.Output();
		playerName = new String[5];
	}

	public void generateBoard(String boardFile) throws IOException
	{
		int x=0,y=0;
		int numOfFlags = 0;
		Input input = new Input();
		//read board file
		robot.rally.IO.Input inputString = new robot.rally.IO.Input();
		boardData = inputString.readFile(boardFile);


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
				numOfFlags++;
				y++;
					break;
				case '3':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y, 3));
				numOfFlags++;
				y++;
            		break;
				case '4':  instanceOfBoard.placeEntity(x, y, new robot.rally.model.Flag(x,y, 4));
				numOfFlags++;
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
				createPlayer(input.getPlayerNames(actionText), x, y);
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


	public void stepThroughBoard() throws Exception
	{
		//activates board entities one by one after the player movement			//----------------------------needs working on

		for(int x=0; x<instanceOfBoard.getBoardLength(); x++)
		{
			for(int y=0; y<instanceOfBoard.getBoardHeight(); y++)
			{
				GridEntity entity = instanceOfBoard.getLocation(x, y).get(0);
				entity.activate(instanceOfBoard, x, y, robot);		//do the robot properly
			}
		}
		BoardController boardController = new BoardController();
		
		boardController.displayBoard(instanceOfBoard, boardData);
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


	public void flagSuccessCheck(int flagTotal)
	{
		/*checks if all the flags have been collected and displays the winner
		 * is player X along with saving to file.
		 */

		for(int y=0; y < playerArray.length ; y++)
		{
			if (playerArray[y].getFlagTracker() == flagTotal)
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
/*
	public void playerAction(String[] parts)
	{
		String[] actionsTrimmed = parts;
		for(int b = 0; b < playerArray.length; b ++)
		{
				
			for(int a = 0; a < 5; a ++)
			{
				actionsTrimmed.substring(actionsTrimmed.length
				String actionGroup = parts[a]
				for(int i = 0; i<playerArray.length;i++)
				{
					playerArray[i].instructRobot(instruction);
				}
			}
		}
*/
	}




