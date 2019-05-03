package robot.rally.model;

import org.junit.Test;

/**
 * This is the abstract class used to represent any entity that lies on the grid. It holds a location
 * and has an abstract activate method.
 *
 * @author Team18.
 *
 */

public abstract class GridEntity {

		int locationX;
		int locationY;

		/**
		 * This is the constructor a GridEntity.
		 *
		 * @param x This is the Row the GridEntity will be placed on upon creation.
		 * @param y This is the Column the GridEntity will be placed on upon creation.
		 */

		public GridEntity(int x, int y)
		{
			locationX = x;
			locationY = y;
		}

		/**
		 * This is the abstract method for every GridEntity.
		 *
		 * @param currentBoard This is the current {@link Board} {@link GridEntity}s lie on.
		 * @param locationX This is the Row index for the position on the {@link Board}.
		 * @param locationY This is the Column index for the position on the {@link Board}.
		 * @param updatedBoard This is the updated state of the {@link Board} after activation.
		 * @param robot This is the {@link Robot} being affected by activation of the {@link GridEntity}.
		 */

		public abstract void activate(Board currentBoard,int locationX, int locationY, Board updatedBoard, Robot robot);

		/**
		 * This returns the Row for the GridEntity.
		 *
		 * @return The X Location/Row on the Board.
		 */

		public int getLocationX() { // Gets X location
			return locationX;
		}

		/**
		 * This returns the Column for the GridEntity.
		 *
		 * @return The Y Location/Column on the Board.
		 */

		public int getLocationY() { // Gets y location
			return locationY;
		}

}




