package robot.rally.model;

import org.junit.Test;

public abstract class GridEntity {

		int locationX;
		int locationY;
		
		public GridEntity(int x, int y) 
		{
			locationX = x;
			locationY = y;
		}
		
		
		public abstract void activate(Board currentBoard,int locationX, int locationY, Board updatedBoard, Robot robot);
		
		
		public int getLocationX() { // Gets X location
			return locationX;
		}
		
		public int getLocationY() { // Gets y location
			return locationY;
		}

				
}




