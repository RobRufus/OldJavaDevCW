package robot.rally.model;

import java.util.ArrayList;


public class Board {

	private ArrayList[][] board;
	
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
	

	
	
}
