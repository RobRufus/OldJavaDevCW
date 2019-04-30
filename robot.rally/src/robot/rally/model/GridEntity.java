package robot.rally.model;


public abstract class GridEntity {

		int locationX, locationY;
		
		public GridEntity(int locationX, int locationY) 
		{
			//constructor for grid entities'
			locationX = 0;
			locationY = 0;
		}
		
		
		public void activate(Board currentBoard,int location[][], Board updatedBoard)
		{
		//activate class to be called by the simulator when going through the board
		}
		
		
}




