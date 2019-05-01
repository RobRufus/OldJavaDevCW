package robot.rally.model;

import java.util.ArrayList;


public class Board {

	private ArrayList[][] board;
	private int boardLength; // To determine boardLength
	private int boardHeight; // To determine boardHeight
	
	public Board()
	{
		//private ArrayList[][] gridArray;
		ArrayList[][] board = new ArrayList[10][];				//---------im pretty sure this needs to be fixed at some point i dont understand it
	}
	
	
	public ArrayList<Integer> getLocation(int locationX, int locationY)
	{
		return new ArrayList<Integer>();	//get the entities at a specified location
	}
	
	
	public void placeEntity(int x, int y, GridEntity putThis)
	{
		//puts a specified new entity at a specified location
	}
	
	
	public int getAdjacent(int location)
	{
		return 1;	//finds the adjacent locations from a position so the spawn can be set 
	}
	
	
	public void moveToHere(Robot robot)
	{
	//moves a grid entity to a specified place making sure to push robots as needed
	}
	
	public void checkRobotLocation(Robot robot) {
		// Will check if a robot remains in the bounds of the board, setting it to dead if not 
		// Checks if robots X location is outside the height boundaries.
		
		if (robot.getLocationX() < 0 || robot.getLocationX() > boardHeight) {
			robot.setState(false);
		} else {
			;
		}
		
		// Checks if robot Y location is outside the length boundaries
		
		if (robot.getLocationY() < 0 || robot.getLocationY() > boardLength) {
			robot.setState(false);
		} else {
			;
		}
	}
	
	public void setBoardLength(int length) {
		boardLength = length;
	}
	
	public int getBoardLength() {
		return boardLength;
	}
	
	public void setBoardHeight(int height) {
		boardHeight = height;
	}
	
	public int getBoardHeight() {
		return boardHeight;
	}
}
