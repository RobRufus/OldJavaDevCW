package robot.rally.model;

import java.util.ArrayList;


public class Board {

	private ArrayList[][] board;
	private int widthX;
	private int heightY;
	
	public Board(int boardX, int boardY)
	{
		//private ArrayList[][] gridArray;
		widthX = boardX;
		heightY = boardY;
		ArrayList[][] board = new ArrayList[boardX][boardY];
	}
	
	
	public ArrayList<GridEntity> getLocation(int locationX, int locationY)
    {
        ArrayList<GridEntity> returnList = board[locationX][locationY];
        return returnList;    //get the entities at a specified location
    }
	
	
	public void placeEntity(int x, int y, GridEntity putThis)
	{
		
		//checks to see if there's anything in that space
		if( getLocation(x,y).size() > 0 )
		{
			//puts a specified new entity at a specified location
			board[x][y].add(1, putThis);
		} else
		{
			//puts a specified new entity at a specified location
			board[x][y].add(0, putThis);
		}

	}
	
	
	public Object[] getAdjacent(int x, int y)
	{
		//finds the adjacent locations from a position so the spawn can be set 
		Object[] returnList = new Object[5];
		Robot robot = new Robot(x, y);	//robot object to check the board positions against
		

		returnList[0] = board[x][y].get(0);

		
		if (y > 0)
		{
			returnList[1] = board[x][y-1].get(0);
		}else
		{
			returnList[1] = null;
		}
		
		if(x+1 < widthX)
		{
		returnList[2] = board[x+1][y].get(0);
		}
		else
		{
			returnList[2] = null;
		}
		
		if(y+1 < heightY)
		{
			returnList[3] = board[x][y+1].get(0);
		}
		else
		{
			returnList[3] = null;
		}

		if(x-1 < 0)
		{
			returnList[4] = board[x-1][y].get(0);
		}
		else
		{
			returnList[4] = null;
		}
		
		
		return returnList;
	}
	
	
	public void moveToHere(Robot robot)
	{
	//moves a grid entity to a specified place making sure to push robots as needed
	}
	
	
	
	public void checkRobotLocation(Robot robot) {
		// Will check if a robot remains in the bounds of the board, setting it to dead if not 
		// Checks if robots X location is outside the height boundaries.
		
		if (robot.getLocationX() < 0 || robot.getLocationX() > widthX) {
			robot.setState(false);
		} else {
			;
		}
		
		// Checks if robot Y location is outside the length boundaries
		
		if (robot.getLocationY() < 0 || robot.getLocationY() > heightY) {
			robot.setState(false);
		} else {
			;
		}
	}
	
	
	
	
	

	public int getBoardHeight() {
		return heightY;
	}
	
	public int getBoardLength() {
		return widthX;
	}
	
}
