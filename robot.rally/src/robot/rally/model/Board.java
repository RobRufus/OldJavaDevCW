package robot.rally.model;

import java.util.ArrayList;

/**
 * This holds items on the Board.
 *
 * @author Team18.
 *
 */

public class Board {

	private ArrayList[][] board;
	private int widthX;
	private int heightY;

	/**
	 * This is the constructor for the Board. It creates a 2D Array of ArrayList objects.
	 *
	 * @param boardX This is the desired number of rows on the board.
	 * @param boardY This is the desired number of columns on the board.
	 */

	public Board(int boardX, int boardY)
	{
		//private ArrayList[][] gridArray;
		widthX = boardX;
		heightY = boardY;
		ArrayList[][] board = new ArrayList[boardX][boardY];
	}

	/**
	 * This returns the ArrayList<GridEntity> at the specified location.
	 *
	 * @param locationX This is the row index for the specified location.
	 * @param locationY This is the column index for the specified location.
	 * @return This is the ArrayList<GridEntity> at the specified location.
	 */

	public ArrayList<GridEntity> getLocation(int locationX, int locationY)
    {
        ArrayList<GridEntity> returnList = board[locationX][locationY];
        return returnList;    //get the entities at a specified location
    }

	/**
	 * This places a {@link GridEntity} into an ArrayList<GridEntity> at the specified location.
	 *
	 * @param x This is the row index for the specified location.
	 * @param y This is the column index for the specified location.
	 * @param putThis This is the GridEntity to be placed.
	 */

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

	/**
	 * This creates an Array of Objects detailing if Locations surrounding a Location are occupied. With returnList[] being the array.
	 * returnList[0] represents the specified location or centre point.
	 * returnList[1] through [5] represent objects held surrounding the centre point, going clockwise around it.
	 *
	 * @param x This is the row index for the specified location.
	 * @param y This is the column index for the specified location.
	 * @return This is an array of Objects showing if locations surrounding the specified one are occupied.
	 */

	public ArrayList<GridEntity>[] getAdjacent(int x, int y)
	{
		//finds the adjacent locations from a position so the spawn can be set
		 ArrayList[] tempGridDump = new ArrayList[5];



		ArrayList<GridEntity>[] returnList = tempGridDump;						//gaaaaaaaaaah idk
		Robot robrt = new Robot(x, y);	//robot object to check the board positions against


		returnList[0] = board[x][y];


		if (y > 0)
		{
			returnList[1] = board[x][y-1];
		}else
		{
			returnList[1] = null;
		}

		if(x+1 < widthX)
		{
		returnList[2] = board[x+1][y];
		}
		else
		{
			returnList[2] = null;
		}

		if(y+1 < heightY)
		{
			returnList[3] = board[x][y+1];
		}
		else
		{
			returnList[3] = null;
		}

		if(x-1 < 0)
		{
			returnList[4] = board[x-1][y];
		}
		else
		{
			returnList[4] = null;
		}


		return returnList;
	}

	/**
	 * This moves a specified {@link Robot} to a new location on the board.
	 *
	 * @param robot This is the {@link Robot} to be moved
	 */

	public void moveToHere(Robot robot)
	{
	//moves a grid entity to a specified place making sure to push robots as needed
	}

	/**
	 * This checks a specified {@link Robot}'s current location,
	 * and sets its state to dead if it outside the boundaries of the board.
	 *
	 * @param robot Specified {@link Robot} to be checked.
	 */

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

	/**
	 * This returns the Board Height.
	 *
	 * @return The height of the Board, or the number of Rows.
	 */

	public int getBoardHeight() {
		return heightY;
	}

	/**
	 * This returns the Board width.
	 *
	 * @return The width of the Board, or the number of columns.
	 */

	public int getBoardLength() {
		return widthX;
	}

}
