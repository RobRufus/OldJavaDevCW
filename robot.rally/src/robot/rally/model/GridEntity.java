package robot.rally.model;


public abstract class GridEntity {

		int location[][];
		
		public GridEntity() 
		{
			//constructor for grid entities
		}
		
		
		public void activate(Board currentBoard,int location[][], Board updatedBoard)
		{
		//activate class to be called by the simulator when going through the board
		}
		
		
}




