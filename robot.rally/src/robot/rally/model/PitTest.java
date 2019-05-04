package robot.rally.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PitTest {

	@Test
	public void test() {
		Board board = new Board(2, 2);
		Pit pit = new Pit(1, 1);
		Robot robot = new Robot(1, 1);
		pit.activate(board, 1, 1, robot);
		assertTrue(!robot.isAlive);
	}

}
