package robot.rally.model;

import org.junit.Test;

public abstract class GridEntity {

<<<<<<< HEAD
		int locationX;
		int locationY;
		
		public GridEntity(int x, int y) 
		{
			locationX = x;
			locationY = y;
=======
		int locationX, locationY;
		
		public GridEntity(int locationX, int locationY) 
		{
			//constructor for grid entities'
			locationX = 0;
			locationY = 0;
>>>>>>> b0c4b18d03ef1293a3ba52ac9009dcef02ff60f2
		}
		
		
		public void activate(Board currentBoard,int locationX, int locationY, Board updatedBoard)
		{
		//activate class to be called by the simulator when going through the board
		}
		
		
		public int getLocationX() { // Gets X location
			return locationX;
		}
		
		public int getLocationY() { // Gets y location
			return locationY;
		}

				
}




