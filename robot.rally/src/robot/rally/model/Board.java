package robot.rally.model;

import java.util.ArrayList;


public class Board {

	
	public Board()
	{
		//private ArrayList[][] gridArray;
	}
	
	
	public ArrayList<Integer> getLocation(int location)
	{
		return new ArrayList<Integer>();	//get the entities at a specified location
	}
	
	
	public void placeEntity(int location, GridEntity putThis)
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
