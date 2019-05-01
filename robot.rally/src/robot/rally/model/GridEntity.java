package robot.rally.model;


public abstract class GridEntity {

		int locationX;
		int locationY;
		
		public GridEntity(int x, int y) 
		{
			locationX = x;
			locationY = y;
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




